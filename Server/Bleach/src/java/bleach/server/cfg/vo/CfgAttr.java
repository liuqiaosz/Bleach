/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.vo;

/**
 *
 * @author LiuQiao
 */
public class CfgAttr
{
    private String name = "";
    private int length = 0;
    private String required = "";
    
    public CfgAttr()
    {}
    public CfgAttr(String name,int length,String required)
    {
        this.name = name;
        this.length = length;
        this.required = required;
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
     * @return the length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * @return the required
     */
    public String getRequired()
    {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(String required)
    {
        this.required = required;
    }
    
}
