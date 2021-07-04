package practice;

public class SpecialString {
	
	public static void main(String[] args) {
		String str = "http://abc.de/fg";
		int idx = str.indexOf("//")+2;
		int idx2 = str.indexOf("/", idx);
		System.out.println(str.substring(idx, idx2));
				
	}

}
