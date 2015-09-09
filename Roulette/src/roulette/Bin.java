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
        //outcomes.addAll(Arrays.asList(oarray));
        for(Object obj:oarray){
            outcomes.add((Outcome) obj);
        }
    }
    
    public void add(Outcome outc){
        outcomes.add(outc);
    }
    public String toString(){
        StringBuilder result;
        result = new StringBuilder();
        result.append('[');
        Iterator itr = this.outcomes.iterator();
        while(itr.hasNext()){
            result.append((String)itr.next().toString()).append(',');
        }
        result.append(']');
        return result.toString();
    }
}
