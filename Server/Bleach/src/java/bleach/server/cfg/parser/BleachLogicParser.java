/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.parser;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.vo.CfgAttr;
import bleach.server.cfg.vo.CfgCommand;
import bleach.server.cfg.vo.CfgLogic;
import bleach.server.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * 逻辑配置解析
 *
 * @author LiuQiao
 */
public class BleachLogicParser extends BleachGenericParser
{

    @Override
    protected Object process(Document doc) throws Exception
    {
        Element root = doc.getRootElement();
        Iterator commandNodes = root.elementIterator();
        Element commandNode;
        //String cfgAuth = root.attributeValue(Constants.XML_NODE_AUTH);

        CfgLogic logic = new CfgLogic();
        logic.setParser(root.attributeValue(Constants.XML_NODE_PARSER));
        while (commandNodes.hasNext())
        {
            commandNode = (Element) commandNodes.next();
            CfgCommand command = new CfgCommand(
                    commandNode.attributeValue(Constants.XML_NODE_ID),
                    commandNode.attributeValue(Constants.XML_NODE_PROCESS),
                    commandNode.attributeValue(Constants.XML_NODE_DESC),
                    Boolean.parseBoolean(commandNode.attributeValue(Constants.XML_NODE_AUTH)));

            //加载该命令请求参数
            command.setRequest(parseAttr(commandNode.element(Constants.XML_NODE_REQ)));
            //加载该命令回应参数
            command.setResponse(parseAttr(commandNode.element(Constants.XML_NODE_RESP)));
            
            logic.addCommand(command);
        }
        
        BleachCfg.setLogic(logic);
        return logic;
    }

    private List<CfgAttr> parseAttr(Element commandNode)
    {
        Iterator attrIt = commandNode.elementIterator();
        Element attrNode;
        List<CfgAttr> attrs = new ArrayList<CfgAttr>();
        while (attrIt.hasNext())
        {
            attrNode = (Element) attrIt.next();

            attrs.add(new CfgAttr(
                    attrNode.attributeValue(Constants.XML_NODE_NAME),
                    Integer.parseInt(attrNode.attributeValue(Constants.XML_NODE_LENGTH)),
                    attrNode.attributeValue(Constants.XML_NODE_REQUIRED)));
        }
        return attrs;
    }
}
