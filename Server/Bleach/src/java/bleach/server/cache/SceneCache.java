/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cache;

/**
 *
 * @author LiuQiao
 */
public class SceneCache
{
    private String name = "";
    private String version = "";
    private byte[] data = null;
    
    public SceneCache()
    {}
    
    public SceneCache(String name,String version,byte[] data)
    {
        this.name = name;
        this.version = version;
        this.data = data;
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
     * @return the data
     */
    public byte[] getData()
    {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(byte[] data)
    {
        this.data = data;
    }
    
    
}
