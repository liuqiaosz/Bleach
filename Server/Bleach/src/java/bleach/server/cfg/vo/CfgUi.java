/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.vo;

/**
 *
 * @author LiuQiao
 */
public class CfgUi extends CfgNodeBase
{
    public CfgUi()
    {}
    public CfgUi(String name,String version,String source)
    {
        setName(name);
        setVersion(version);
        setSource(source);
    }
}
