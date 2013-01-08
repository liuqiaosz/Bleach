/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.vo;

/**
 *
 * @author LiuQiao
 */
public class CfgNodeBase 
{
    private String name = "";
    private String version = "";
    private String source = "";

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
     * @return the version
     */
    public String getVersion() 
    {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) 
    {
        this.version = version;
    }

    /**
     * @return the source
     */
    public String getSource()
    {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) 
    {
        this.source = source;
    }
    
    
}
