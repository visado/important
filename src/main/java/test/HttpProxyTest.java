package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class HttpProxyTest {

	public static void main(String[] args) {
		
		//System.setProperty("http.proxyHost", "10.181.10.122");  
		//System.setProperty("http.proxyPort", "80");
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.181.10.122",80));
		
		// TODO Auto-generated method stub
		HttpURLConnection conn;
		try {
			URL url = new URL("https://www.baidu.com");
			conn = (HttpURLConnection)url.openConnection(proxy);
			
			//设置超时间为3秒
			conn.setConnectTimeout(3*1000);
			//防止屏蔽程序抓取而返回403错误
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			//得到输入流
			InputStream inputStream = conn.getInputStream();  
			//获取自己数组
			byte[] getData = readInputStream(inputStream);
			System.out.println(getData);

			//文件保存位置
			File saveDir = new File("da");
			if(!saveDir.exists()){
				saveDir.mkdir();
			}
			File file = new File(saveDir+File.separator+"adc");    
			FileOutputStream fos = new FileOutputStream(file);     
			fos.write(getData); 
			if(fos!=null){
				fos.close();  
			}
			if(inputStream!=null){
				inputStream.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	/**
	 * 从输入流中获取字节数组
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static  byte[] readInputStream(InputStream inputStream) throws IOException {  
		
		byte[] buffer = new byte[1024];  
		int len = 0;  
		ByteArrayOutputStream bos = new ByteArrayOutputStream();  
		while((len = inputStream.read(buffer)) != -1) {  
			bos.write(buffer, 0, len);  
		}  
		bos.close();  
		return bos.toByteArray();  
	} 
}
