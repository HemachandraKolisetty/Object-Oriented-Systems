/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorentalsystem;

/**
 *
 * @author user
 */
public class Rental {
    private int movie_id;
    private int costumer_id;
    private String date_rented;
    private String due_date;
    
    public Rental(int mid, int cid, String dr, String dd){
        this.movie_id = mid;
        this.costumer_id = cid;
        this.date_rented = dr;
        this.due_date = dd;
    }
    
    public int getMovieID(){
        return this.movie_id;
    }
    
    public int getCostumerID(){
        return this.costumer_id;
    }
    
    public String getDateRented(){
        return this.date_rented;
    }
    
    public String getDueDate(){
        return this.due_date;
    }
}
