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
public class ClientResourceCache
{
    private static List<WorldCache> worlds = new ArrayList<WorldCache>();
    private static Map<String,WorldCache> worldMap = new HashMap<String,WorldCache>();
    
    private ClientResourceCache()
    {}
    
    public static void setWorlds(List<WorldCache> value)
    {
        worlds = value;
        worldMap.clear();
        for(int idx=0; idx<worlds.size(); idx++)
        {
            WorldCache world = worlds.get(idx);
            worldMap.put(world.getName() , world);
        }
    }
    
    public static List<WorldCache> getWorlds()
    {
        return worlds;
    }
}
