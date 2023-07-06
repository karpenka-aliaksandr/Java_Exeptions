package Commands.ControlllerCommands;
import Commands.ControlllerCommands.Base.ControllerCommand;
import Controllers.Controller;
import Menu.Menu;
import Menu.PunktMenu;


public class MakeMainMenuCommand extends ControllerCommand {
    public MakeMainMenuCommand(Controller controller) {
        super(controller);
    }

    @Override
    public void execute() {
        Menu menu = new Menu();
        menu.addPunkt(1,new PunktMenu("Ввести данные человека", new InputData(controller)));
        menu.addPunkt(0,new PunktMenu("Выход", new ExitAppCommand(controller)));
        controller.getScreen().setMenu(menu);
    }
    


    

    
}