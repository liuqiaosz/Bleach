/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.parser;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.vo.CfgClient;
import bleach.server.cfg.vo.CfgNode;
import bleach.server.cfg.vo.CfgParam;
import bleach.server.utils.Constants;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 客户端配置解析加载器
 * @author LiuQiao
 */
public class BleachClientCfgParser extends BleachGenericParser
{
    @Override
    protected Object process(Document doc) throws Exception 
    {
        Element root = doc.getRootElement();
        
        CfgClient client = new CfgClient();
        Iterator cfgNodeIt = root.elementIterator();
        String name = "";
        while(cfgNodeIt.hasNext())
        {
            Element cfgNode = (Element)cfgNodeIt.next();
            
            CfgNode node = new CfgNode();
            node.setName(cfgNode.attributeValue(Constants.XML_NODE_NAME));
            
            Iterator paramIt = cfgNode.elementIterator();
            while(paramIt.hasNext())
            {
                Element paramNode = (Element)paramIt.next();
                CfgParam param = new CfgParam(
                        paramNode.attributeValue(Constants.XML_NODE_NAME),
                        paramNode.attributeValue(Constants.XML_NODE_VALUE)
                        );
                node.addParam(param);
            }
            client.addNode(node);
        }
        BleachCfg.setClient(client);
        return client;
    }
    
}
