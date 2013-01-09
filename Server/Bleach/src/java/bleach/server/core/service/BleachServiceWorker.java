/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.core.service;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.vo.CfgCommand;
import bleach.server.cfg.vo.CfgLogic;
import bleach.server.exception.InvalidMessageFormatException;
import bleach.server.logic.msg.ICommandMessageParser;
import bleach.server.logic.msg.Message;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author LiuQiao
 */
public abstract class BleachServiceWorker
{
    private static ICommandMessageParser parser = null;
    public BleachServiceWorker()
    {
        if(null == parser)
        {
            CfgLogic logic = BleachCfg.getLogic();
            if(null != logic)
            {
                try
                {
                    parser = (ICommandMessageParser)Class.forName(logic.getParser()).newInstance();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            
        }
    }
    
    /**
     * 对当前请求的命令进行权限较验
     *
     * @param request
     * @param response
     * @return
     */
    protected boolean checkCommandAuth(HttpServletRequest request)
    {
        return true;
    }
    
    protected Message encode(CfgCommand command,byte[] source)throws Exception
    {
        return parser.encode(command, source);
    }
    protected byte[] decode(CfgCommand command,Message message)throws InvalidMessageFormatException
    {
        return parser.decode(command, message);
    }
}
