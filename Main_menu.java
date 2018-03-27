
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeina
 */
public class Main_menu implements ChooseListener{
    private ArrayList<ChooseListener> listeners = new ArrayList<ChooseListener>();
    
    public void addListener(ChooseListener choice) {
           listeners.add(choice) ;
    }
    public void removeListener(ChooseListener choice) {
           listeners.remove(choice) ;
    }
    
    /**
     *
     * @throws IOException
     */
    public void Choose() throws IOException {
        System.out.println("in main menu");
        int choice=menu();
        listeners.forEach((c1) -> c1.MyChoice(choice));
       
    }
    
    public int menu() throws IOException {

        int selection;
        //Ceci efface en principe un écran (console) Linux et Windows
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
        Scanner input = new Scanner(System.in);

        /**
         * ************************************************
         */
        System.out.println("0 - Quitter");
        System.out.println("-------------------------");
        System.out.println("1 - Créer");
        System.out.println("2 - Mise à jour");
        System.out.println("3 - Suprimer");
        System.out.println("4 - Consulter");
        System.out.print("Choisir : ");

        selection = input.nextInt();
        return selection;
    }

    @Override
    public void MyChoice(int choice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
