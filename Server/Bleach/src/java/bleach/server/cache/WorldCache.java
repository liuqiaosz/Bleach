/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LiuQiao
 */
public class WorldCache
{
    //世界名称
    private String name = "";
    //场景数据列表
    private List<SceneCache> scenes = null;
    private Map<String,SceneCache> sceneMap = null;
    
    public WorldCache()
    {
        scenes = new ArrayList<SceneCache>();
        sceneMap = new HashMap<String,SceneCache>();
    }
    
    public WorldCache(String name)
    {
        this.name = name;
        scenes = new ArrayList<SceneCache>();
        sceneMap = new HashMap<String,SceneCache>();
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
     * @return the scenes
     */
    public List<SceneCache> getScenes()
    {
        return scenes;
    }

    /**
     * @param scenes the scenes to set
     */
    public void setScenes(List<SceneCache> scenes)
    {
        this.scenes = scenes;
    }
    
    public void addScene(SceneCache scene)
    {
        this.scenes.add(scene);
        sceneMap.put(scene.getName(), scene);
    }
    
    public SceneCache findSceneByName(String name)
    {
        return sceneMap.get(name);
    }
}
