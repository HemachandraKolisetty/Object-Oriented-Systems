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
public class VideoData {
    String videoName;
    String rating;
    String duration;
    ArrayList<String> videos;
    
    private String parsetoString(String videoName, String rating, String duration){
        String out = videoName + ",,";
        out += (rating + ",,");
        out += (duration + ",,");
      //  System.out.print( out + "vsd");
        return out;
    }
    public void addVideo(String videoName, String rating, String duration){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("videoList.txt", true)))) {
            out.println(parsetoString(videoName, rating, duration));  
       //     System.out.print("ksadlvbw");
        }catch (IOException e) {
            e.printStackTrace();
            //exception handling left as an exercise for the reader
        }
     //   System.out.print("ksadlvbw");
    }  
    public ArrayList<String> videoNames(){
        BufferedReader br = null;
        ArrayList<String> list = new ArrayList<String>();
    try {
            String line;
            br = new BufferedReader(new FileReader("videoList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                list.add(x[0]);
            }
    } catch (IOException e) {
            e.printStackTrace();
        }       
        return list;       
    }    
    public void getVideo(String videoName){
        BufferedReader br = null;
        this.videoName = null;
        this.rating = null;
        this.duration = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("videoList.txt"));
            while ((line = br.readLine()) != null) {
                String[] x = line.split(",,");
                if(x[0].equals(videoName)){
                    this.videoName = videoName;
                    this.rating = x[1];
                    this.duration = x[2];
                }
            }
        } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public void editVideo(String oldvideoName, String newvideoName, String duration, String rating){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("videoList.txt");
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
                    if (tokens[0].equals(oldvideoName)) {  
                        System.out.print("here");
                        String newLine = parsetoString(newvideoName, rating, duration);
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
            FileWriter fstreamWrite = new FileWriter("videoList.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            out.close();
            //Close the input stream
           // in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    public void removeCost(String videoName){
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("videoList.txt");
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
                    if (!tokens[0].equals(videoName)) {  
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append("\n");
                    }
                }
            }
            // Now fileContent will have updated content , which you can override into file
            FileWriter fstreamWrite = new FileWriter("videoList.txt");
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
