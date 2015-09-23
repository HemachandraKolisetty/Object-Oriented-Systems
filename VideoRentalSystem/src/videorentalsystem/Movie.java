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
public class Movie {
    public static int mcount=0;
    private int movie_id;
    private String title;
    private int rating;
    private int duration;
    private int producer_id;
    
    public Movie(String title, int rating, int duration, int pid){
        mcount++;
        this.title = title;
        this.rating = rating;
        this.duration = duration;
        this.producer_id = pid;
    }
    
    public int getMovieID(){
        return this.movie_id;
    }
    
    public String getMovieTitle(){
        return this.title;
    }
    
    public int getDuration(){
        return this.duration;
    }
    
    public int getRating(){
        return this.rating;
    }
    
    public int getProducerID(){
        return this.producer_id;
    }
}
