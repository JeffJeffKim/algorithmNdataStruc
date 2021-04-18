package proEdu.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Employee {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Map<Integer, String> map = new HashMap<>();
		Map<Integer, Boolean> ent = new HashMap<>();
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int empNo = Integer.parseInt(st.nextToken());
			
			if(type == 1) {
				String name = st.nextToken();
				if(map.containsKey(empNo)) {
					bw.write(empNo+" ERROR\n");
				}else {
					map.put(empNo, name);
					bw.write(empNo+" OK\n");
				}
			}else {
				if(map.containsKey(empNo)) {
					if(!ent.containsKey(empNo))
						ent.put(empNo, true);
					else
						ent.put(empNo, !ent.get(empNo));
					String status = ent.get(empNo)?"ENTER":"EXIT";
					bw.write(empNo+" "+map.get(empNo)+" "+status+"\n");
				}else {
					bw.write(empNo+" ERROR\n");
				}
			}
			
		}
		
		br.close();
		bw.close();
	}

}
