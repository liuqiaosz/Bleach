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
public class CfgWorld
{
    private String name = "";
    private List<CfgScene> scenes = null;
    public CfgWorld()
    {
        scenes = new ArrayList<CfgScene>();
    }
    
    public CfgWorld(String name)
    {
        this.name = name;
        scenes = new ArrayList<CfgScene>();
    }

    /**
     * @return the scenes
     */
    public List<CfgScene> getScenes()
    {
        return scenes;
    }

    /**
     * @param scenes the scenes to set
     */
    public void setScenes(List<CfgScene> scenes) 
    {
        this.scenes = scenes;
    }
    
    public void addScene(CfgScene scene)
    {
        scenes.add(scene);
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
    
}
