/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roulette;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class BinTest {
    
    public BinTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add method, of class Bin.
     */
    @Test
    public void testAdd() {
        System.out.println("addCheck");
        Outcome[] outc = new Outcome[2];
        outc[0] = new Outcome("red",2);
        outc[1] = new Outcome("black",1);
        Outcome outc2 = new Outcome("1",35);
        Bin instance = new Bin(outc);
        instance.add(outc2);
        System.out.println(instance.toString());
    }

    /**
     * Test of toString method, of class Bin.
     */
    @Test
    public void testToString() {
        System.out.println("toStringCheck");
        Outcome outc[] = new Outcome[2];
        outc[0] = new Outcome("red",2);
        outc[1] = new Outcome("black",1);
        String expResult = "[black (1:1),red (2:1),]";
        Bin instance = new Bin(outc);
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
