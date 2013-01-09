/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.vo;

import java.util.List;

/**
 *
 * @author LiuQiao
 */
public class CfgCommand
{
    private String id = "";
    private String process = "";
    private String desc = "";
    private boolean auth = true;
    
    private List<CfgAttr> request = null;
    private List<CfgAttr> response = null;
    
    public CfgCommand()
    {}
    
    public CfgCommand(String id,String process,String desc,boolean auth)
    {
        this.id = id;
        this.process = process;
        this.desc = desc;
        this.auth = auth;
    }

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return the process
     */
    public String getProcess()
    {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(String process)
    {
        this.process = process;
    }

    /**
     * @return the desc
     */
    public String getDesc()
    {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    /**
     * @return the request
     */
    public List<CfgAttr> getRequest()
    {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(List<CfgAttr> request)
    {
        this.request = request;
    }

    /**
     * @return the response
     */
    public List<CfgAttr> getResponse()
    {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(List<CfgAttr> response)
    {
        this.response = response;
    }

    /**
     * @return the auth
     */
    public boolean isAuth()
    {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(boolean auth)
    {
        this.auth = auth;
    }
    
    
}
