import java.util.ArrayList;
import java.util.Hashtable;

class Solution {
    public int solution(String[][] clothes) {
    	
    	int answer = 0;
        
    	Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
    	
    	for(String[] s:clothes)
    	{
    		if(table.containsKey(s[1]))
    		{
    			table.get(s[1]).add(s[0]);
    		}
    		else
    		{
    			ArrayList<String> tmp = new ArrayList<String>();
    			tmp.add(s[0]);
    			table.put(s[1], tmp);
    		}
    	}
        
        if(table.size() == 30)
            return 1073741823;
    	
    	String[] keys = new String[table.size()];
    	int cnt = 0;
    	for(String s:table.keySet())
    		keys[cnt++] = s;
    	
    	for(int i=0; i < 1<<keys.length; i++) {
    		int tmp=1;
            for(int j=0; j<keys.length; j++) {
                if((i & 1<<j) != 0) 
                {
                	tmp *= table.get(keys[j]).size();
                    //System.out.print(keys[j] + " ");
                }
            }
            answer += tmp;
        }
    	
    	return --answer;
    }
}