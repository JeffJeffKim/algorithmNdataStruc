package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IndexOfSubString {
	
	public static void main(String[] args) {
		String s = "\"startTime\":\"2020-06-19T20:52:35.8798936\",\"updatedAt\":\"9999-12-31T23:59:59.9998899\"";
		int idx1 = s.indexOf("\"startTime\":\"");
		int idx2 = s.indexOf("\"updatedAt\":\"");
		String ss = s.substring(idx1+13, idx2);
		System.out.println(ss);
		System.out.println(s.substring(idx1+13, idx1+40));
		System.out.println("updatedAt: "+s.substring(idx2+13, idx2+32));
		String parsedStr = s.substring(idx2+32);
		int idx3 = parsedStr.indexOf("\"");
		System.out.println("updatedAt2: "+s.substring(idx2+13, idx2+32+idx3));
		System.out.println(getParsedUpdatedAt(s));
		
		
		
//		List<String> ls = Arrays.asList("111", "223", "1112", "222");
		
	}
	
    private static String getParsedUpdatedAt(String str){
    	System.out.println(str);
        final String sUpdateAtWithBS = "\"updatedAt\":\"";
        if(str == null || !str.contains(sUpdateAtWithBS))
            return null;

        int idx = str.indexOf(sUpdateAtWithBS);
        String strStartWithUpdatedAt = str.substring(idx+32);
        int idx2 = strStartWithUpdatedAt.indexOf("\"");

        return str.substring(idx+13, idx+32+idx2);
    }

}
