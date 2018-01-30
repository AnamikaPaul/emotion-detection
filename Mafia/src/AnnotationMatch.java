import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AnnotationMatch {

	
	public static void main(String args[]) throws Exception
	{
		FileWriter writer = new FileWriter("resource/game55.txt");
		String RR,MG, WG,text;
		String annotation_list[];
		String line;
		 try {
		 BufferedReader br = new BufferedReader(new FileReader("resource/game5.csv"));
			    while ((line = br.readLine()) != null) {
			    	   System.out.println("line: "+ line);
			    	  annotation_list= line.split(",");
			    	  
			    	   for(String annote : annotation_list){
			    		   System.out.println(annote);
			    		   }
			    	   System.out.println(annotation_list[1].equalsIgnoreCase(annotation_list[2]));
			    	   writer.append(annotation_list[0]+","+annotation_list[1]+","+annotation_list[2]+","+annotation_list[1].equalsIgnoreCase(annotation_list[2])+" "+'\n');
			     	  
			    	}
		
			     
		  }	
		 catch(Exception e){}
		 
		 
		 writer.flush();
		    writer.close();  
		
	}}
