/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.logic.msg;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LiuQiao
 */
public class Message
{
    private Map<String,String> params = null;
    public Message()
    {
        params = new HashMap<String,String>();
    }
    public Message(Map<String,String> params)
    {
        this.params = params;
    }
    
    public void addParam(String name,String value)
    {
        params.put(name,value.trim());
    }
    public String getParam(String name)
    {
        return params.get(name);
    }
}
