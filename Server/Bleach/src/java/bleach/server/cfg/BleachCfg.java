/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg;

import bleach.server.cfg.vo.CfgClient;
import bleach.server.cfg.vo.CfgLogic;
import bleach.server.cfg.vo.CfgResource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LiuQiao
 */
public class BleachCfg
{
    private static CfgClient client = null;
    private static CfgResource resource = null;
    //private static List<CfgProtocol> protocols = null;
    private static CfgLogic logic = null;
    private static String httpServiceWorker = "";
    private static String tcpServiceWorker = "";

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
     * @return the logic
     */
    public static CfgLogic getLogic()
    {
        return logic;
    }

    /**
     * @param aLogic the logic to set
     */
    public static void setLogic(CfgLogic aLogic)
    {
        logic = aLogic;
    }

    /**
     * @return the httpServiceWorker
     */
    public static String getHttpServiceWorker()
    {
        return httpServiceWorker;
    }

    /**
     * @param aHttpServiceWorker the httpServiceWorker to set
     */
    public static void setHttpServiceWorker(String aHttpServiceWorker)
    {
        httpServiceWorker = aHttpServiceWorker;
    }

    /**
     * @return the tcpServiceWorker
     */
    public static String getTcpServiceWorker()
    {
        return tcpServiceWorker;
    }

    /**
     * @param aTcpServiceWorker the tcpServiceWorker to set
     */
    public static void setTcpServiceWorker(String aTcpServiceWorker)
    {
        tcpServiceWorker = aTcpServiceWorker;
    }

    
    
    /**
     * @return the protocols
     */
//    public static List<CfgProtocol> getProtocols() 
//    {
//        return protocols;
//    }
//
//    /**
//     * @param aProtocols the protocols to set
//     */
//    public static void setProtocols(List<CfgProtocol> value) 
//    {
//        protocols = value;
//    }
}
