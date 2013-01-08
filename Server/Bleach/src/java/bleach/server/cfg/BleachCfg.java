/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg;

import bleach.server.cfg.vo.CfgClient;
import bleach.server.cfg.vo.CfgProtocol;
import bleach.server.cfg.vo.CfgResource;
import java.util.List;

/**
 *
 * @author LiuQiao
 */
public class BleachCfg
{
    private static CfgClient client = null;
    private static CfgResource resource = null;
    private static List<CfgProtocol> protocols = null;

    /**
     * @return the client
     */
    public static CfgClient getClient() 
    {
        return client;
    }

    /**
     * @param client the client to set
     */
    public static void setClient(CfgClient value) 
    {
        client = value;
    }

    /**
     * @return the resource
     */
    public static CfgResource getResource() 
    {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public static void setResource(CfgResource value) 
    {
        resource = value;
    }

    /**
     * @return the protocols
     */
    public static List<CfgProtocol> getProtocols() 
    {
        return protocols;
    }

    /**
     * @param aProtocols the protocols to set
     */
    public static void setProtocols(List<CfgProtocol> value) 
    {
        protocols = value;
    }
    
    
}
