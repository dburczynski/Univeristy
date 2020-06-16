package pk1;

import java.util.regex.Pattern;

public class DataChecker {
	static void nameCheck(String a) {
		if(a.length() == 0) {
			
		}
		if(a.length() <= 2) {
			
		}
		if(!Pattern.matches("[a-zA-X]+", a)) {
			
		}
	}
}
