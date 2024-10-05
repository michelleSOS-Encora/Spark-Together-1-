import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> cIm= new HashMap<>();
        int l=0;
        int max=0;
        for(int r=0;r<s.length();r++){
            char act=s.charAt(r);
            if(cIm.containsKey(act)&&cIm.get(act)>=l){
                l=cIm.get(act)+1;
            }
            cIm.put(act,r);
            max=Math.max(max, r-l+1);
        }
        return max;
    }
}
