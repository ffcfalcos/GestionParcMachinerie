package beans.views;

import beans.entities.Command;
import managers.CommandManagerInterface;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class RentsView implements Serializable {

    @Inject
    private CommandManagerInterface commandManager;
    private List<Command> commandList;

    @PostConstruct
    public void init() {
        this.commandList = Arrays.asList(commandManager.findAllCommands());
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

}
