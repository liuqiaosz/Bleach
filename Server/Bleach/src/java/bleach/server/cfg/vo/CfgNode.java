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
public class CfgNode 
{
    private String name = "";
    private List<CfgParam> params = null;
    private Map<String,CfgParam> paramMap = null;
    
    public CfgNode()
    {
        params = new ArrayList<CfgParam>();
        paramMap = new HashMap<String,CfgParam>();
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
        paramMap.put(param.getName(),param);
    }
    
    public CfgParam findParamByName(String name)
    {
        return paramMap.get(name);
    }
}
