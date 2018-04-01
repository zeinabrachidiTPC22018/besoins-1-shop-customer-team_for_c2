/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeina
 */
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Clients_hm {
    
    Client c;
    Gson gson = new Gson();
    String json, clientfilename;
    
    public void createClient(){
        BufferedWriter bwc, bwn;
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
        json = gson.toJson(c);
        
        clientfilename = "Client" + "_" + ss[0] + ".json";
        try {
          bwc = new  BufferedWriter ( new FileWriter(clientfilename));
          bwc.write(json);
          bwn = new  BufferedWriter ( new FileWriter("filenames", true));
          bwn.write(clientfilename);
          bwn.newLine();
          bwc.flush();
          bwn.flush();
          bwc.close();
          bwn.close();
        }
        catch(IOException e) {
        }
    }
    
    public  Client findClient (String id) throws FileNotFoundException, IOException {
        String line;
        BufferedReader brc = null,  brn;
        brn = new BufferedReader(new FileReader("filenames"));
        while ((clientfilename = brn.readLine()) != null) {
            brc = new BufferedReader(new FileReader(clientfilename));
            c = gson.fromJson(brc, Client.class);
            System.out.println("client in find" + c);
            if (c.getId().equals(id)) {
                brn.close();
                brc.close();
                return c; 
            }      
        }
         brn.close();
         brc.close();
        return (null);
    }    
    
    public  HashMap <String,Client> findClients (String prenom) throws FileNotFoundException, IOException {
        HashMap <String,Client> result ;
        result = new HashMap <>();
        String line;
        boolean trouve = false;
        BufferedReader brc = null, brn;
        brn = new BufferedReader(new FileReader("filenames"));
        while ((clientfilename = brn.readLine()) != null) {
            brc = new BufferedReader(new FileReader(clientfilename));
            c = gson.fromJson(brc, Client.class);
            if (c.getPrenom().equals(prenom)) {
                result.put(c.getId(), c); 
                trouve=true;
            }       
        } 
        if (!trouve) 
            result = null;
        brc.close();
        brn.close();
        return result;
    }  
    
    public  HashMap <String,Client> findClientsNom (String nom) throws FileNotFoundException, IOException {
       HashMap <String,Client> result;
       result = new HashMap <>();
        boolean trouve = false;
        String line;
        BufferedReader brc = null, brn;
        brn = new BufferedReader(new FileReader("filenames"));
        while ((clientfilename = brn.readLine()) != null) {
            brc = new BufferedReader(new FileReader(clientfilename));
            c = gson.fromJson(brc, Client.class);
            if (c.getNom().equals(nom)) {
                result.put(c.getId(), c);
                trouve=true;
            }   
        }    
        if (!trouve) 
            result = null;
        brc.close();
        brn.close();
        return result;
    }  
    
    public void displayClient(Client c){
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        System.out.println(c.getId() + "\t" + c.getPrenom() + "\t" + c.getNom() + "\t" + c.getTelephone() + "\t" + c.getRue()+ "\t" + c.getVille()  + "\t" + c.getEtat()  + "\t" + c.getCode()  + "\t" + c.getPays() + "\t"  + c.getMail());
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
    } 
     
    public void displayClients() throws FileNotFoundException, IOException{
        System.out.println("Id\t" + "prénom\t" + "nom\t" +  "tel\t" + "rue\t" + "ville\t" + "etat\t" + "code\t" + "pays\t" + "mail\t");
        HashMap <String,Client> result=null;
        String line;
        BufferedReader brc = null, brn;
        brn = new BufferedReader(new FileReader("filenames"));
        while ((clientfilename = brn.readLine()) != null) {
            brc = new BufferedReader(new FileReader(clientfilename));
            c = gson.fromJson(brc, Client.class); 
            System.out.println(c.getId() + "\t" + c.getPrenom() + "\t" + c.getNom() + "\t" + c.getTelephone() + "\t" + c.getRue()+ "\t" + c.getVille()  + "\t" + c.getEtat()  + "\t" + c.getCode()  + "\t" + c.getPays() + "\t"  + c.getMail());
        }
        brc.close();
        brn.close();
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
    
    public  void updateClient(Client c){  
      BufferedWriter bwc;
      File f;
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
    json = gson.toJson(c1);
        
    clientfilename = "Client" + "_" + c.getId() + ".json";
    f = new File(clientfilename);
    f.delete();
    try {
        bwc = new  BufferedWriter ( new FileWriter(clientfilename));
        bwc.write(json);
        bwc.flush();
        bwc.close();
        }
        catch(IOException e) {
        }
        System.out.println(json);   
    }
    
    /**
     *
     * @param id
     * @throws java.io.FileNotFoundException
     */
    public  void removeClient (String id) throws FileNotFoundException, IOException {
        String line;
        clientfilename = "Client" + "_" + id + ".json";
        File f = new File(clientfilename);
        String path = f.getAbsolutePath();
        boolean delete = f.delete();
        if (delete)
            System.out.println("client suprimé");
        else
           System.out.println("client non suprimé");
        File oldf = new File("filenames");
        File newf = new File("filenames");
        File temp = new File("tempfilenames");
        try (BufferedReader brn = new  BufferedReader ( new FileReader("filenames")); BufferedWriter bwn = new  BufferedWriter ( new FileWriter("tempfilenames"))) {
            while((line = brn.readLine()) != null) {
                if (line.equals(clientfilename)) {
                    continue;
                }
                bwn.write(line);
                bwn.newLine();
                bwn.flush();
            }
            bwn.close();
            brn.close();
            oldf.delete();
            temp.renameTo(newf);
        }
    }
}