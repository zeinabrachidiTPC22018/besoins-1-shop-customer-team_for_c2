/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_jpa;

/**
 *
 * @author zeina
 * @param <D>
 */
public class TP2_JPA<D> {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Source source = new Source<>();
        source.addGEventListener((GEvent ev) -> ev.getData());
        Thread t = new Thread(new MenuPrincipal(source));
        t.start();
        t.join();
        
    }
    
}
