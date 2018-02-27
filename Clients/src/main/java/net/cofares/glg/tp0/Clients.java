/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.glg.tp0;

import java.util.HashMap;

/**
 *
 * @author pascalfares
 */
public class Clients {
    static HashMap<String,Client> clients;
    
    static  {
        clients = new HashMap<>();
    }
    
    public static Client find (String id) {
        return clients.get(id);
    }
    
    public static void insert(Client c){
        clients.put(c.getId(), c);
    }
    
    public static void update(Client c){
        //TODO
    }
    
    public static void remove (String id) {
        clients.remove(id);
    }
}
