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
public class CfgResource 
{
    private List<CfgTexture> textures = null;
    private List<CfgWorld> worlds = null;
    private List<CfgUi> uis = null;
    
    public CfgResource()
    {
    }

    /**
     * @return the textures
     */
    public List<CfgTexture> getTextures() 
    {
        return textures;
    }

    /**
     * @param textures the textures to set
     */
    public void setTextures(List<CfgTexture> textures) 
    {
        this.textures = textures;
    }

    /**
     * @return the worlds
     */
    public List<CfgWorld> getWorlds() 
    {
        return worlds;
    }

    /**
     * @param worlds the worlds to set
     */
    public void setWorlds(List<CfgWorld> worlds) 
    {
        this.worlds = worlds;
    }

    /**
     * @return the uis
     */
    public List<CfgUi> getUis() 
    {
        return uis;
    }

    /**
     * @param uis the uis to set
     */
    public void setUis(List<CfgUi> uis) 
    {
        this.uis = uis;
    }
    
    
}
