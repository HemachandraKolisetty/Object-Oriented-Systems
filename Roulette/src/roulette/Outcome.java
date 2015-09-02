/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roulette;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Outcome {
    public String name;
    public int odds;
    
    public Outcome(String name, int odds){
        this.name = name;
        this.odds = odds;
    }
    
    public int winAmount(int amount){
        return amount*odds;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode(){
        return (int)this.name.hashCode()*this.odds;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Outcome other = (Outcome) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.odds != other.odds) {
            return false;
        }
        return true;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        StringBuilder result;
        result = new StringBuilder();
        result.append(name).append(" (").append(odds).append(":1)");
        return result.toString();
    }
}
