/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.parser;

/**
 *
 * @author LiuQiao
 */
public interface IBleachParser
{
    public Object parse(String path)throws Exception;
}
