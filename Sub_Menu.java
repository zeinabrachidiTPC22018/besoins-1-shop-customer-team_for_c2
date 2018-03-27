
import java.io.IOException;
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
public class Sub_Menu implements ChooseListener{
    @Override
    public void MyChoice(int choice) {
        int selection;
        Create_Menu cm ;
        Update_Menu um;
        Delete_Menu dm;
        Consult_Menu con_m;
        Main_menu mm;
        try {   
            while (choice != 0) {
                switch (choice) {
                    case 1:
                        cm = new Create_Menu();
                        mm = new Main_menu();
                        mm.addListener(cm);
                        cm.Choose();
                        break;
                    case 2:
                        um = new Update_Menu();
                        mm = new Main_menu();
                        mm.addListener(um);
                        um.Choose();    
                        break;
                    case 3:
                        dm = new Delete_Menu();
                        mm = new Main_menu();
                        mm.addListener(dm);
                        dm.Choose();
                        break;
                    case 4:
                        con_m = new Consult_Menu();
                        mm = new Main_menu();
                        mm.addListener(con_m);
                        con_m.Choose();
                        break;
                }
            }    
        } catch (IOException ex) {
            Logger.getLogger(Main_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

}
