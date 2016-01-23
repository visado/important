package test;

import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

public class CharTest {

	
	public static void main(String args[]){
		
		String token = "uQAdI+ibl383ClN6zTdnYZl87pEShe7LkCQLe4GkkJU=";
		String feedbackToken = "e08f17678137b574da6b882b7dc387c061e4ea3037814ac3186206139023626c";
		byte[] tmp = feedbackToken.getBytes();

		//System.out.println((new sun.misc.BASE64Encoder()).encode(tmp));
		
		//System.out.println(Base64.encodeBase64(feedbackToken.getBytes()));
		
		byte[] bytes = Base64.decodeBase64(token);
		String hexToken = CharTest.bytesToHexString(bytes);
		hexToken = Pattern.compile("[ -]").matcher(hexToken).replaceAll("");
		System.out.println(hexToken);

		//System.out.println(CharTest.decodeHex(hexToken));
	}
	
	public static byte[] decodeHex(String hex) {
		
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			
			bytes[i] = (byte)((hexCharIndex(hex.charAt(2 * i)) << 4) | hexCharIndex(hex.charAt(2 * i + 1)));
		}
		return bytes;
	}
	
	
	private static int hexCharIndex(char hex) {
		int index = 0;
		if (hex >= '0' && hex <= '9') {
			index = hex - '0';
		} else if (hex >= 'a' && hex <= 'f') {
			index = hex - 'a' + 10;
		} else if (hex >= 'A' && hex <= 'F') {
			index = hex - 'A' + 10;
		} else {
			throw new IllegalArgumentException("Invalid hex char. " + hex);
		}
		return index;
	}
	
	public static String bytesToHexString(byte[] src){
	       StringBuilder stringBuilder = new StringBuilder("");
	       if (src == null || src.length <= 0) {
	           return null;
	       }
	       for (int i = 0; i < src.length; i++) {
	           int v = src[i] & 0xFF;
	           String hv = Integer.toHexString(v);
	           if (hv.length() < 2) {
	               stringBuilder.append(0);
	           }
	           stringBuilder.append(hv+" ");
	       }
	       return stringBuilder.toString();
	   }
}
