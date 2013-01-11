/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.logic;

import bleach.server.logic.msg.Message;
import bleach.server.logic.msg.ResponseMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author LiuQiao
 */
public class LogicAccountCreate extends LogicGeneric
{
    private Logger logger = Logger.getLogger(LogicAccountCreate.class.getName());
    @Override
    public ResponseMessage execute(Message message,HttpServletRequest request, HttpServletResponse response)
    {
        logger.info(message.getParam("accName"));
        logger.info(message.getParam("accPwd"));
        logger.info(message.getParam("nickName"));
        return null;
    }
    
}
