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


public class Clients_hm {
    static HashMap<String,Client> clients_hm;
    
    static  {
        clients_hm = new HashMap<>();
    }
    Client c;
     
    public void createClient(){
        Scanner kb = new Scanner(System.in);       
        System.out.println("saisir un client");
        System.out.println("Usage : Id - prénom - nom - tel - rue - ville - etat - code - pays - mail");
        System.out.println("Exemple : bob001 - Bob - Ducnam - 03240246 - eddeh - haret hreik - baabda - +0961 - Liban - Bob.Ducnam@isae.edu.lb"); 
        String s = kb.nextLine();
        String[] ss = s.split(" - ");
        String[] ssn = new String[10];
        System.arraycopy( ss, 0, ssn, 0, ss.length );
        if (ss.length < ssn.length)
           for (int i=ss.length; i<ssn.length;i++)
               ssn[i]="";
        c = new Client.ClientBuilder(ss[0], ss[1],ss[2] )
                .setRue(ssn[3])
                .setCode(ssn[4])
                .setEtat(ssn[5])
                .setVille(ssn[6])
                .setPays(ssn[7])
                .setTelephone(ssn[8])
                .setMail(ssn[9])
                .build();
        clients_hm.put(c.getId(), c);  
        
    }
    
    public void displayClients(){
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        clients_hm.values().forEach((cc) -> {
            System.out.println(cc.getId() + "\t" + cc.getPrenom() + "\t" + cc.getNom() + "\t" + cc.getRue()+ "\t" + cc.getVille()  + "\t" + cc.getEtat()  + "\t" + cc.getCode()  + "\t" + cc.getPays() + "\t"  + cc.getMail());
        });
    }    
        
    public void displayClient(Client c){
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        System.out.println(c.getId() + "\t" + c.getPrenom() + "\t" + c.getNom() + "\t" + c.getRue()+ "\t" + c.getVille()  + "\t" + c.getEtat()  + "\t" + c.getCode()  + "\t" + c.getPays() + "\t"  + c.getMail());
    }   
    
    
    public  Client findClient (String id) {
        return clients_hm.get(id);
    }
    
    public  void updateClient(Client c){  
        
    }
    
    /**
     *
     * @param id
     */
    public  void removeClient (String id) {
        clients_hm.remove(id);
    }
}

