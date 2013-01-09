/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.parser;

import bleach.server.cfg.Global;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 *
 * @author LiuQiao
 */
public abstract class BleachGenericParser implements IBleachParser
{
    @Override
    public final Object parse(String path)throws Exception
    {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(path);
        return process(doc);
    }
    
    abstract protected Object process(Document doc)throws Exception;
}
