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
public class Producer {
    public static int pcount=0;
    private int company_id;
    private String company_name;
    private String country;
    
    public Producer(String cname, String country){
        pcount++;
        this.company_id = pcount;
        this.company_name = cname;
        this.country = country;
    }
    
    public int getCompanyID(){
        return this.company_id;
    }
    
    public String getCompanyName(){
        return this.company_name;
    }
    
    public String getCountry(){
        return this.country;
    }
}
