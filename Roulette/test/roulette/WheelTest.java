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
import java.util.Random;
/**
 *
 * @author user
 */
class NonRandom extends Random{
    int value;
    
    public NonRandom(){
        this.value = 0;
    }
    
    public void setSeed(int value){
        this.value = value;
    }
    
    @Override
    public int nextInt(int x){
        return value;
    }
}

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
        Outcome[] outc2 = new Outcome[2];
        outc2[0] = new Outcome("1",35);
        outc2[1] = new Outcome("00",37);
        Random rng = new Random();
        Wheel instance = new Wheel(rng);
        instance.addOutcome(binno, outc2[1]);
        Bin b = instance.get(0);
        //System.out.println(b.toString());
        String expresult = "[00 (37:1),]";
        assertEquals(expresult, b.toString());
    }

    /**
     * Test of next method, of class Wheel.
     */
    @Test
    public void testNext() {
        int binno=0;
        System.out.println("nextCheck");
        NonRandom nrng = new NonRandom();
        Wheel instance = new Wheel(nrng);
        Outcome[] outc = new Outcome[2];
        outc[0] = new Outcome("red",2);
        outc[1] = new Outcome("black",1);
        instance.addOutcome(binno, outc[1]);
        instance.addOutcome(binno+1, outc[0]);
        Bin expResult = instance.get(0);
        Bin result = instance.next();
        
        System.out.println(result.toString());
        System.out.println(expResult.toString());
        
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class Wheel.
     */
    @Test
    public void testGet() {
        System.out.println("getCheck");
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
        assertEquals("[00 (37:1),]", result.toString());
    }
    
}
