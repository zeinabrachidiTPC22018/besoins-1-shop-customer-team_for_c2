/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zeina
 */
import java.io.IOException;
public class Source_impl<D> {
    public static void main(String[] args) throws IOException, InterruptedException {
        Source source = new Source<>();
        source.addGEventListener((GEvent ev) -> System.out.println(ev.getData()));
       
        Thread t = new Thread(new MenuPrincipal(source));
        t.start();
        t.join();
    }
    
}
