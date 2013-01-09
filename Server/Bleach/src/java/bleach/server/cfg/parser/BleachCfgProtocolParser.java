/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.parser;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.Global;
import bleach.server.cfg.vo.CfgLogic;
import bleach.server.cfg.vo.CfgProtocol;
import bleach.server.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * 通讯协议配置解析
 *
 * @author LiuQiao
 */
public class BleachCfgProtocolParser extends BleachGenericParser
{

    private Logger logger = Logger.getLogger(BleachCfgProtocolParser.class.getName());

    @Override
    protected Object process(Document doc) throws Exception
    {
        logger.info("通讯协议配置解析开始...");
        List<CfgProtocol> protocols = new ArrayList<CfgProtocol>();
        Element root = doc.getRootElement();
        Iterator protocolIt = root.elementIterator();
        Element protocolNode;
        CfgProtocol protocol;
        Iterator paramIt;
        Iterator logicIt;
        Element paramNode;
        Element logicNode;
        while (protocolIt.hasNext())
        {
            protocolNode = (Element) protocolIt.next();
            protocol = new CfgProtocol(
                    protocolNode.attributeValue(Constants.XML_NODE_TYPE),
                    protocolNode.attributeValue(Constants.XML_NODE_ACTION));

            paramIt = protocolNode.elementIterator(
                    Constants.XML_NODE_INITPARAM);
            while (paramIt.hasNext())
            {
                paramNode = (Element) paramIt.next();
                protocol.addInitParam(
                        paramNode.attributeValue(Constants.XML_NODE_NAME),
                        paramNode.attributeValue(Constants.XML_NODE_VALUE));
            }

            logicIt = protocolNode.elementIterator(Constants.XML_NODE_LOGIC);
            String cfgNav = "";
            String cfgAuth = "";
            while (logicIt.hasNext())
            {
                logicNode = (Element) logicIt.next();
                try
                {
                    IBleachParser parser = (IBleachParser) Class.forName(
                            logicNode.attributeValue(Constants.XML_NODE_PARSER)).newInstance();
                    
                    paramIt = logicNode.elementIterator();
                    while(paramIt.hasNext())
                    {
                        paramNode = (Element)paramIt.next();
                        cfgNav = Global.context + paramNode.attributeValue(
                                Constants.XML_NODE_VALUE);
                        logger.info("加载逻辑配置[" + cfgNav + "]");
                        protocol.addLogic((CfgLogic)parser.parse(cfgNav));
                    }
                }
                catch (Exception ex)
                {
                    logger.error("逻辑配置加载异常...");
                    logger.error(ex,ex);
                }
            }
            protocols.add(protocol);
        }
        //BleachCfg.setProtocols(protocols);
        logger.info("通讯协议配置解析完毕...");
        return protocols;
    }
}
