/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.core;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
/**
 *
 * @author LiuQiao
 */
public class BleachServiceFilter implements Filter
{
    private Logger logger = Logger.getLogger(BleachServiceFilter.class.getName());
    private String charset = "UTF-8";
    
    @Override
    public void destroy() 
    {
        logger.info("Service stop...");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        chain.doFilter(request, response);
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException 
    {
        String value = filterConfig.getInitParameter("Encode");
        if (null != value && !"".equals(value)) 
        {
            charset = value;
        }
    }
}
