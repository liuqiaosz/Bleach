/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.logic.msg;

import bleach.server.cfg.vo.CfgAttr;
import bleach.server.cfg.vo.CfgCommand;
import bleach.server.exception.InvalidMessageFormatException;
import bleach.server.utils.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author LiuQiao
 */
public class CommandMessageParser implements ICommandMessageParser
{
    private Logger logger = Logger.getLogger(CommandMessageParser.class.getName());
    @Override
    public Message decode(CfgCommand command,byte[] source) throws InvalidMessageFormatException
    {
        try
        {
            String str = new String(source);
            logger.info("消息体[" + str + "]");
            StringBuilder message = new StringBuilder(new String(source));
            int seek = 0;
            List<CfgAttr> attrs = command.getRequest();
            CfgAttr attr;
            Map<String, String> params = new HashMap<String, String>();
            for (int idx = 0; idx < attrs.size(); idx++)
            {
                attr = attrs.get(idx);
                int length = attr.getLength();
                params.put(attr.getName(), message.substring(seek, seek + length).trim());
                seek += length;
            }
            return new Message(params);
        }
        catch (Exception ex)
        {
            logger.error("消息解析异常");
            logger.error(ex, ex);
            throw new InvalidMessageFormatException();
        }
    }

    @Override
    public byte[] encode(CfgCommand command,ResponseMessage message) throws InvalidMessageFormatException
    {
        try
        {
            List<CfgAttr> attrs = command.getResponse();
            CfgAttr attr = null;
            StringBuilder str = new StringBuilder();
            String attrValue = "";

            str.append(command.getId());
            str.append(message.getRespCode());
            for (int idx = 0; idx < attrs.size(); idx++)
            {
                attr = attrs.get(idx);
                int length = attr.getLength();
                attrValue = message.getParam(attr.getName());
                if (attrValue.length() > length)
                {
                    attrValue = attrValue.substring(0, length);
                }
                else
                {
                    attrValue = StringUtils.leftPad(attrValue, length, Constants.STR_BLANK);
                }

                str.append(attrValue);
            }

            int msgLen = str.length();
            String len = StringUtils.leftPad("" + msgLen, 4, Constants.STR_ZERO);
            str.insert(0, len);
            String resp = str.toString();
            logger.info("消息[" + resp + "]");
            return resp.getBytes();
        }
        catch (Exception ex)
        {
            logger.error(ex,ex);
        }
        return null;
    }
    
}
