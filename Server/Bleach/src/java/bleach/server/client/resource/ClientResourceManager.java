package bleach.server.client.resource;

import bleach.server.cache.ClientResourceCache;
import bleach.server.cache.SceneCache;
import bleach.server.cache.WorldCache;
import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.vo.CfgResource;
import bleach.server.cfg.vo.CfgScene;
import bleach.server.cfg.vo.CfgWorld;
import bleach.server.core.BleachService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 客户端资源管理
 * 
 * 从配置读取定义的配置并且加载
 * @author LiuQiao
 */
public class ClientResourceManager
{
    public static final int MAX_BUFFER = 2048;
    private Logger logger = Logger.getLogger(BleachService.class.getName());
    
    private static ClientResourceManager instance = new ClientResourceManager();
    private ClientResourceManager()
    {
        
    }
    
    public static ClientResourceManager getInstance()
    {
        return instance;
    }
    
    public void initializer()
    {
        refresh();
    }
    
    public void refresh()
    {
        initWorld();
    }
    
    /**
     * 初始化世界数据定义
     */
    private void initWorld()
    {
        List<WorldCache> cache = new ArrayList<WorldCache>();
        CfgResource resource = BleachCfg.getResource();
        //场景数据
        List<CfgWorld> worlds = resource.getWorlds();
        for(int idx=0; idx<worlds.size(); idx++)
        {
            CfgWorld cfg = worlds.get(idx);
            WorldCache world = new WorldCache();
            
            List<CfgScene> scenes = cfg.getScenes();
            for(int i=0; i<scenes.size(); i++)
            {
                CfgScene scene = scenes.get(i);
                byte[] data = openFile(scene.getSource());
                world.addScene(new SceneCache(
                        scene.getName(),
                        scene.getVersion(),
                        data
                        ));
            }
            cache.add(world);
        }
        ClientResourceCache.setWorlds(cache);
    }
    
    /**
     * 打开文件并且返回byte数组
     * @param path
     * @return 
     */
    private byte[] openFile(String path)
    {
        FileInputStream reader = null;
        File file = new File(path);
        if(!file.exists() || !file.isFile())
        {
            logger.error("加载的" + path + "不存在或不是文件");
            return null;
        }
        try
        {
            int len = (int)file.length();
            byte[] data = new byte[len];
            int readSeek = 0;
            int size = 0;
            //传统读取
            byte[] buffer = new byte[MAX_BUFFER];
            reader = new FileInputStream(file);
            while((size = reader.read(buffer)) != -1)
            {
                System.arraycopy(buffer, 0, data, readSeek, size);
                readSeek += size;
                if(readSeek == len)
                {
                    return data;
                }
            }
        }
        
        catch(Exception ex)
        {
            logger.error("文件读取异常...");
            logger.error(ex,ex);
        }
        finally
        {
            if(null != reader)
            {
                try
                {
                    reader.close();
                }
                catch(Exception ex)
                {
                    logger.error(ex,ex);
                }
            }
        }
        return null;
    }
}
