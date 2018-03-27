
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeina
 */
public class Test_menus {
    public static void main(String[] args) throws IOException {
        Main_menu mm = new Main_menu();
        Sub_Menu sm = new Sub_Menu();
        mm.addListener(sm);
        mm.Choose();
       
   }
}
