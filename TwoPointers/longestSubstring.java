/*
longest substring without repeating characters

given String s
find length of longest substring without repeating characters

input: "abcabcabc"
output: 3

sliding window
pointer 1 starts at start
pointer 2 goes until a same character is found - using hashset
when found, stores the value of unique characters (pointer 2 - 1) - store in an int,
                                                        replace if find a higher value
then pointer 1 joins 2 and repeat
return the greatest length
*/

public int longestSubstring(String s) {
    if (s.length() == 0) {
        return 0;
    }
    if (s.length() == 1){
        return 1;
    }
    

    int ptr1 = 0;
    int ptr2 = 0;
    int ret = 0;
    HashSet<Character> set = new HashSet<>();

    while(ptr2 < s.length()) {
        if (!set.contains(s.charAt(ptr2))) {
            set.add(s.charAt(ptr2));
            ptr2++;
            ret = Math.max(ret, ptr2 - ptr1);
        } else {
            set.remove(s.charAt(ptr1));
            ptr1++;
        }
    }
    return ret;
}

// time: O(n)
// space: O(n)