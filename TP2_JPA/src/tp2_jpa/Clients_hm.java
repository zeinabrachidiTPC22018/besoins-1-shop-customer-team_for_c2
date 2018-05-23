
package tp2_jpa;

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
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Clients_hm {
    EntityManager em;
    EntityManagerFactory emf;
    Client c;
    List <Client> list;
    
    static HashMap<String,Client> clients_hm;
    
    static  {
        clients_hm = new HashMap<>();
    }
     
    public void createClient(){
        Scanner kb = new Scanner(System.in);       
        System.out.println("saisir un client");
        System.out.println("Usage : Id - prénom - nom - pays - etat - ville -  rue - code - tel  - mail");
        System.out.println("Exemple : bob001 - Bob - Ducnam - Liban - baabda - haret hreik - eddeh - +0961  - 03240246 - Bob.Ducnam@isae.edu.lb"); 
        String s = kb.nextLine();
        String[] ss = s.split(" - ");
        String[] ssn = new String[10];
        
        System.arraycopy( ss, 0, ssn, 0, ss.length );
        if (ss.length < ssn.length)
           for (int i=ss.length; i<ssn.length;i++)
               ssn[i]="";
        
        c = new Client.ClientBuilder(ss[0], ss[3].substring(0,3).toUpperCase(), ss[4].substring(0,3).toUpperCase())
                .setPrenom(ssn[1])
                .setNom(ssn[2])
                .setVille(ssn[5])
                .setRue(ssn[6])
                .setCode(ssn[7])
                .setTelephone(ssn[8])
                .setMail(ssn[9])
                .build();
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();    
    }
    
    /**
     *
     */
    public void displayClients(){  
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        
        list = em.createNamedQuery("Client.findAll", Client.class).getResultList();

        list.forEach((cc) -> {    clients_hm.put(c.getId(), c);        });          
        
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
    
    public  Client findClient (String _id) {
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findById", Client.class).getResultList();

        list.forEach((cc) -> {    clients_hm.put(c.getId(), c);        });          
       
        return clients_hm.get(_id);
    }
    
    /**
     *
     * @param _prenom
     * @return
     */
    public  HashMap <String,Client> findClients (String _prenom) {
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByPrenom", Client.class).getResultList();

        list.forEach((cc) -> {    clients_hm.put(c.getId(), c);        });    
        
        return clients_hm;
    }  
    
    public  HashMap <String,Client> findClientsNom (String _nom) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByNom", Client.class).getResultList();

        list.forEach((cc) -> {    clients_hm.put(c.getId(), c);        });    
        
        return clients_hm;
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
      newdata[0][3]=c.getPays();
      newdata[0][4]=c.getEtat();
      newdata[0][5]=c.getVille();
      newdata[0][6]=c.getRue();
      newdata[0][7]=c.getCode();
      newdata[0][8]=c.getTelephone();
      newdata[0][9]=c.getMail();
      System.out.println("Usage : prenom: 1 - nom: 2 -  ville: 5 - rue: 6 - code: 7 - tel: 8 - mail: 9 et -1 pour arrêter"); 
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
  
      c1 = new Client.ClientBuilder(newdata[0][0], newdata[0][3].substring(0,3).toUpperCase(),newdata[0][4].substring(0,3).toUpperCase() )
              .setPrenom(newdata[0][1])
              .setNom(newdata[0][2])
              .setVille(newdata[0][5])
              .setRue(newdata[0][6])
              .setCode(newdata[0][7])  
              .setTelephone(newdata[0][8])  
              .setMail(newdata[0][9])
              .build();
    
      emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
      em = emf.createEntityManager();
      em.getTransaction().begin();
      em.merge(c);
      em.getTransaction().commit();     
    }
    
    /**
     *
     * @param c
     */
    public  void removeClient (Client c) {
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.remove(c);
        em.getTransaction().begin();
        
    }
}