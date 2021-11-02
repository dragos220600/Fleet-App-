package com.fleetapp.fleetapp.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddressFormatChecker {
	
	public void checkEmail(String email)
	{
		Pattern emailPattern = Pattern.compile(email, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPattern.matcher(email);
		boolean matchFound = matcher.find();
		
		if(!matchFound)
		{
			
		}

	}

}
