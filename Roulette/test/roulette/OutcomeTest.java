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
public class OutcomeTest {
    
    public OutcomeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of winAmount method, of class Outcome.
     */
    @Test
    public void testWinAmount() {
        System.out.println("winAmountCheck");
        int amount = 40;
        Outcome instance = new Outcome("Red",2);
        assertEquals(amount*2, instance.winAmount(amount));
    }

    /**
     * Test of equals method, of class Outcome.
     */
    @Test
    public void testEquals() {
        System.out.println("equalsCheck");
        Outcome instance = new Outcome("red",2);
        Outcome instance2 = new Outcome("red",2);
        Outcome instance3 = new Outcome("1",10);
        assertEquals(true, instance.equals(instance2));
        assertEquals(false, instance.equals(instance3));
    }

    /**
     * Test of toString method, of class Outcome.
     */
    @Test
    public void testToString() {
        System.out.println("toStringCheck");
        Outcome instance = new Outcome("red",2);
        assertEquals("red (2:1)", instance.toString());
    }

    /**
     * Test of hashCode method, of class Outcome.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCodeCheck");
        Outcome instance = new Outcome("red",2);
        assertEquals((int)"red".hashCode()*2, instance.hashCode());
    }
    
}
