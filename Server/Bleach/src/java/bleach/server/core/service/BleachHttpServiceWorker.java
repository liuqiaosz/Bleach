/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.core.service;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.vo.CfgCommand;
import bleach.server.cfg.vo.CfgLogic;
import bleach.server.core.BleachService;
import bleach.server.exception.InvalidAuthException;
import bleach.server.exception.InvalidCommandException;
import bleach.server.logic.ILogic;
import bleach.server.logic.msg.Message;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * HTTP请求业务处理
 * @author LiuQiao
 */
public class BleachHttpServiceWorker extends BleachServiceWorker implements IBleachHttpServiceWorker
{
    private Logger logger = Logger.getLogger(BleachService.class.getName());
    private static Map<String,CfgCommand> commandCache = new HashMap<String,CfgCommand>();
    
    public void BleachHttpServiceWorker()
    {
        
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        InputStream reader;
        OutputStream writer;
        try
        {
            
            reader = request.getInputStream();
            byte[] byteLen = new byte[4];
            reader.read(byteLen);

            int length = Integer.parseInt(new String(byteLen));
            logger.debug("消息长度 [" + length + "]");

            byte[] msg = new byte[length];
            reader.read(msg);
            
            byte[] byteId = new byte[3];
            ByteBuffer buffer = ByteBuffer.allocate(msg.length);
            buffer.put(msg);
            buffer.position(0);
            buffer.get(byteId);
            String id = new String(byteId);

            logger.debug("命令 [" + id + "]");

            byte[] body = new byte[buffer.remaining()];
            buffer.get(body);
            buffer.clear();
            reader.close();
            CfgCommand command;
            
            if(commandCache.containsKey(id))
            {
                command = commandCache.get(id);
            }
            else
            {
                CfgLogic logic = BleachCfg.getLogic();
                
                if (null == logic)
                {
                    logger.error("非法命令");
                    throw new InvalidCommandException();
                }
                command = logic.getCommandMap().get(id);
                if (null == command)
                {
                    logger.error("非法命令");
                    throw new InvalidCommandException();
                }
                commandCache.put(id, command);
            }

            if (command.isAuth())
            {
                logger.debug("进行权限较验");
                //进行授权较验
                if (!checkCommandAuth(request))
                {
                    logger.error("权限较验失败");
                    //授权较验失败
                    throw new InvalidAuthException();
                }
            }
                
            Message requestMsg = encode(command, body);
            ILogic workLogic;
            workLogic = (ILogic) Class.forName(command.getProcess()).newInstance();
            Message responseMsg = workLogic.execute(requestMsg, request, response);
            byte[] responseData = decode(command, responseMsg);
            writer = response.getOutputStream();
            writer.write(responseData);
            writer.flush();
            writer.close();
        }
        catch (Exception ex)
        {
            logger.error(ex, ex);
        }
    }
}
