/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roulette;
import java.util.*;
/**
 *
 * @author user
 */
public class Wheel {
    public ArrayList<Bin> bins;
    public Random rng;
    
    /**
     *
     * @param rng
     */
    public Wheel(Random rng){
        bins = new ArrayList<>();
        for(int i=0;i<38;i++){
            bins.add(new Bin());
        }
        this.rng = rng;
    }
    
    public void addOutcome(int binno, Outcome outc){
        Bin a = bins.get(binno);
        a.add(outc);
        bins.set(binno, a);
    }
    
    public Bin next(){
        int a = rng.nextInt(bins.size());
        return bins.get(a);
    }
    
    public Bin get(int binno){
        return bins.get(binno);
    }
}
