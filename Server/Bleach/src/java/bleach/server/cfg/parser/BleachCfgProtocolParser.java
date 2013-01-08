/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.parser;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.vo.CfgProtocol;
import bleach.server.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * 通讯协议配置解析
 * @author LiuQiao
 */
public class BleachCfgProtocolParser extends BleachGenericParser
{
    @Override
    protected void process(Document doc) throws Exception 
    {
        List<CfgProtocol> protocols = new ArrayList<CfgProtocol>();
        Element root = doc.getRootElement();
        Iterator protocolIt = root.elementIterator();
        Element protocolNode;
        CfgProtocol protocol;
        Iterator paramIt;
        Element paramNode;
        while(protocolIt.hasNext())
        {
            protocolNode = (Element)protocolIt.next();
            protocol = new CfgProtocol(
                    protocolNode.attributeValue(Constants.XML_NODE_TYPE),
                    protocolNode.attributeValue(Constants.XML_NODE_ACTION));
            
            paramIt = protocolNode.elementIterator();
            while(paramIt.hasNext())
            {
                paramNode = (Element)paramIt.next();
                protocol.addInitParam(
                        paramNode.attributeValue(Constants.XML_NODE_NAME), 
                        paramNode.attributeValue(Constants.XML_NODE_VALUE));
            }
            
            protocols.add(protocol);
        }
        BleachCfg.setProtocols(protocols);
    }
}
