package company.city;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class citiTest1 {
	final static String NO = "NO";
	private final static int MAX_VAL = 1_000_000_000;
	private final static int MIN_VAL = -1_000_000_000;
	public static void main(String[] args) {
//		char data = '1';
//		int num = data - '0';
//		System.out.println(num);
		String str = "  +137";
		String getStr = isInt(str);
        if(!getStr.equals(NO)){
            int num = Integer.parseInt(getStr);
            if(num < MAX_VAL && num > MIN_VAL)
                System.out.println("range");
            System.out.println(str+" "+Integer.parseInt(isInt(str)));
        }else {
        	System.out.println(NO);
        }
	}
	
	private static String isInt(String str) {
    	boolean hasPlusMinus=false, startNum=false;
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<str.length(); i++) {
    		char c = str.charAt(i);
    		if(!startNum && !hasPlusMinus) {
				if(c == ' ') {
					continue;
				} else {
					if(c == '+' || c == '-') {
						hasPlusMinus = true;
						if(c == '-')
							sb.append(c);
					} else if(Character.isDigit(c)) {
						startNum = true;
						sb.append(c);
					}
				}
    		} else {
    			if(!Character.isDigit(c))
    				return NO;
    			sb.append(c);
    		}
    	}
    	if(!startNum && !hasPlusMinus)
    		return NO;
    	return sb.toString();
    }

}

class SolutionIter implements Iterable<Integer> {
	private final int MAX_VAL = 1_000_000_000;
	private final int MIN_VAL = -1_000_000_000;
	private Reader  inp;
	
    public SolutionIter(Reader inp) {
    	this.inp = inp;
    	iterator();
    }

    public Iterator<Integer> iterator(){
    	List<Integer> list = new ArrayList<Integer>();
    	int readChar;
    	try {
    		StringBuilder sb = new StringBuilder();
			while ((readChar = inp.read()) != -1) {
			    char data = (char)readChar;
			    if(data == '\n') {
			    	int num = Integer.parseInt(sb.toString());
			    	sb = new StringBuilder();
			    }else {
			    	sb.append(data);
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return list.iterator();
    }
    
    private boolean isInt(String str) {
    	boolean hasPlusMinus=false, startNum=false;
    	
    	for(int i=0; i<str.length(); i++) {
    		char c = str.charAt(i);
    		if(!startNum && !hasPlusMinus) {
				if(c == ' ') {
					continue;
				} else {
					if(c == '+' || c == '-') {
						hasPlusMinus = true;
					} else if(!Character.isDigit(c)) {
						startNum = true;
					}
				}
    		} else {
    			if(c == ' ')
    				return false;
    			if(!Character.isDigit(c))
    				return false;
    		}
    	}
    	return true;
    }
}