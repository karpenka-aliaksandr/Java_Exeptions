import java.util.Scanner;

import Controllers.Controller;
import Views.Screen;
import Views.View;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        View view = new View(scan);
        Screen screen = new Screen(view);
        Controller ctrl = new Controller(screen);
        ctrl.run();
        scan.close();
    }
}
