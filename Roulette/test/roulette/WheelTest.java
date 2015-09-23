/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roulette;

import java.util.Random;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class WheelTest {
    
    public WheelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addOutcome method, of class Wheel.
     */
    @Test
    public void testAddOutcome() {
        System.out.println("addOutcomeCheck");
        int binno = 0;
        Outcome[] outc = new Outcome[2];
        outc[0] = new Outcome("red",2);
        outc[1] = new Outcome("black",1);
        Bin uno = new Bin(outc);
        Outcome[] outc2 = new Outcome[2];
        outc2[0] = new Outcome("1",35);
        outc2[1] = new Outcome("00",37);
        Bin dos = new Bin(outc2);
        Random rng = new Random();
        Wheel instance = new Wheel(rng);
        instance.addOutcome(binno, outc2[1]);
        Bin b = instance.get(0);
        System.out.println(b.toString());
    }

    /**
     * Test of next method, of class Wheel.
     */
    @Test
    public void testNext() {
        System.out.println("nextCheck");
        Wheel instance = null;
        Bin expResult = null;
        Bin result = instance.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class Wheel.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int binno = 0;
        Outcome[] outc = new Outcome[2];
        outc[0] = new Outcome("red",2);
        outc[1] = new Outcome("black",1);
        Bin uno = new Bin(outc);
        Outcome[] outc2 = new Outcome[2];
        outc2[0] = new Outcome("1",35);
        outc2[1] = new Outcome("00",37);
        Bin dos = new Bin(outc2);
        Random rng = new Random();
        Wheel instance = new Wheel(rng);
        instance.addOutcome(binno, outc2[1]);
        Bin result = instance.get(binno);
        
        Outcome[] c = new Outcome[1];
        c[0] = new Outcome("00",37);
        Bin expResult = new Bin(c);
        assertEquals(expResult, result);
    }
    
}
