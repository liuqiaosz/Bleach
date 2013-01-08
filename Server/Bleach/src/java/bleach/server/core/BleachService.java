/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.core;

import bleach.server.cfg.BleachConfigLoader;
import bleach.server.cfg.Global;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doWork(request,response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doWork(request,response);
    }
    
    private void doWork(HttpServletRequest request, HttpServletResponse response)
    {
        String uri = request.getRequestURI();
        logger.info("请求[" + uri + "]");
    }
    
    @Override
    public void destroy() 
    {

    }
    
    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        try
        {
            String developerNav = config.getServletContext().getResource("/").getPath();
            logger.info("部署路径：" + developerNav);
            developerNav = "/Users/LiuQiao/Documents/Developer/Code/Bleach/Server/Bleach/web/";
            Global.context = developerNav;
            try
            {
                BleachConfigLoader.getInstance().refresh(developerNav + "WEB-INF/cfg/Bleach.xml");
            }
            catch(Exception ex)
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
