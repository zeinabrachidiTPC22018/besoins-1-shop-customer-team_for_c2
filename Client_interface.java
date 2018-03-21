
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeina
 */
public interface Client_interface {
    public void createClient();
    public Client findClient(String id);
    public void removeClient(String id);
    public void updateClient(String id);
    
    //public HashMap<String,Client> getAllClients();
}
