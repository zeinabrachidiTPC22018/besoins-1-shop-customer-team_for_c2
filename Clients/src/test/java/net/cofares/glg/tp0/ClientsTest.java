/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.glg.tp0;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pascalfares
 */
public class ClientsTest {
    
    public ClientsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class Clients.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String id = "C2";
        Client expResult = null;
        Client result = Clients.find(id);
        assertEquals(expResult, result);
        Client c = new Client.ClientBuilder("C2")
                .nom("fares")
                .prenom("pascal")
                .rue("Zkak")
                .code("0324")
                .etat("Bey")
                .ville("Beyrouth")
                .pays("Liban")
                .telephone("01840161")
                .mail("pf@isae.edu.lb")
                .build();
        Clients.insert(c);
        
        Client result2 = Clients.find(id);
        assertEquals(c, result2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class Clients.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Client c = new Client.ClientBuilder("C1")
                .nom("fares")
                .prenom("pascal")
                .rue("Zkak")
                .code("0324")
                .etat("Bey")
                .ville("Beyrouth")
                .pays("Liban")
                .telephone("01840161")
                .mail("pf@isae.edu.lb")
                .build();
        Clients.insert(c);
        assertNotNull(Clients.find("C1"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Clients.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        String id = "C1";
        Clients.remove(id);
        assertNull(Clients.find("C1"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
