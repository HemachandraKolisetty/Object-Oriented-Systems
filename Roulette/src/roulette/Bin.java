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
public class Bin {
    private Set<Outcome> outcomes;
    
    public Bin(){
        outcomes = new TreeSet<>();
    }
    
    public Bin(Outcome[] oarray){
        this();
        outcomes.addAll(Arrays.asList(oarray));
    }
}
