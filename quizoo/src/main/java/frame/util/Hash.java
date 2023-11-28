package frame.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	public static byte[] getHashedBytes(String pass) throws NoSuchAlgorithmException {
		byte[] result = null;

		MessageDigest md = MessageDigest.getInstance("SHA-256");

		result = md.digest(pass.getBytes());

		return result;
	}

	public static String getHashedString(String pass) throws NoSuchAlgorithmException {
		byte[] hashedBytes = getHashedBytes(pass);

		StringBuilder sb = new StringBuilder();

		for (byte b : hashedBytes) {
			sb.append(String.format("%02x", b & 0xff));

		}

		return sb.toString();

	}
}
