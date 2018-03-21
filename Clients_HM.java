/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeina
 */
import java.util.HashMap;
import java.util.Scanner;


public class Clients_HM implements Client_interface{
    static HashMap<String,Client> clients_hm;
    
    static  {
        clients_hm = new HashMap<>();
    }
        
    /**
     *
     * @param c
     */
    public void createClient(){
        Scanner kb = new Scanner(System.in);       
        System.out.println("saisir un client");
        System.out.println("Usage : Id- prénom - nom - tel - rue - ville - etat - code - pays - mail");
        System.out.println("Exemple : bob001 - Bob - Ducnam - 03240246 - Beyrouth"); 
        
        String s = kb.nextLine();
        String[] ss = s.split("-");
        Client c;
        c = new Client.ClientBuilder(ss[0], ss[1],ss[2] )
                .setRue(ss[3])
                .setCode(ss[4])
                .setEtat(ss[5])
                .setVille(ss[6])
                .setPays(ss[7])
                .setTelephone(ss[8])
                .setMail(ss[9])
                .build();
        clients_hm.put(c.getId(), c);
        
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public  Client findClient (String id) {
        return clients_hm.get(id);
    }
    
    public  void updateClient(Client c){
        //TODO
    }
    
    /**
     *
     * @param id
     */
    public  void removeClient (String id) {
        clients_hm.remove(id);
    }

    @Override
    public  void updateClient(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
