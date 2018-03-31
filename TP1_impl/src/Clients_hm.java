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
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


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
                .setTelephone(ssn[3])
                .setRue(ssn[4])
                .setVille(ssn[5])
                .setEtat(ssn[6])
                .setCode(ssn[7])
                .setPays(ssn[8])
                .setMail(ssn[9])
                .build();
        clients_hm.put(c.getId(), c);  
        
    }
    
    /**
     *
     */
    public void displayClients(){
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        clients_hm.values().forEach((cc) -> {
            System.out.println(cc.getId() + "\t" + cc.getPrenom() + "\t" + cc.getNom() + "\t" + cc.getTelephone() + "\t" + cc.getRue()+ "\t" + cc.getVille()  + "\t" + cc.getEtat()  + "\t" + cc.getCode()  + "\t" + cc.getPays() + "\t"  + cc.getMail());
        });
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
    }    
        
    public void displayClient(Client c){
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        System.out.println(c.getId() + "\t" + c.getPrenom() + "\t" + c.getNom() + "\t" + c.getTelephone() + "\t" + c.getRue()+ "\t" + c.getVille()  + "\t" + c.getEtat()  + "\t" + c.getCode()  + "\t" + c.getPays() + "\t"  + c.getMail());
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
    }     
    
     public void displayClientsList(HashMap<String,Client> result){
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        result.values().forEach((cc) -> {
            System.out.println(cc.getId() + "\t" + cc.getPrenom() + "\t" + cc.getNom() + "\t" + cc.getTelephone() + "\t" + cc.getRue()+ "\t" + cc.getVille()  + "\t" + cc.getEtat()  + "\t" + cc.getCode()  + "\t" + cc.getPays() + "\t"  + cc.getMail());
        });
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
    } 
    
    public  Client findClient (String id) {
        return clients_hm.get(id);
    }
    
    /**
     *
     * @param prenom
     * @return
     */
    public  HashMap <String,Client> findClients (String prenom) {
       HashMap <String,Client> result;
        result = (HashMap <String,Client>) clients_hm.entrySet()
                .stream()
                .filter(map -> prenom.equals(map.getValue().getPrenom()))
      .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        return result;
    }  
    
    public  HashMap <String,Client> findClientsNom (String nom) {
       HashMap <String,Client> result;
        result = (HashMap <String,Client>) clients_hm.entrySet()
                .stream()
                .filter(map -> nom.equals(map.getValue().getNom()))
      .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        return result;
    }  
    
    public  void updateClient(Client c){  
      Client c1;
        Scanner kb = new Scanner(System.in); 
      int n;  
      String data;
      String[][] newdata = new String[1][10];
      newdata[0][0]=c.getId();
      newdata[0][1]=c.getPrenom();
      newdata[0][2]=c.getNom();
      newdata[0][3]=c.getTelephone();
      newdata[0][4]=c.getRue();
      newdata[0][5]=c.getVille();
      newdata[0][6]=c.getEtat();
      newdata[0][7]=c.getCode();
      newdata[0][8]=c.getPays();
      newdata[0][9]=c.getMail();
      System.out.println("Usage : tel: 3 - rue: 4 - ville: 5 - etat: 6 - code: 7 - pays: 8 - mail: 9 et -1 pour arrêter"); 
      while (true) {
        System.out.println("saisir le numéro de la colonne à modifier:");  
        n = kb.nextInt();
        if (n==-1)
            break;
        System.out.println("saisir la nouvelle donnée:");
        kb.nextLine();
        data = kb.nextLine();
        newdata[0][n]= data;
    }
  
    c1 = new Client.ClientBuilder(newdata[0][0], newdata[0][1],newdata[0][2] )
            .setTelephone(newdata[0][3])  
            .setRue(newdata[0][4])
            .setVille(newdata[0][5])
            .setEtat(newdata[0][6])
            .setCode(newdata[0][7])    
            .setPays(newdata[0][8])             
            .setMail(newdata[0][9])
            .build();
      clients_hm.replace(c.getId(), c, c1);    
    }
    
    /**
     *
     * @param id
     */
    public  void removeClient (String id) {
        clients_hm.remove(id);
    }
}