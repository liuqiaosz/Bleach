/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.parser;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.vo.CfgResource;
import bleach.server.cfg.vo.CfgScene;
import bleach.server.cfg.vo.CfgTexture;
import bleach.server.cfg.vo.CfgUi;
import bleach.server.cfg.vo.CfgWorld;
import bleach.server.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * 客户端资源解析
 * @author LiuQiao
 */
public class BleachCfgResourceParser extends BleachGenericParser
{

    @Override
    protected Object process(Document doc) throws Exception 
    {
        Element resourceNode = doc.getRootElement();
        CfgResource resource = new CfgResource();
        
        Element texturesNode = resourceNode.element(Constants.XML_NODE_TEXTURES);
        Element worldsNode = resourceNode.element(Constants.XML_NODE_WORLDS);
        Element uisNode = resourceNode.element(Constants.XML_NODE_UIS);
        
        resource.setTextures(textureParse(texturesNode));
        resource.setWorlds(worldParse(worldsNode));
        resource.setUis(uiParse(uisNode));
        
        BleachCfg.setResource(resource);
        return resource;
    }
    
    /**
     * 纹理节点配置加载
     * @param texturesNode
     * @return 
     */
    private List<CfgTexture> textureParse(Element texturesNode)
    {
        List<CfgTexture> textures = new ArrayList<CfgTexture>();
        Iterator textureIt = texturesNode.elementIterator();
        Element textureNode;
        while(textureIt.hasNext())
        {
            textureNode = (Element)textureIt.next(); 
            textures.add(new CfgTexture(
                    textureNode.attributeValue(Constants.XML_NODE_NAME),
                    textureNode.attributeValue(Constants.XML_NODE_VER),
                    textureNode.attributeValue(Constants.XML_NODE_SOURCE)
                    ));
        }
        return textures;
    }
    
    /**
     * 世界数据配置加载
     * @param worldsNode
     * @return 
     */
    private List<CfgWorld> worldParse(Element worldsNode)
    {
        List<CfgWorld> worlds = new ArrayList<CfgWorld>();
        Iterator worldIt = worldsNode.elementIterator();
        Element worldNode;
        Iterator sceneIt;
        while(worldIt.hasNext())
        {
            worldNode = (Element)worldIt.next();
            CfgWorld world = new CfgWorld(worldNode.attributeValue(Constants.XML_NODE_NAME));
            sceneIt = worldNode.elementIterator();
            Element sceneNode;
            while(sceneIt.hasNext())
            {
                sceneNode = (Element)sceneIt.next();
                world.addScene(new CfgScene(
                        sceneNode.attributeValue(Constants.XML_NODE_NAME),
                        sceneNode.attributeValue(Constants.XML_NODE_VER),
                        sceneNode.attributeValue(Constants.XML_NODE_SOURCE)
                        ));
                
            }
            worlds.add(world);
        }
        return worlds;
    }
    
    private List<CfgUi> uiParse(Element uisNode)
    {
        List<CfgUi> uis = new ArrayList<CfgUi>();
        Iterator it = uisNode.elementIterator();
        Element uiNode;
        while(it.hasNext())
        {
            uiNode = (Element)it.next();
            uis.add(new CfgUi(
                    uiNode.attributeValue(Constants.XML_NODE_NAME),
                    uiNode.attributeValue(Constants.XML_NODE_VER),
                    uiNode.attributeValue(Constants.XML_NODE_SOURCE)
                    ));
            
        }
        return uis;
    }
}
