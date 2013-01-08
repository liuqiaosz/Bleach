/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.vo;

/**
 *
 * @author LiuQiao
 */
public class CfgPropertie
{
    private String name = "";
    private String path = "";
    private String parser = "";
    private String desc = "";
    
    public CfgPropertie()
    {}
    
    public CfgPropertie(String name,String path,String parser,String desc)
    {
        this.name = name;
        this.path = path;
        this.parser = parser;
        this.desc = desc;
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
     * @return the path
     */
    public String getPath()
    {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path)
    {
        this.path = path;
    }

    /**
     * @return the parser
     */
    public String getParser()
    {
        return parser;
    }

    /**
     * @param parser the parser to set
     */
    public void setParser(String parser)
    {
        this.parser = parser;
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
    
}
