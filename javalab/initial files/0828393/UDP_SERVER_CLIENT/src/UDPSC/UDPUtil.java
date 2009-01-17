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
	
	public void generateDelayVsPacketSizeData()
	{
		double packetSizeDelayData[][] = new double[5000][2];    
		try {
			UDPServer server = new UDPServer();
			server.startServer(7777, 1024, null);
	
			UDPClient client = new UDPClient();
			client.setTimeout(5000);

			for(int i=128,j=1; i<5000 || j<500; j++){
				//System.out.println("i: "+i);
				client.sendFile("Assets/test", "127.0.0.1", 7777, 1024, null);
				String delay = client.getTotalTime();
				//System.out.println("\n\n\nPacket Size = "+i+" delay="+delay);
				packetSizeDelayData[j][0] = i;
				packetSizeDelayData[j][1] = Double.parseDouble(delay);
				i+=128;
			}
			
			for(int i=128,j=1; i<5000 || j<500; j++)
			{
				System.out.println(packetSizeDelayData[j][0]+"\t"+packetSizeDelayData[j][1]);
			}
			
		}catch(Exception e){}
	}

	public static void main(String [] args)
	{
		UDPUtil utilf = new UDPUtil(); 
		utilf.generateDelayVsPacketSizeData();
	}
}


