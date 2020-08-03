package com.db.util;

public class PatternConstants {

		private PatternConstants() {
	    
		}
	    public static final String ONLY_NUMBERS = "^[0-9]*$";
	    public static final String ONLY_LETTERS ="^[a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄¸‹.\\s]*$";
	    public static final String ONLY_LETTER_NUMBER ="^[a-zA-Z0-9]*$";
	    public static final String MAIL_VALID ="^(.+)@(.+)$";
	    public static final String PASSWORD_VALID ="^((?=.*[0-9]{2,})(?=.*[a-z])(?=.*[A-Z]).{8,30})$";					
	   

}
