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
	
	/**
	 * Test if trackid is valid or not
	 * @param userTrackid the trackid of user session
	 * @param receivedTrackid the trackid received to frontend
	 * @return boolean of comparison
	 */
	public static boolean trackidIsValid(final String userTrackid, final String receivedTrackid) {		
		return receivedTrackid.equals(userTrackid);		
	}
	
}
