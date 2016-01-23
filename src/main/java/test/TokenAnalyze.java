package test;

/*
 * 
 * data format like this 
+---------------------------------+-----------------------------------------------------+------------+----------+------+---------+
 campaign content displayNum clickNum form cost 
+---------------------------------+-----------------------------------------------------+------------+----------+------+---------+
|南京-通用词新|个人信用记录网上查询|72|8|1|17.79|
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TokenAnalyze {
	
	static int size = 19961;
	static float[] clickRatio = new float[size],convertRadio = new float[size],cost = new float[size];
    static int[] displayNum = new int[size];
    static String[] record = new String[size];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		File file = new File("b");
        BufferedReader reader = null;
        
        
        try {
        	
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String line = null;
            
            int index = 0;
            // 一次读入一行，直到读入null为文件结束
            while ((line = reader.readLine()) != null) {
            	
            		//line = line.replaceAll("( )+", " ");
            		line = line.trim();
            		String[] tmps= line.split(" ");
            		
            		
            		displayNum[index] = Integer.parseInt(tmps[2]);
            		clickRatio[index] = Float.parseFloat(tmps[3])/Float.parseFloat(tmps[2]);
            		convertRadio[index] = Float.parseFloat(tmps[4]);
            		cost[index] = Float.parseFloat(tmps[5]);
            		record[index] = line;

            		index++;
            	
            }

            reader.close();
            
            int[] tmp1 = displayNum.clone();
            float[] tmp2 = clickRatio.clone();
            
            Arrays.sort(tmp1);
            Arrays.sort(tmp2);
            
            System.out.println("displayNum middle number is :"+tmp1[displayNum.length/2]);
            System.out.println("clickRadio middle number is :"+tmp2[clickRatio.length/2]);
            aggregate(tmp1[displayNum.length/2],tmp2[clickRatio.length/2]);
            
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
	
	private static void aggregate(float displayMidNum,float clickRadioMidNum){
		
		String groupA = "";
		String groupB = "";
		String groupC = "";
		String groupD = "";
		float sumMoneyA = 0;
		int sumCPCA = 0;
		float sumMoneyB = 0;
		int sumCPCB = 0;
		float sumMoneyC = 0;
		int sumCPCC = 0;
		float sumMoneyD = 0;
		int sumCPCD = 0;
		
		for(int i =0;i<size;i++){
			
			if(displayNum[i] > displayMidNum && clickRatio[i] > clickRadioMidNum){
				groupA += record[i]+"\r\n";
				sumMoneyA += cost[i];
				sumCPCA += convertRadio[i];
			}
			else if(displayNum[i] > displayMidNum && clickRatio[i] < clickRadioMidNum){
				groupB += record[i]+"\r\n";
				sumMoneyB += cost[i];
				sumCPCB += convertRadio[i];
				
			}
			else if(displayNum[i] < displayMidNum && clickRatio[i] > clickRadioMidNum){
				groupC += record[i]+"\r\n";
				sumMoneyC += cost[i];
				sumCPCC += convertRadio[i];
			}
			else{
				groupD += record[i]+"\r\n";
				sumMoneyD += cost[i];
				sumCPCD += convertRadio[i];
			}
		}
		
		FileOutputStream output = null;
		try {
			output = new FileOutputStream("output");
			OutputStreamWriter fw = new OutputStreamWriter(output,"UTF-8");
			fw.write("Group A:"+ sumMoneyA+" "+(sumMoneyA/sumCPCA) +" "+sumCPCA +"\r\n" +groupA);
			fw.write("Group B:"+ sumMoneyB+" "+(sumMoneyB/sumCPCB) +" "+sumCPCB +"\r\n" +groupB);
			fw.write("Group C:"+ sumMoneyC+" "+(sumMoneyC/sumCPCC) +" "+sumCPCC +"\r\n" +groupC);
			fw.write("Group D:"+ sumMoneyD+" "+(sumMoneyD/sumCPCD) +" "+sumCPCD +"\r\n" +groupD);
			fw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
	}
	
	

}