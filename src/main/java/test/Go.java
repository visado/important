package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Go {

	public static void main(String[] args){

		/*
		File file = new File("a");
        BufferedReader reader = null;
        try {
        	
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            
            String line = null;
            
            // 一次读入一行，直到读入null为文件结束
            while ((line = reader.readLine()) != null) {
            	
            		String[] tmps= line.split("\t");
            		String campaign = tmps[0];       
            		String content =  tmps[1];  
            		int display = Integer.parseInt(tmps[2]);
            		int click = Integer.parseInt(tmps[3]);
            		float cost =  Float.parseFloat(tmps[4]);
            		float cpc = Float.parseFloat(tmps[5]);
            		
            		if(click == 0 && display >100){
            			System.out.println(line);
            		}
            		if(click > 0 && cpc >300){
            			//System.out.println(line);
            		}
            		
            }

            reader.close();
            
        } catch (IOException e) {
        	
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                	
                }
            }
        }
	}
	*/
		
		int a = 1;
		String b = ",a,b,,d";
		System.out.print(a+b);
		
		String[] tmps = b.split(",");
		for(String each : tmps)
			System.out.println(each);
		
		System.out.println(b.substring(0,b.length()-1));
	}

}
