class Solution {
    boolean solution(String s) {
        
        String[] data = s.toLowerCase().split("");
        
        int p = 0;
        int y = 0;
        
        for(String value:data) {
            if(value.equals("p")) p++;
            else if(value.equals("y")) y++;
            else continue;
        }

        return p == y ? true : false;
    }
}