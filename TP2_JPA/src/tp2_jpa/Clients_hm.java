
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
import java.util.Collections;
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
        String id;
        Scanner kb = new Scanner(System.in);       
        System.out.println("saisir un client");
        System.out.println("Usage : prénom - nom - pays - etat - ville -  rue - code - tel  - mail");
        System.out.println("Exemple : Bob - Ducnam - Liban - baabda - haret hreik - eddeh - +0961  - 03240246 - Bob.Ducnam@isae.edu.lb"); 
               
        String s;
        s = kb.nextLine();
        String[] ss = s.split(" - ");
        String[] ssn = new String[9];
        
        System.arraycopy( ss, 0, ssn, 0, ss.length );
        if (ss.length < ssn.length)
           for (int i=ss.length; i<ssn.length;i++)
               ssn[i]="";
        for (String ssn1 : ssn) {
            System.out.print(ssn1 + "  ");
        }

       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
       em = emf.createEntityManager();
       em.getTransaction().begin();
        
        long nbc;
        nbc = ((Number)em.createNamedQuery("Client.findAllCount").getSingleResult()).intValue();
        if (nbc == 0)
            id = ss[2].substring(0,3).toUpperCase() +  ss[3].substring(0,3).toUpperCase() + "1";
        else {
            List<String> list_id;
            list_id = em.createNamedQuery("Client.extractId").getResultList();
            System.out.println( list_id );
           
            long max_id;
            max_id = Long.parseLong(Collections.max(list_id));
            id = ss[2].substring(0,3).toUpperCase() +  ss[3].substring(0,3).toUpperCase() + Long.toString(max_id + 1);
        }
            
        c = new Client.ClientBuilder(id, ss[2], ss[3])
                .setPrenom(ssn[0])
                .setNom(ssn[1])
                .setVille(ssn[4])
                .setRue(ssn[5])
                .setCode(ssn[6])
                .setTelephone(ssn[7])
                .setMail(ssn[8])
                .build();
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
        
        System.out.println("Id\t" + "prénom\t" + "nom\t" + "pays\t" + "etat\t" + "ville\t" + "rue\t" +   "code\t" + "tel\t" +  "mail\t");
        for (Client  c : list) {
             System.out.println( c.getId() + "\t" + c.getPrenom() + "\t" + c.getNom() + "\t" +  c.getPays() + "\t" +  c.getEtat() + "\t"  + c.getVille()  + "\t" + c.getRue() + "\t" + c.getCode() + "\t" + c.getTelephone() + "\t" + c.getMail());
        }
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
    }    
    
    public  Client findClient (String _id) {
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        list = em.createNamedQuery("Client.findById", Client.class).setParameter("_id", _id).getResultList(); 
        for (Client  c : list) {
            
            if (!list.isEmpty() ){
                return c;  
            }
        }
        return null;
    }
    
     /**
     *
     * @param _prenom
     * @return
     */
    public  List<Client> findClients (String _prenom) {
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByPrenom", Client.class).setParameter("_prenom", _prenom).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }  
    
    public  List<Client> findClientsNom (String _nom) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByNom", Client.class).setParameter("_nom", _nom).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }  
    
    public  List<Client> findClientsPays (String _pays) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByPays", Client.class).setParameter("_pays", _pays).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }  
    
    public  List<Client> findClientsEtat (String _etat) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByEtat", Client.class).setParameter("_etat", _etat).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }  
    
    public  List<Client> findClientsVille (String _ville) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByVille", Client.class).setParameter("_ville", _ville).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }  
    
    public  List<Client> findClientsRue (String _rue) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByRue", Client.class).setParameter("_rue", _rue).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }  
    
    public  List<Client> findClientsCode (String _code) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByCode", Client.class).setParameter("_code", _code).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }  
    
    public  List<Client> findClientsTelephone (String _telephone) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByTelephone", Client.class).setParameter("_telephone", _telephone).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }  
    
    public  List<Client> findClientsMail (String _mail) {
       emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        list = em.createNamedQuery("Client.findByMail", Client.class).setParameter("_mail", _mail).getResultList();
        if (!list.isEmpty() ){
           return list;
        }   
        return null;
    }     
    
    public void displayClient(Client c){
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        System.out.println(c.getId() + "\t" + c.getPrenom() + "\t" + c.getNom() + "\t" + c.getTelephone() + "\t" + c.getRue()+ "\t" + c.getVille()  + "\t" + c.getEtat()  + "\t" + c.getCode()  + "\t" + c.getPays() + "\t"  + c.getMail());
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
    }     
    
     public void displayClientsList(List<Client> result){
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        for (Client  c : result) {
             System.out.println( c.getId() + "\t" + c.getPrenom() + "\t" + c.getNom() + "\t" +  c.getPays() + "\t" +  c.getEtat() + "\t"  + c.getVille()  + "\t" + c.getRue() + "\t" + c.getCode() + "\t" + c.getTelephone() + "\t" + c.getMail());
        }
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
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
      
      while (true) {
          System.out.println("Usage : prenom: 1 - nom: 2 -  ville: 5 - rue: 6 - code: 7 - tel: 8 - mail: 9 et -1 pour arrêter"); 
          System.out.println("saisir le numéro de la colonne à modifier:");  
        n = kb.nextInt();
        if (n==-1)
            break;
        if (n==3 || n==4)
            System.out.println("tu ne peux pas modifier le pays et l;etat");
        else {
           System.out.println("saisir la nouvelle donnée:");
           kb.nextLine();
           data = kb.nextLine();
           newdata[0][n]= data;
        }
      }
  
      c1 = new Client.ClientBuilder(newdata[0][0], newdata[0][3],newdata[0][4] )
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
      em.merge(c1);
      em.getTransaction().commit();     
    }
    
    /**
     *
     * @param c
     */
    public  void removeClient (Client c) {
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        int deleteCount= em.createNamedQuery("Client.deleteById", Client.class).setParameter("_id", c.getId()).executeUpdate();
        //em.remove(c);
        em.getTransaction().commit();    
        
    }
}