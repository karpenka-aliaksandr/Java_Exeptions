package Commands.ControlllerCommands;
import Commands.ControlllerCommands.Base.ControllerCommand;
import Controllers.Controller;

public class NothingCommand extends ControllerCommand {
    
    public NothingCommand(Controller controller) {
        super(controller);
    }

    @Override
    public void execute() {
        controller.getScreen().setBar("Комманда ничего не делает");
    }
    
}
