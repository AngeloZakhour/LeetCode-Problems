//SUCCESSFUL

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        char[] array = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            array[i] = s.charAt(i);
        }
        int maxCtr = 1;
        int ctr = 1;

        for(int i=1; i<array.length; i++){
            for(int j=i-ctr; j<i; j++){
                if(array[j] == array[i]){
                    ctr = i-j-1;
                }
                if(j==i-1)
                    ctr++;
            }
            if(ctr > maxCtr)
                maxCtr = ctr;
        }

        return maxCtr;
    }
}