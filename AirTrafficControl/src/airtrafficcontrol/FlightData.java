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
 * @author abhinav
 */

public class FlightData{
    String flightName;
    String source;
    String dest;
    String timeOfDeparture;
    String timeDuration;
    String status;
    ArrayList<String> flights;
    
    private String parsetoString(String flightName, String source, String dest, String timeOfDeparture, String timeDuration, String status){
        String out = flightName + ",,";
        out += (source + ",,");
        out += (dest + ",,");
        out += (timeOfDeparture + ",,");
        out += (timeDuration + ",,");
        out += (status + ",,");
      //  System.out.print( out + "vsd");
        return out;
    }
    public void addFlight(String flightName, String source, String dest, String timeOfDeparture, String timeDuration, String status){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("flightList.txt", true)))) {
            out.println(parsetoString(flightName, source, dest, timeOfDeparture, timeDuration, status));  
       //     System.out.print("ksadlvbw");
        }catch (IOException e) {
            e.printStackTrace();
            //exception handling left as an exercise for the reader
        }
     //   System.out.print("ksadlvbw");
    }  
    public ArrayList<String> flightNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
	try {
            String line;
            br = new BufferedReader(new FileReader("flightList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
	} catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    public void getFlight(String flightName){
        BufferedReader br = null;
        this.flightName = null;
        this.source = null;
        this.dest = null;
        this.timeOfDeparture = null;
        this.timeDuration = null;
        this.status = null;
    	try {
            String line;
            br = new BufferedReader(new FileReader("flightList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(flightName)){
                    this.flightName = flightName;
                    this.source = x[1];
                    this.dest = x[2];
                    this.timeOfDeparture = x[3];
                    this.timeDuration = x[4];
                    this.status = x[5];
                }
            }
    	} catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void editFlight(String oldflightName, String newflightName, String source, String dest, String timeOfDeparture, String timeDuration, String status){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("flightList.txt");
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
                    if (tokens[0].equals(oldflightName)) {  
                        //System.out.print("here");
                        String newLine = parsetoString(newflightName, source, dest, timeOfDeparture, timeDuration, status);
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
            FileWriter fstreamWrite = new FileWriter("flightList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeFlight(String flightName){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("flightList.txt");
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
                    if (!tokens[0].equals(flightName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("flightList.txt");
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
