package mx.edu.itspa.esgi.scse.commons;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class EncryptHash {
	public static String getHash(byte[] inputBytes, String algorithm) {
		String myHash="";
		try {
	    MessageDigest md = MessageDigest.getInstance(algorithm);
	    md.update(inputBytes);
	    byte[] digest = md.digest();
	    myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	    return myHash;
	}
}
