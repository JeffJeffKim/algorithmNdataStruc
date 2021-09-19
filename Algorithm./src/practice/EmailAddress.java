package practice;

import java.util.HashSet;

//antoniorodri.guez@example.com
//antonio.rodriguez@example.com
//antonio.rodriguez+amazon@example.com
//antonio.rodriguez+ibm.com@example.com
//==> antoniorodriguez@example.com
//
//antoniorodriguez@exa.mple.com


public class EmailAddress {
    public int numUniqueEmails(String[] emails) {
	  // your code here
    	HashSet<String> hs = new HashSet<String>();
    	for(String email : emails) {
    		String filteredEmail = getEmailAddr(email);
    		hs.add(filteredEmail);
    	}
    	return hs.size();
	}
	
	private String getEmailAddr(String email) {
		String arrEmail[] = email.split("@");
		if(arrEmail[0].contains("+")) {
			//substring or split
			String local[] = arrEmail[0].split("+");
			arrEmail[0] = local[0];
		}
		
		if(arrEmail[0].contains(".")) {
			String arr[] = arrEmail[0].split(".");
			String newName = "";
			for(String str : arr) {
				newName += str;
			}
			arrEmail[0] = newName;
		}
		
		return arrEmail[0] + "@" + arrEmail[1];
	}
	
}
