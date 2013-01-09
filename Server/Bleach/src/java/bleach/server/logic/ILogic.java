/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.logic;

import bleach.server.logic.msg.Message;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuQiao
 */
public interface ILogic
{
    Message execute(Message message,HttpServletRequest request, HttpServletResponse response);
}
