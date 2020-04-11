package practice;

import java.util.ArrayList;
import java.util.List;

class LogExtract {
	
    /**
     * Tags used to flag important log messages.
     **/
    enum Tag {
        // fill in with necessary details -- COMPLETING THIS IS OPTIONAL, BUT BONUS IF YOU USE THIS CORRECTLY!
    	ERROR, EXCEPTION, RESULT
    }
    
    /**
     * Encapsulates important log messages for further processing.
     **/
    class Important {
        // fill in with necessary details
    	public Tag tag;
    	public String msg;

    	public Important(Tag tag, String msg) {
			this.tag = tag;
			this.msg = msg;
		}
    	
    	@Override
    	public String toString() {
    		return tag.toString()+" found: "+msg;
    	}
    }
    
    List<Important> highlights;
    
    public LogExtract() {
        // add necessary stuff here
    	highlights = new ArrayList<Important>();
    }
    
    public String solution(String log) {
        // write your code in Java
    	if(log != null) {
    		String[] lines = log.split("\n");
    		for(String line: lines) {
    			if(line.lastIndexOf(":") < 15)	continue;
    			String strTag = line.substring(20, line.indexOf(":", 20));
//    			System.out.println(strTag);
//    			String strDate = line.substring(0, line.indexOf("-")).trim();
    			
    			Tag tag = null;
    			for(Tag t : Tag.values()) 
    				if(strTag.equals(t.toString())) {
    					tag = t;
    					break;
    				}

				if(tag != null)
    				highlights.add(new Important(tag, line));
    		}
    	}
        
        ///// DO NOT CHANGE THE CODE BELOW /////
        return formatResults();
    }
    
    ///// DO NOT CHANGE CODE BELOW /////
    private String formatResults() {
        String results = "{";
        for (Important item : highlights) {
            results += "'" + item + "',";
        }
        results += "}";
        return results;
    }
    
	public static void main(String[] args) {
		LogExtract s = new LogExtract();
		String log = "20181115 15:71:01 - Doing something\n"
		+"20181115 15:01:01 - ERROR: something1\n"
		+"20181115 15:01:01 - ERRO: something1\n"
		+"20181115 15:01:01 - :RRO: something1";
		
//		log = "20181115 15:01:01 - Doing something\\n"
//				+"20181115 15:01:01 - Doing something else\\n"
//				+"20181115 15:01:02 - EXCEPTION: SillyUnexpectedException\\n"
//				+"20181115 15:01:03 - ERROR: Oops!\\n"
//				+"20181115 15:01:04 - Giving up\\n"
//				+"20181115 15:01:05 - RESULT: TEST FAILED\\n";
//		log = "20181115 15:01:01 - Doing something\\n"
//				+"20181115 15:01:01 - Doing something else\\n"
//				+"20181115 15:01:04 - Done\\n"
//				+"20181115 15:01:05 - RESULTING BEHAVIOR: OK\\n"
//				+"20181115 15:01:05 - RESULT: OK\\n";
//		log = "20181115 15:01:05 - RESULT: Done\\n";
//		log = null;
//		log = "";
		System.out.println(s.solution(log));
	}
}