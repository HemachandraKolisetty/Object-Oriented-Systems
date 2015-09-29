/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorentalsystem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author abhinav
 */
public class CostData {
    String costName;
    String address;
    String phoneNo;
    String DOB;
    ArrayList<String> costs;
    
    private String parsetoString(String costName, String address, String phoneNo, String DOB){
        String out = costName + ",,";
        out += (address + ",,");
        out += (phoneNo + ",,");
        out += (DOB);
      //  System.out.print( out + "vsd");
        return out;
    }
    public void addCost(String costName, String address, String phoneNo, String DOB){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("costList.txt", true)))) {
            out.println(parsetoString(costName, address, phoneNo, DOB));  
       //     System.out.print("ksadlvbw");
        }catch (IOException e) {
            e.printStackTrace();
            //exception handling left as an exercise for the reader
        }
     //   System.out.print("ksadlvbw");
    }  
    public ArrayList<String> costNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            br = new BufferedReader(new FileReader("costList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    public void getCost(String costName){
        BufferedReader br = null;
        this.costName = null;
        this.address = null;
        this.phoneNo = null;
        this.DOB = null;
    	try {
            String line;
            br = new BufferedReader(new FileReader("costList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(costName)){
                    this.costName = costName;
                    this.address = x[1];
                    this.phoneNo = x[2];
                    this.DOB = x[3];
                }
            }
    	} catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void editCost(String oldcostName, String newcostName, String phoneNo, String address, String DOB){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("costList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
              //  System.out.println(strLine);
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                    if (tokens[0].equals(oldcostName)) {  
                        System.out.print("here");
                        String newLine = parsetoString(newcostName, address, phoneNo, DOB);
                        fileContent.append(newLine);
                        fileContent.append("\n");
                    } else {
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("costList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeCost(String costName){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("costList.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
              //  System.out.println(strLine);
                String tokens[] = strLine.split(",,");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                    if (!tokens[0].equals(costName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("costList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
