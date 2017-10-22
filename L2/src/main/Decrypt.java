package main;

import java.awt.Toolkit;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt implements Runnable{

	String keysuff = "92c6224d8cde48525ef7e8710fcf25e315b0a0ef027976142d39a93";
	byte[] iv = IV("2fefd5213dbd3b3d99ef0b2b3bfb4e28");
	String b64 = "/1JQTBqWwZe/f4O1bX88Iyl6ov9FonkWQ5bGmmmR/2J1TJRvgTE5gehh93Hf+ICC3kyzcSsg4bGUdLyauwAa+P+zSfxijd4FNIdl827KoCS5MHaU4Lh3/o3ajyQ2sqmXEWTBD5HFv+cqJT4c2YVoiA==";
	Decoder dec = Base64.getDecoder();
	byte[] decoded = dec.decode(b64.getBytes());
	IvParameterSpec ivs = new IvParameterSpec(iv);
	Cipher c;

	public void decodeMsg(String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException{
		byte[] kv = hexStringToByteArray(key);
		SecretKeySpec sks = new SecretKeySpec(kv, "AES");
		c.init(Cipher.DECRYPT_MODE, sks, ivs);
		byte[] end = c.update(decoded);
		if(check(end)){
			Toolkit.getDefaultToolkit().beep();
			printb(end);
			System.out.println("found for key: " + key);
		}
	}
	public byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	private boolean check(byte[] end) {
		int max = end.length >> 4;
	    int counter = 0;
		for(int i = 0; i < end.length; ++i){
			if(end[i] > 0)
				continue;
			else if (counter > max)
				return false;
			else
				counter++;
		}
		return true;
	}
	public void printb(byte[] b){
		for(int i = 0; i < b.length; ++i){ System.out.print((char)b[i] + " "); }
		System.out.println();
	}
	private byte[] IV(String iv){
		byte[] result = new byte[iv.length() / 2];
		for(int i = 0; i < result.length; ++i){	result[i] = (byte) Integer.parseInt(iv.substring(2*i, 2*i + 2) , 16); }
		return result;
	}
	public void run() {
		int id = Integer.parseInt(Thread.currentThread().getName());
		try { c = Cipher.getInstance("AES/CBC/PKCS5Padding");}
		catch (NoSuchAlgorithmException | NoSuchPaddingException e2) { e2.printStackTrace(); }
		// 16 threads
		int a = id;
		System.out.println("Thread nr " + id +  " started");
		System.out.println("Thread nr " + id + " current first char: " + Integer.toHexString(a));
		for (int b = 0; b < 16; ++b){
			for (int c = 0; c < 16; ++c){
				for (int d = 0; d < 16; ++d){
					for (int e = 0; e < 16; ++e){
						for (int f = 0; f < 16; ++f){
							for (int g = 0; g < 16; ++g){
								for (int h = 0; h < 16; ++h){ // 56 chars
									for (int z = 0; z < 16; ++z){ //55 chars
										String key = Integer.toHexString(a) + Integer.toHexString(b) + Integer.toHexString(c) + Integer.toHexString(d) + Integer.toHexString(e) + Integer.toHexString(f) +
												Integer.toHexString(g) + Integer.toHexString(h) + Integer.toHexString(z) + keysuff;
										try { decodeMsg(key);}
										catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
												| InvalidAlgorithmParameterException e1) {	e1.printStackTrace(); }
									}
								}
							}
						}
					}
				}
			}
			if (id == 0 ) {	System.out.println("Done: "+ b + 1 + "/16" + " - " + Integer.toHexString(b)); }
		}
		System.out.println("Thread nr " + id +  " ended");
	}
}
