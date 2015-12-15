package test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReaderTest {
	
	public static void main(String[] args){

		File file = new File("clean");
        BufferedReader reader = null;
        try {
        	
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            
            String line = null;
            
            // 一次读入一行，直到读入null为文件结束
            while ((line = reader.readLine()) != null) {
            	
            		String[] tmps= line.split("\t");
            		String userId = tmps[2];
            		String device_id = tmps[3];
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
	