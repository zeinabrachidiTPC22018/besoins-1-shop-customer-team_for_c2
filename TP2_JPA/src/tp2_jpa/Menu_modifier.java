/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_jpa;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zeina
 * @param <D>
 */

public class Menu_modifier<D> implements Runnable , GEventListener{

    Source eventManager;

    public Menu_modifier(Source<D> s) {
        eventManager = s;
    }
    public int menu() throws IOException {

        int selection;
        //Ceci efface en principe un écran (console) Linux et Windows
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < 50; ++i) System.out.println();
        Scanner input = new Scanner(System.in);

        /**
         * ************************************************
         */
        System.out.println("0 - Quitter");
        System.out.println("-------------------------");
        System.out.println("1 - Modifier Client");
        System.out.println("2 - Afficher clients");
        System.out.println("3 - Retourner au menu principal");
        System.out.print("Choisir : ");

        selection = input.nextInt();
        return selection;
    }

    @Override
    public void run() {
        int choix = 0;
        MenuPrincipal mp;
        Clients_hm chm;
        Client c;
        Scanner kb;
        String s ;
        GEvent ev=eventManager.genEvent("Aucune réponse connue");
        try {
            while ((choix = menu()) != 0) {
                switch (choix) {
                    case 1:
                        ev = eventManager.genEvent("Modifier Client");
                        chm= new Clients_hm();
                        kb = new Scanner(System.in);       
                        System.out.println("saisir id du client à modifier");
                        s = kb.nextLine();
                        c=chm.findClient(s);
                        if (c != null) {
                           chm.displayClient(c);
                           chm.updateClient(c);
                        }
                        else {
                            System.out.println("Client not found");
                            s = kb.nextLine();
                        }   
                        break;
                    case 2:
                        ev = eventManager.genEvent("Afficher clients");
                        chm= new Clients_hm();
                        chm.displayClients();
                        break;
                    case 3:
                        ev = eventManager.genEvent("Retourner au menu principal");
                        mp = new MenuPrincipal(eventManager);
                        eventManager.addGEventListener((gEvent) -> gEvent.getData());
                        Thread t = new Thread(mp);
                        t.start();
                        t.join();
                        break;
                }
                if (ev != null) {
                    eventManager.dispatch(ev);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu_creer.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (choix == 0)
            System.exit(0);
    }

    @Override
    public void action(GEvent ev) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

