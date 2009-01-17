package UDPSC;

import java.security.*;
import java.math.*;

public class UDPUtil {

	public byte[] genMD5Byte(String input) {
		byte[] passBytes = input.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(passBytes);
			//BigInteger number = new BigInteger(1, messageDigest);
			//return number.toString(16).toUpperCase();
			return messageDigest;
		} catch (NoSuchAlgorithmException e) {
			throw new Error("invalid JRE: have no MD5.", e);
		}
	}
	
	public String genMD5String(String input) {
		byte[] passBytes = input.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(passBytes);
			BigInteger number = new BigInteger(1, messageDigest);
			return number.toString(16).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			throw new Error("invalid JRE: have no MD5.", e);
		}
	}
	

}


