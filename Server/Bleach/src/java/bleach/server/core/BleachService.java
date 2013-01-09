/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.core;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.BleachConfigLoader;
import bleach.server.cfg.Global;
import bleach.server.cfg.vo.CfgCommand;
import bleach.server.core.service.IBleachHttpServiceWorker;
import bleach.server.logic.msg.ICommandMessageParser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author LiuQiao
 */
public class BleachService extends HttpServlet
{

    private Logger logger = Logger.getLogger(BleachService.class.getName());

    private Map<String,CfgCommand> commandCache = null;
    //private Map<String,Boolean> commandAuthCache = null;
    private ICommandMessageParser parser = null;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doWork(request, response);
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//    {
//        doWork(request,response);
//    }
    
    /**
     * 服务关闭
     */
    @Override
    public void destroy()
    {
        
    }
    
    protected void doWork(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            IBleachHttpServiceWorker service = (IBleachHttpServiceWorker)
                    Class.forName(BleachCfg.getHttpServiceWorker()).newInstance();
            service.service(request, response);
        }
        catch (Exception ex)
        {
            logger.error(ex, ex);
        }
    }

    /**
     * 全局初始化
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        try
        {
            //命令逻辑缓存
            commandCache = new HashMap<String,CfgCommand>();
            //命令授权缓存
            //commandAuthCache = new HashMap<String,Boolean>();

            String developerNav = config.getServletContext().getResource("/").getPath();
            logger.info("部署路径：" + developerNav);
            developerNav = "/Users/LiuQiao/Documents/Developer/Code/Bleach/Server/Bleach/web/";
            Global.context = developerNav;
            try
            {
                BleachConfigLoader.getInstance().refresh(developerNav + "WEB-INF/cfg/Bleach.xml");
            }
            catch (Exception ex)
            {
                logger.info("[ERROR]配置加载异常，中止程序...");
                this.destroy();
            }
        }
        catch (MalformedURLException ex)
        {
            logger.info("部署路径获取异常...");
        }
    }
}
