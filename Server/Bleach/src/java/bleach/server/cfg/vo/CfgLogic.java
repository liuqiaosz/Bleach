/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.cfg.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LiuQiao
 */
public class CfgLogic
{
    private List<CfgCommand> commands = null;
    private Map<String,CfgCommand> commandMap = null;
    private String parser = "";
    public CfgLogic()
    {
        commands = new ArrayList<CfgCommand>();
        commandMap = new HashMap<String,CfgCommand>();
    }

    /**
     * @return the commands
     */
    public List<CfgCommand> getCommands()
    {
        return commands;
    }

    /**
     * @param commands the commands to set
     */
    public void setCommands(List<CfgCommand> commands)
    {
        this.commands = commands;
    }
    
    public void addCommand(CfgCommand command)
    {
        commands.add(command);
        commandMap.put(command.getId(), command);
    }

    /**
     * @return the commandMap
     */
    public Map<String,CfgCommand> getCommandMap()
    {
        return commandMap;
    }

    /**
     * @param commandMap the commandMap to set
     */
    public void setCommandMap(Map<String,CfgCommand> commandMap)
    {
        this.commandMap = commandMap;
    }

    /**
     * @return the parser
     */
    public String getParser()
    {
        return parser;
    }

    /**
     * @param parser the parser to set
     */
    public void setParser(String parser)
    {
        this.parser = parser;
    }
    
}
