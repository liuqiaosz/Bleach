/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.logic;

import bleach.server.cfg.BleachCfg;
import bleach.server.cfg.vo.CfgNode;
import bleach.server.logic.msg.Message;
import bleach.server.logic.msg.ResponseMessage;
import bleach.server.utils.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下发客户端配置
 * @author LiuQiao
 */
public class LogicGetClientConfig extends LogicGeneric
{
    @Override
    public ResponseMessage execute(Message message, HttpServletRequest request, HttpServletResponse response)
    {
        ResponseMessage respMsg = new ResponseMessage();
        CfgNode node = BleachCfg.getClient().getNodeMap().get(Constants.MSG_MAIN_VER);
        respMsg.addParam(Constants.MSG_MAIN_VER,node.findParamByName(Constants.XML_NODE_VER).getValue());
        node = BleachCfg.getClient().getNodeMap().get(Constants.MSG_RSL_VER);
        respMsg.addParam(Constants.MSG_RSL_VER,node.findParamByName(Constants.XML_NODE_VER).getValue());
        node = BleachCfg.getClient().getNodeMap().get(Constants.MSG_MSG_VER);
        respMsg.addParam(Constants.MSG_MSG_VER,node.findParamByName(Constants.XML_NODE_VER).getValue());
        return respMsg;
    }
    
}
