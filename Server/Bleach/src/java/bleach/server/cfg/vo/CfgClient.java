/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author LiuQiao
 */
public class CfgClient 
{
    private List<CfgNode> nodes = null;
    
    public CfgClient()
    {
        nodes = new ArrayList<CfgNode>();
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
    }
}
