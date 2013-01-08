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
public class CfgNode 
{
    private String name = "";
    private List<CfgParam> params = null;
    
    public CfgNode()
    {
        params = new ArrayList<CfgParam>();
    }

    /**
     * @return the name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) 
    {
        this.name = name;
    }
    
    /**
     * @return the params
     */
    public List<CfgParam> getParams() 
    {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(List<CfgParam> params) 
    {
        this.params = params;
    }
    
    public void addParam(CfgParam param)
    {
        this.params.add(param);
    }
}
