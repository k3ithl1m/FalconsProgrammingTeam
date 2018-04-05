// Question 76 leetcode, Number of Islands
// TwoStrings, Array

class LCMinWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int begin = 0, end = 0, head = 0, min = Integer.MAX_VALUE;
        int counter = t.length();
        for (char c: t.toCharArray()){
            map[c]++;
        }
        
        while (end < s.length()) {
            if (map[s.charAt(end)] >= 1) counter--;
            map[s.charAt(end)]--;
            end++;
            
            while (counter == 0) {
                if (end - begin < min) {
                    min = end - begin;
                    head = begin;
                }
                
                if (map[s.charAt(begin)] == 0) counter++;
                map[s.charAt(begin)]++;
                begin++;
            }
        }
        
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }
}