package company.resMed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Solution1 {
	
	public static void main(String[] args) throws IOException {
//		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//		BufferedReader in = new BufferedReader(reader);
//		String line = "10:00 AM - 11:00 AM";
		String line = "1:00 PM - 11:00 AM";
		
		StringTokenizer st = new StringTokenizer(line);
		String[] sStr = st.nextToken().split(":");
		int sHour = Integer.parseInt(sStr[0]);
		int sMin = Integer.parseInt(sStr[1]);
		String sAmpm = st.nextToken();
		if("PM".equals(sAmpm))
			sHour += 12;
		int sTotal = sHour*60 + sMin;
		
		st.nextToken(); // -

		String[] eStr = st.nextToken().split(":");
		int eHour = Integer.parseInt(eStr[0]);
		int eMin = Integer.parseInt(eStr[1]);
		String eAmpm = st.nextToken();
		if("PM".equals(eAmpm))
			eHour += 12;
		int eTotal = eHour*60 + eMin;
		
		if(sTotal > eTotal)
			eTotal += 24*60;
		
		System.out.println(eTotal-sTotal);
		
//		while ((line = in.readLine()) != null) {
//			
//			System.out.println(line);
//		}
//		reader.close();
	}

}



//public static void main(String[] args) throws IOException {
//    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//    BufferedReader in = new BufferedReader(reader);
//    String line;
//    while ((line = in.readLine()) != null) {
//      
//      StringTokenizer st = new StringTokenizer(line);
//      String[] sStr = st.nextToken().split(":");
//      int sHour = Integer.parseInt(sStr[0]);
//      int sMin = Integer.parseInt(sStr[1]);
//      String sAmpm = st.nextToken();
//      if("PM".equals(sAmpm))
//        sHour += 12;
//      int sTotal = sHour*60 + sMin;
//
//      st.nextToken(); // -
//
//      String[] eStr = st.nextToken().split(":");
//      int eHour = Integer.parseInt(eStr[0]);
//      int eMin = Integer.parseInt(eStr[1]);
//      String eAmpm = st.nextToken();
//      if("PM".equals(eAmpm))
//        eHour += 12;
//      int eTotal = eHour*60 + eMin;
//
//      if(sTotal > eTotal)
//        eTotal += 24*60;
//      line = String.valueOf(eTotal - sTotal);
//      System.out.println(line);
//    }
//  }
