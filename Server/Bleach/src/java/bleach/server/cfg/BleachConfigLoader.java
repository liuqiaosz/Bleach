/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg;
import bleach.server.cfg.parser.IBleachParser;
import bleach.server.cfg.vo.CfgPropertie;
import bleach.server.utils.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 主配置加载
 * @author LiuQiao
 */
public class BleachConfigLoader 
{
    private Logger logger = Logger.getLogger(
            BleachConfigLoader.class.getName());
    
    private static BleachConfigLoader loader = new BleachConfigLoader();
    
    private Map<String,CfgPropertie> cache = null;
    private BleachConfigLoader()
    {
        cache = new HashMap<String,CfgPropertie>();
    }
    
    /**
     * 刷新主配置
     * @param cfg
     * @throws Exception 
     */
    public void refresh(String cfg)throws Exception
    {
        logger.info("加载主配置:" + cfg);
        
        SAXReader reader = new SAXReader();
        Document doc = reader.read(cfg);
        Element docRoot = doc.getRootElement();
        
        Element propertiesNode = docRoot.element(Constants.XML_NODE_CFGPROPERTIES);
        Iterator propertieIt = propertiesNode.elementIterator();
        while(propertieIt.hasNext())
        {
            try
            {
                Element propertieNode = (Element)propertieIt.next();

                CfgPropertie propertie = new CfgPropertie(
                        propertieNode.attributeValue(Constants.XML_NODE_NAME),
                        propertieNode.attributeValue(Constants.XML_NODE_PATH),
                        propertieNode.attributeValue(Constants.XML_NODE_PARSER),
                        propertieNode.attributeValue(Constants.XML_NODE_DESC)
                        );

                cache.put(propertie.getName(), propertie);

                logger.info("配置节点[" + propertie.getName() + "]");
                logger.info("配置文件[" + Global.context + propertie.getPath() + "]");
                logger.info("配置解析器[" + propertie.getParser() + "]");
                
                IBleachParser parser = (IBleachParser)Class.forName(propertie.getParser()).newInstance();
                parser.parse(Global.context + propertie.getPath());
                logger.info("配置解析完毕....");
            }
            catch(Exception ex)
            {
                logger.error("加载异常");
                logger.error(ex,ex);
            }
            
        }
        
//        logger.info("客户端配置加载...");
//        //客户端配置加载
//        Element clientNode = docRoot.element(Constants.XML_NODE_CLIENT);
//        BleachCfg.setClient(clientParse(clientNode));
//        
//        logger.info("资源配置加载...");
//        //资源定义加载
//        Element resourceNode = docRoot.element(Constants.XML_NODE_RESOURCE);
//        BleachCfg.setResource(resourceParse(resourceNode));
//        
//        logger.info("加载完毕...");
    }
    
    /**
     * 刷新单个配置节点
     * @param propertieName 
     */
    public void refreshPropertie(String propertieName)
    {
        if(cache.containsKey(propertieName))
        {
            
        }
    }
    
    
    public static BleachConfigLoader getInstance()
    {
        return loader;
    }
    
    /**
     * 主配置重载
     */
    public static void cfgReload(String cfg) throws Exception
    {
        loader.refresh(cfg);
    }
}
