/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeina
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuPrincipal<D> implements Runnable {

    Source eventManager;

    public MenuPrincipal(Source<D> s) {
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
        System.out.println("1 - Créer");
        System.out.println("2 - Mise à jour");
        System.out.println("3 - Suprimer");
        System.out.println("4 - Consulter");
        System.out.print("Choisir : ");

        selection = input.nextInt();
        return selection;
    }

    @Override
    public void run() {
        GEvent ev=eventManager.genEvent("Aucune réponse connue");
        int choix = 0;
        Thread t = null;
        Menu_creer mc;
        Menu_modifier mmod;
        Menu_suprimer ms;
        Menu_consulter mcons;
        try {
            while ((choix = menu()) != 0) {
                switch (choix) {
                    case 1:
                        ev = eventManager.genEvent("Créer");
                        mc = new Menu_creer(eventManager);
                        eventManager.addGEventListener((gEvent) -> gEvent.getData());
                        t = new Thread(mc);
                        break;
                    case 2:
                        ev = eventManager.genEvent("MAJ");
                        mmod = new Menu_modifier(eventManager);
                        eventManager.addGEventListener((gEvent) -> gEvent.getData());
                        t = new Thread(mmod);
                        break;
                    case 3:
                        ev = eventManager.genEvent("Suprimer");
                        ms= new Menu_suprimer(eventManager);
                        eventManager.addGEventListener((gEvent) -> gEvent.getData());
                        t = new Thread(ms);
                        break;
                    case 4:
                        ev = eventManager.genEvent("Consulter");
                        mcons= new Menu_consulter(eventManager);
                        eventManager.addGEventListener((gEvent) -> gEvent.getData());
                        t = new Thread(mcons);
                        break;
                }
                t.start();
                t.join();
                if (ev != null) {
                    eventManager.dispatch(ev);
                }
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (choix == 0)
            System.exit(0);
    }
}