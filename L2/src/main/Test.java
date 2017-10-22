package main;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.NoSuchPaddingException;

public class Test {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchProviderException{
		Runnable[] decrypters = new Runnable[16];
		Thread[] threads = new Thread[16];
		for(int i = 0; i < 16; ++i){ decrypters[i] = new Decrypt(); }
		for(int i = 0; i < 16; ++i){ threads[i] = new Thread(decrypters[i], Integer.toString(i)); }
		for(int i = 0; i < 16; ++i){ threads[i].start(); }
	}
}
