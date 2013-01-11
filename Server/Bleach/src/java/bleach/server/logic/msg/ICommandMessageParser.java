/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.logic.msg;

import bleach.server.cfg.vo.CfgCommand;
import bleach.server.exception.InvalidMessageFormatException;

/**
 *
 * @author LiuQiao
 */
public interface ICommandMessageParser
{
    Message decode(CfgCommand command,byte[] source)throws InvalidMessageFormatException;
    byte[] encode(CfgCommand command,ResponseMessage message)throws InvalidMessageFormatException;
}
