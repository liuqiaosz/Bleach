/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author LiuQiao
 */
public class CfgClient 
{
    private List<CfgNode> nodes = null;
    private Map<String,CfgNode> nodeMap = null;
    public CfgClient()
    {
        nodes = new ArrayList<CfgNode>();
        nodeMap = new HashMap<String,CfgNode>();
    }

    /**
     * @return the nodes
     */
    public List<CfgNode> getNodes()
    {
        return nodes;
    }

    /**
     * @param nodes the nodes to set
     */
    public void setNodes(List<CfgNode> nodes)
    {
        this.nodes = nodes;
    }
    
    public void addNode(CfgNode node)
    {
        nodes.add(node);
        getNodeMap().put(node.getName(), node);
    }

    /**
     * @return the nodeMap
     */
    public Map<String,CfgNode> getNodeMap()
    {
        return nodeMap;
    }

    /**
     * @param nodeMap the nodeMap to set
     */
    public void setNodeMap(Map<String,CfgNode> nodeMap)
    {
        this.nodeMap = nodeMap;
    }
    
    
}
