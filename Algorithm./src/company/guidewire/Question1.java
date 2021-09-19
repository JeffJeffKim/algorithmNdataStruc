package company.guidewire;

public class Question1 {
	
	public static void main(String[] args) {
		System.out.println(solution("eedaaad"));
		System.out.println(solution("xxxtxxx"));
		System.out.println(solution("uuuuxaaaaxuuu"));
	}
	
	static public String solution(String S) {
        String result = "";
        char prev = 'A';
        int count = 0;
        for(int i=0; i<S.length(); i++) {
        	char cur = S.charAt(i);
        	if(prev == cur) {
        		count++;
        		if(count >=2) {
        			
        		} else {
        			result += cur;
        		}
        	} else {
        		prev = cur;
        		count = 0;
        		result += cur;
        	}
        }
		return result;
    }

}
