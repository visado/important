package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String[] fileName = {
				
				"DailyReportForSEM_baidu-无线bcxindai-8151191_2015-11-02","DailyReportForSEM_baidu-无线bcxindai01-8151191_2015-11-02","DailyReportForSEM_baidu-无线bcxindai02-8151191_2015-11-02","DailyReportForSEM_baidu-无线bcxindai03-8151191_2015-11-02","DailyReportForSEM_baidu-无线bcxindai04-8151191_2015-11-02",
				"DailyReportForSEM_baidu-xindaipc-8150777_2015-11-02","DailyReportForSEM_baidu-xindaipc-8150777-01_2015-11-02","DailyReportForSEM_baidu-xindaipc-8150777-02_2015-11-02","DailyReportForSEM_baidu-xindaipc-8150777-03_2015-11-02","DailyReportForSEM_baidu-xindaipc04-8151191_2015-11-02",
				
		};
		
		FileWriter outputFile = new FileWriter("/Users/yixin/Documents/workspace/sem/sum");
		
		//“DailyReportForSEM_baidu-无线bcxindai04-8151191_2015-11-02",
		//"DailyReportForSEM_baidu-无线bcxindai01-8151191_2015-11-02"
		
		int lineNo =1;
		
		for(String each:fileName){
			File file = new File("/Users/yixin/Documents/workspace/sem/"+each);
			BufferedReader reader = null;
			String line = "";
			
			try{
				
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
				
				 while ((line = reader.readLine()) != null) {
					 
					 //System.out.println(lineNo +" "+line);
					 outputFile.write(each+"\t"+line+"\r\n");
					 lineNo++;
				 }
			}
			catch(IOException e)
			{
				e.printStackTrace();
			} finally
		
			{
				if (reader != null) {
					try {
						outputFile.flush();
						reader.close();
					} catch (IOException e1) {
		
					}
				}
			}
		}
		
		try{
			outputFile.close();
		}
		catch(IOException e){
			
		}
		
	}
}
