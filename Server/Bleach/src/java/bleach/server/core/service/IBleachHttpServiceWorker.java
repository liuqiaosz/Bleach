/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.core.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuQiao
 */
public interface IBleachHttpServiceWorker
{
    void service(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
