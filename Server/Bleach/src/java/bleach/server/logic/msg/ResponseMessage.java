/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.logic.msg;

/**
 *
 * @author LiuQiao
 */
public class ResponseMessage extends Message
{
    private String respCode = "0000";

    /**
     * @return the respCode
     */
    public String getRespCode()
    {
        return respCode;
    }

    /**
     * @param respCode the respCode to set
     */
    public void setRespCode(String respCode)
    {
        this.respCode = respCode;
    }
    
}
