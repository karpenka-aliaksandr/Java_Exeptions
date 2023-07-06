package Commands.ControlllerCommands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import Commands.ControlllerCommands.Base.ControllerCommand;
import Controllers.Controller;
import Menu.Menu;
import Views.Screen;
import Views.View;

public class InputData extends ControllerCommand {

    public InputData(Controller controller) {
        super(controller);
    }

    @Override
    public void execute() {
        Screen screen = controller.getScreen();
        View view = screen.getView();
        Menu menu = screen.getMenu();
        screen.setMenu(new Menu());
        screen.setBar("Введите Фамилию, имя, отчество и номер телефона(только цифры) через пробел: ");
        String data = view.getString();
        String[] subData = data.split("\\s");
        String surname = null;
        String name = null;
        String lastname = null;
        String phone = null;
        try {
            if (subData.length < 4) {
                throw new DataWrongExeption("Не достаточно данных.");
            }
            if (subData.length > 4) {
                throw new DataWrongExeption("Данных слишком много.");
            }
            surname = subData[0];
            boolean hasDigits = false;
            for (int i = 0; i < surname.length() && !hasDigits; i++) {
                if (Character.isDigit(surname.charAt(i))) {
                    hasDigits = true;
                }
            }
            if (hasDigits)
                throw new DataWrongExeption("В фамилии есть цифры.");
            name = subData[1];
            hasDigits = false;
            for (int i = 0; i < name.length() && !hasDigits; i++) {
                if (Character.isDigit(name.charAt(i))) {
                    hasDigits = true;
                }
            }
            if (hasDigits)
                throw new DataWrongExeption("В имени есть цифры.");
            lastname = subData[2];
            hasDigits = false;
            for (int i = 0; i < lastname.length() && !hasDigits; i++) {
                if (Character.isDigit(lastname.charAt(i))) {
                    hasDigits = true;
                }
            }
            if (hasDigits)
                throw new DataWrongExeption("В отчестве есть цифры.");
            phone = subData[3];
            boolean isOnlyDigits = true;
            for (int i = 0; i < phone.length() && isOnlyDigits; i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    isOnlyDigits = false;
                }
            }
            if (!isOnlyDigits)
                throw new DataWrongExeption(String.format("В номере телефона '%s' - есть символы помимо цифр.",phone));

                String fileName = String.format("%s.txt", surname);
                try {
                    File file = new File("HomeWork03/Files", fileName);
                    FileWriter fw = new FileWriter(file,true);
                    fw.write(String.format("%s %s %s %s\n", surname, name, lastname, phone));
                    fw.flush();
                    fw.close();
                    screen.setBar("Данные успешно cохранены");
                } catch (Exception e) {
                    screen.setBar(String.format("Не удалось сохранить данные. \n")) ;
                    e.printStackTrace();
                }

        } catch (DataWrongExeption de) {
            screen.setBar(de.toString());
        }
        
        
        

        screen.setMenu(menu);

        // try {
        // File file = new File("HomeWork05/", fileName);
        // FileReader fr = new FileReader(file);
        // BufferedReader reader = new BufferedReader(fr);

        // String lastname = reader.readLine();
        // while (lastname != null) {
        // String firstname = reader.readLine();
        // String middlename = reader.readLine();
        // String telnumber = reader.readLine();
        // String emailaddr = reader.readLine();
        // controller.getPhonebook()
        // .addContact(new Contact(lastname, firstname, middlename, telnumber,
        // emailaddr));

        // lastname = reader.readLine();
        // }
        // reader.close();
        // fr.close();
        // screen.setBar("Cправочник успешно загружен");
        // } catch (Exception e) {
        // screen.setBar("Не удалось загрузить справочник");
        // e.printStackTrace();
        // }
        // screen.setData(controller.getPhonebook().toString());
        // screen.setMenu(menu);
    }

}

class DataWrongExeption extends Exception {
    public DataWrongExeption(String message) {
        super(message);
    }
}
