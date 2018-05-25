/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_jpa;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zeina
 * @param <D>
 */
public class Menu_consulter<D> implements Runnable , GEventListener{

    Source eventManager;

    public Menu_consulter(Source<D> s) {
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
        System.out.println("1 - Consulter selon id");
        System.out.println("2 - consulter selon prénom");
        System.out.println("3 - consulter selon nom");
        System.out.println("4 - consulter selon pays");
        System.out.println("5 - consulter selon etat");
        System.out.println("6 - consulter selon ville");
        System.out.println("7 - consulter selon rue");
        System.out.println("8 - consulter selon code");
        System.out.println("9 - consulter selon telephone");
        System.out.println("10 - consulter selon mail");
        System.out.println("11 - Retourner au menu principal");
        System.out.print("Choisir : ");

        selection = input.nextInt();
        return selection;
    }

    @Override
    public void run() {
        int choix = 0;
        MenuPrincipal mp;
        Clients_hm chm;
        Client c = null;
        List<Client> result;
        Scanner kb = new Scanner(System.in);       
        String s ;
        GEvent ev=eventManager.genEvent("Aucune réponse connue");
        try {
            while ((choix = menu()) != 0) {
                switch (choix) {
                    case 1:
                        ev = eventManager.genEvent("Consulter selon id");
                        chm= new Clients_hm();
                        System.out.println("saisir id du client à afficher");
                        s = kb.nextLine();
                        c=chm.findClient(s);
                        if ( c != null) {
                            chm.displayClient(c);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine();
                        }
                        break;
                    case 2:
                        ev = eventManager.genEvent("consulter selon prénom");
                        chm= new Clients_hm();
                        System.out.println("saisir le prenom du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClients(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;
                    case 3:
                        ev = eventManager.genEvent("consulter selon nom");
                        chm= new Clients_hm();
                        System.out.println("saisir le nom du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClientsNom(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;
                    case 4:
                        ev = eventManager.genEvent("consulter selon pays");
                        chm= new Clients_hm();
                        System.out.println("saisir le pays du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClientsPays(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;
                    case 5:
                        ev = eventManager.genEvent("consulter selon etat");
                        chm= new Clients_hm();
                        System.out.println("saisir l'etat du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClientsEtat(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;
                    case 6:
                        ev = eventManager.genEvent("consulter selon ville");
                        chm= new Clients_hm();
                        System.out.println("saisir la ville du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClientsVille(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;
                    case 7:
                        ev = eventManager.genEvent("consulter selon rue");
                        chm= new Clients_hm();
                        System.out.println("saisir la rue du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClientsRue(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;
                    case 8:
                        ev = eventManager.genEvent("consulter selon code");
                        chm= new Clients_hm();
                        System.out.println("saisir le code du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClientsCode(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;
                    case 9:
                        ev = eventManager.genEvent("consulter selon téléphone");
                        chm= new Clients_hm();
                        System.out.println("saisir le téléphone du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClientsTelephone(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;
                    case 10:
                        ev = eventManager.genEvent("consulter selon mail");
                        chm= new Clients_hm();
                        System.out.println("saisir le mail du(es) client(s) à afficher");
                        s = kb.nextLine();
                        result=chm.findClientsMail(s);
                        if (result != null) {
                            chm.displayClientsList(result);
                        }
                        else {
                           System.out.println("Client not found");
                           s = kb.nextLine(); 
                        }
                        break;    
                    case 11 :
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


