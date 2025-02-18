class Solution {
    public boolean isSubsequence(String s, String t) {
        int tIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            while (tIndex < t.length() && s.charAt(i) != t.charAt(tIndex)) {
                tIndex++;
            }
            tIndex++;
        }
        if (tIndex > t.length()) {
                return false;
        }
        return true;
    }
}

/*

given: string s, string t

task: return true if s is a subsequence of t

approach:
    traverse string s and string t at the same time (two pointers)
    for each letter in s, keep pushing forward in t until found
    if not found, return false

time: O(n)
space: O(1)

*/