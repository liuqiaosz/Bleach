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
public class CfgProtocol 
{
    private String type = "";
    private String action = "";
    private Map<String,String> initParam = null;
    private List<CfgLogic> logics = null;
    
    public CfgProtocol()
    {
        initParam = new HashMap<String,String>();
        logics = new ArrayList<CfgLogic>();
    }
    
    public CfgProtocol(String type,String action)
    {
        this.type = type;
        this.action = action;
        initParam = new HashMap<String,String>();
        logics = new ArrayList<CfgLogic>();
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * @return the action
     */
    public String getAction() 
    {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) 
    {
        this.action = action;
    }

    /**
     * @return the initParam
     */
    public Map<String,String> getInitParam() 
    {
        return initParam;
    }

    /**
     * @param initParam the initParam to set
     */
    public void setInitParam(Map<String,String> initParam) 
    {
        this.initParam = initParam;
    }
    
    public void addInitParam(String name,String value)
    {
        initParam.put(name, value);
    }
    public String getInitParam(String name)
    {
        return initParam.get(name);
    }

    /**
     * @return the logics
     */
    public List<CfgLogic> getLogics()
    {
        return logics;
    }

    /**
     * @param logics the logics to set
     */
    public void setLogics(List<CfgLogic> logics)
    {
        this.logics = logics;
    }
    
    public void addLogic(CfgLogic logic)
    {
        this.logics.add(logic);
    }
}
