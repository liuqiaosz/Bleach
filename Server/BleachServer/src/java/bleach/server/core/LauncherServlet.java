/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.core;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuQiao
 */
public class LauncherServlet extends HttpServlet
{
    @Override
    public void init(ServletConfig config) throws ServletException 
    {
    }
    
    
    /**
     * 处理请求
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
}
