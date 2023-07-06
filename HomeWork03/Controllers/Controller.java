package Controllers;

import Commands.ControlllerCommands.MakeMainMenuCommand;
import Menu.PunktMenu;
import Views.View;
import Views.Screen;

public class Controller {
    boolean exitApp;
    Screen screen;
    View view;

    public Controller(Screen screen) {
        this.screen = screen;
        this.view = screen.getView();
        this.exitApp = false;
    }

    public void run() {

        new MakeMainMenuCommand(this).execute();
        while (!exitApp) {
            screen.show();
            int numPunkt = view.getPositiveInt();
            PunktMenu pm = screen.getMenu().getPunkt(numPunkt);
            if (pm == null) {
                screen.setBar("Неправильный выбор");
            } else {
                pm.run();
            }
        }

    }

    public Screen getScreen() {
        return this.screen;
    }

    public void setExitApp() {
        this.exitApp = true;
    }

}
