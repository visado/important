package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceTest {
	
	public static void main(String args[]){
		
		InputStream is = ResourceTest.class.getClassLoader().getResourceAsStream("apns.properties");
		
		Properties prop=new Properties();
		
		try{
			prop.load(is);
			System.out.println(prop.get("apns_pool_size"));
		}catch (IOException e){
			e.printStackTrace();
		}

	}
}
