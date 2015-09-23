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
public class Costumer {
    public static int ccount=0;
    private int costumer_id;
    private String first_name;
    private String last_name;
    private String address;
    private String phone_no;
    private String dob;
    
    public Costumer(String fname, String lname, String addr, String pno, String dob){
        ccount++;
        this.first_name = fname;
        this.last_name = lname;
        this.address = addr;
        this.phone_no = pno;
        this.dob = dob;
    }
    
    public String getName(){
        return this.first_name+" "+this.last_name;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getPhoneno(){
        return this.phone_no;
    }
    
    public String getDOB(){
        return this.dob;
    }
}
