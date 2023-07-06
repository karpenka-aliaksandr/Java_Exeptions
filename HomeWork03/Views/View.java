package Views;
import java.util.Scanner;

public class View {
    Scanner scan;
    

    public View(Scanner scan) {
        this.scan = scan;
    }

    public int getPositiveInt() {
        String s = scan.nextLine();
        int x = -1;
        try {
            x = Integer.parseInt(s);   
        } catch (Exception e) {    
        }
        return x;
    }

    public String getString() {
        String s = scan.nextLine();
        return s;
    }

    public void print(String data){
        System.out.println(data);
    }
    

}
