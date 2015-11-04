/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airtrafficcontrol;
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
 * @author user
 */
public class RunwayData {
    String runwayName;
    String length;
    String availability;   
    String lat;
    ArrayList<String> runways;
    
    private String parsetoString(String runwayName, String length, String availability, String lat){
        String out = runwayName + ",,";
        out += (length + ",,");
        out += (availability + ",,");
        out += (lat + ",,");
        return out;
    }
    public void addRunway(String runwayName, String length, String availability, String lat){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runwayList.txt", true)))) {
            out.println(parsetoString(runwayName, length, availability, lat));  
       //     System.out.print("ksadlvbw");
        }catch (IOException e) {
            e.printStackTrace();
            //exception handling left as an exercise for the reader
        }
     //   System.out.print("ksadlvbw");
    }  
    public ArrayList<String> runwayNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            br = new BufferedReader(new FileReader("runwayList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    public void getRunway(String runwayName){
        BufferedReader br = null;
        this.runwayName = null;
        this.length = null;
        this.availability = null;
        this.lat = null;
    	try {
            String line;
            br = new BufferedReader(new FileReader("runwayList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(runwayName)){
                    this.runwayName = runwayName;
                    this.length = x[1];
                    this.availability = x[2];
                    this.lat = x[3];
                }
            }
    	} catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void editRunway(String oldrunwayName, String newrunwayName, String length, String availability, String lat){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("runwayList.txt");
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
                    if (tokens[0].equals(oldrunwayName)) {  
                        //System.out.print("here");
                        String newLine = parsetoString(newrunwayName, length, availability, lat);
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
            FileWriter fstreamWrite = new FileWriter("runwayList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeRunway(String runwayName){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("runwayList.txt");
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
                    if (!tokens[0].equals(runwayName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("runwayList.txt");
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
