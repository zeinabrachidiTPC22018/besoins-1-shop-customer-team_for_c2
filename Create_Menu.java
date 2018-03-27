
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
public class Create_Menu implements ChooseListener{
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
        System.out.println("in create menu");
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
        System.out.println("1 - Ajouter Client");
        System.out.println("2 - Help");
        System.out.println("3 - Retourner au menu principal");
        System.out.print("Choisir : ");

        selection = input.nextInt();
        return selection;
    }

    @Override
    public void MyChoice(int choice) {
        int selection;
        Create_Menu cm ;
        Main_menu mm;
        try {   
            while (choice != 0) {
                switch (choice) {
                    case 1:
                       break;
                    case 2:
                        break;
                    case 3:
                        cm = new Create_Menu();
                        mm = new Main_menu();
                        cm.addListener(mm);
                        mm.Choose();
                        break;
                }
            }    
        } catch (IOException ex) {
            Logger.getLogger(Main_menu.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
