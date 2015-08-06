package com.soseb.drive.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TrackidUtils {

	/**
	 * Genereate user trackid
	 * @return the new trackid
	 */
	public static String generateTrackId() {		
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(16);
	}
	
}
