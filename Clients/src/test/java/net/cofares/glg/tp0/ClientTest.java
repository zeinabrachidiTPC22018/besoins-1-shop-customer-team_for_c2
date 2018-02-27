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
public class ClientTest {
    public static Client aClient;
    
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        aClient = new Client.ClientBuilder("C1")
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
     * Test of getId method, of class Client.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Client instance = aClient;
        String expResult = "C1";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrenom method, of class Client.
     */
    @Test
    public void testGetPrenom() {
        System.out.println("getPrenom");
        Client instance = aClient;
        String expResult = "pascal";
        String result = instance.getPrenom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Client.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Client instance = aClient;
        String expResult = "fares";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTelephone method, of class Client.
     */
    @Test
    public void testGetTelephone() {
        System.out.println("getTelephone");
        Client instance = aClient;
        String expResult = "01840161";
        String result = instance.getTelephone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRue method, of class Client.
     */
    @Test
    public void testGetRue() {
        System.out.println("getRue");
        Client instance = aClient;
        String expResult = "Zkak";
        String result = instance.getRue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getVille method, of class Client.
     */
    @Test
    public void testGetVille() {
        System.out.println("getVille");
        Client instance = aClient;
        String expResult = "Beyrouth";
        String result = instance.getVille();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEtat method, of class Client.
     */
    @Test
    public void testGetEtat() {
        System.out.println("getEtat");
        Client instance = aClient;
        String expResult = "Bey";
        String result = instance.getEtat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCode method, of class Client.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        Client instance = aClient;
        String expResult = "0324";
        String result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPays method, of class Client.
     */
    @Test
    public void testGetPays() {
        System.out.println("getPays");
        Client instance = aClient;
        String expResult = "Liban";
        String result = instance.getPays();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMail method, of class Client.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        Client instance = aClient;
        String expResult = "pf@isae.edu.lb";
        String result = instance.getMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
