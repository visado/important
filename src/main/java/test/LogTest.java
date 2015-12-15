package test;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;


public class LogTest {

	
	public static void main(String[] args) {
		
		File file = new File("data");
        BufferedReader reader = null;
        try {
        	
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
            HashMap<String,Integer> minSet= new HashMap<String,Integer>();
            HashMap<String,Integer> maxSet= new HashMap<String,Integer>();
            HashMap<String,Integer> sumSet= new HashMap<String,Integer>();
            HashMap<String,Integer> count= new HashMap<String,Integer>();
            
            String line = null;
            boolean data = false;
            
            while ((line = reader.readLine()) != null) {

            	if(!data){
            		data = true;
            		continue;
            	}
            	
        		String[] tmps= line.split(" ");
        		String url = tmps[0];
        		int cost = Integer.parseInt(tmps[1]);
        		
        		if(sumSet.get(url)!=null){
        			sumSet.put(url,sumSet.get(url)+cost);
        		}
        		else{
        			sumSet.put(url,cost);
        		}
        		
        		if(minSet.get(url)!=null){
        			if(cost < minSet.get(url))
        				minSet.put(url, cost);
        		}
        		else{
        			minSet.put(url,cost);
        		}
        		
        		if(maxSet.get(url)!=null){
        			if(cost > maxSet.get(url))
        			maxSet.put(url, cost);
        		}
        		else{
        			maxSet.put(url,cost);
        		}
        		
        		if(count.get(url)!=null){
        			
        			count.put(url, count.get(url)+1);
        		}
        		else{
        			count.put(url,1);
        		}
            }
            
            Set<String> keys = sumSet.keySet();
            for(String each:keys){
            	System.out.println(each+ "\t"+minSet.get(each)+"\t"+maxSet.get(each)+"\t"+ (sumSet.get(each)/count.get(each)) +"\t"+count.get(each));
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
}