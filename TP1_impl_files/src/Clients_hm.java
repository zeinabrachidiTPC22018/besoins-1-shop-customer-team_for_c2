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
    String json, clientfilename, Line, identifier, directory, path_clientfilename, path_filenames;
    
    public void createClient() throws IOException{
        BufferedWriter bwc, bwn;
        BufferedReader brid;
        BufferedWriter bwid;
        
        
        Scanner kb = new Scanner(System.in);       
        System.out.println("saisir un client");
        System.out.println("Usage : prénom - nom - pays - etat - ville - rue - code - tel - mail");
        System.out.println("Exemple :  Bob - Ducnam - Liban - baabda - haret hreik - eddeh - +0961 - 03240246 - Bob.Ducnam@isae.edu.lb"); 
        String s = kb.nextLine();
        String[] ss = s.split(" - ");
        String[] ssn = new String[9];
        System.arraycopy( ss, 0, ssn, 0, ss.length );
        if (ss.length < ssn.length)
           for (int i=ss.length; i<ssn.length;i++)
               ssn[i]="";
        
        File sequence = new File("idFile");
        Line=null;
        if (!sequence.exists())
             identifier = ss[2].substring(0, 3) + ss[3].substring(0, 3) + ss[4].substring(0, 3) + ss[5].substring(0, 3) + "1" ;
        else {
            Line = String.valueOf(Integer.parseInt(Line) + 1);
            bwid = new BufferedWriter(new FileWriter("idFile"));
            bwid.write(Line);
            bwid.flush(); 
            bwid.close();
            identifier = ss[2].substring(0, 3) + ss[3].substring(0, 3) + ss[4].substring(0, 3) + ss[5].substring(0, 3) + Line;
        }    
                   
        c = new Client.ClientBuilder(identifier, ss[0], ss[1], ss[2], ss[3], ss[4], ss[5])
                .setCode(ssn[6])
                .setTelephone(ssn[7])
                .setMail(ssn[8])
                .build();
        json = gson.toJson(c);
        
        clientfilename = identifier + ".json";
        path_clientfilename = "C:\\" + identifier.substring(0,3) + "\\" + identifier.substring(4, 7) + "\\" + identifier.substring(8,11) + "\\" + identifier.substring(12,15) + "\\" + clientfilename;
        path_filenames = "C:\\" + identifier.substring(0,3) + "\\" + identifier.substring(4, 7) + "\\" + identifier.substring(8,11) + "\\" + identifier.substring(12,15) + "\\" + "filenames";
        int from=0, to=3;
        try {
             for ( int i=0; i<4; i++) {
                directory = identifier.substring(from, to);
                createDirectory(directory);
                from = to + 1;
                to = from + 3;
            }
          
          bwc = new  BufferedWriter ( new FileWriter(path_clientfilename));
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
    
    public void createDirectory(String directory) {
       File dir = new File(directory);
       if (!dir.exists()) {
           dir.mkdir();
       }
       
    }
    
    public  Client findClient (String identifier) throws FileNotFoundException, IOException {
        String line;
        BufferedReader brc;
        clientfilename = identifier + ".json";
        path_clientfilename = "C:\\" + identifier.substring(0,3) + "\\" + identifier.substring(4, 7) + "\\" + identifier.substring(8,11) + "\\" + identifier.substring(12,15) + "\\" + clientfilename;
        brc = new BufferedReader(new FileReader(path_clientfilename));
        File f = new File(path_clientfilename);
        if (f.exists()) {
           c = gson.fromJson(brc, Client.class);
           System.out.println("client in find" + c);
           return c; 
        }
        else 
            c = null;
        brc.close();
        return c;
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
      newdata[0][3]=c.getPays();
      newdata[0][4]=c.getEtat();
      newdata[0][5]=c.getVille();
      newdata[0][6]=c.getRue();
      newdata[0][7]=c.getCode();
      newdata[0][8]=c.getTelephone();
      newdata[0][9]=c.getMail();
      System.out.println("Usage :  code: 6 - tel: 7 - mail: 9 et -1 pour arrêter"); 
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
  
    c1 = new Client.ClientBuilder(newdata[0][0], newdata[0][1],newdata[0][2] , newdata[0][3], newdata[0][4], newdata[0][5], newdata[0][6])
             .setCode(newdata[0][7])    
            .setTelephone(newdata[0][8])  
            .setMail(newdata[0][0])
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