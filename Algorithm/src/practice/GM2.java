package practice;

import java.io.IOException;

public class GM2 {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
//    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//    BufferedReader in = new BufferedReader(reader);
//    String line;
//    while ((line = in.readLine()) != null) {
//      System.out.println(line);
//    }
	  String line = "5;0,1,2,3,0";
//	  String line = "20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14";
	  int arr[] = getArr(line);
	  System.out.println(getDup(arr));
  }
  
  static int getDup(int[] arr) {
	  boolean[] isExist = new boolean[arr.length-1];
	  for(int num : arr)
		  if(isExist[num])
			  return num;
		  else
			  isExist[num] = true;
	  
	  return -1;
  }
  
  static int[] getArr(String line) {
	  String[] arrInput = line.split(";");
	  String[] arrNum = arrInput[1].split(",");
	  int[] result = new int[arrNum.length];
	  for(int i=0; i<result.length; i++)
		  result[i] = Integer.parseInt(arrNum[i]);
	  return result;
//	  int count = Integer.parseInt(arrInput[0]);
////	  int len = strArr[1].length()/2 + 1;
//	  int len = arrInput[1].length();
////	  int[] result = new int[count];
//	  for(int i=0, j=0; i<len; i+=2, j++) {
//		  result[j] = Character.getNumericValue(strArr[1].charAt(i));
//	  }
//	  
//	  return result;
  }
}