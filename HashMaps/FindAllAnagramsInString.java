class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        // edge cases
        if (s.length() == 0 || s.length() < p.length()) {
            return new ArrayList<>();
        }

        // 2 pointers
        // int start = 0;
        // int end = 0;

        ArrayList<Integer> ret = new ArrayList<>();

        // hashmap
        /*
        HashMap<Character, Integer> stringP = new HashMap<>();
        for (char c : p.toCharArray()) {
            stringP.put(c, stringP.getOrDefault(c, 0) + 1);
        }
        */

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // traverse s
        /*for (char c : s.toCharArray()) {
            if (stringP.containsKey(c) && stringP.get(c) > 0) {
                stringP.put(c, stringP.get(c) - 1);
                end++;
            }

            // check if hashmap values are all 0
            if (emptyValues(stringP.values())) {
                ret.add(start);
                start++;
                end = start;
            }
        }*/

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (Arrays.equals(pCount, sCount)) {
                ret.add(start);
                start++;
                i = start;
            }
        }

        

        return ret;
    }

    public static boolean emptyValues(List<Integer> vals) {
        for (int val : vals) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}

// time: O(s * p)
// space: O(length of p + stack length)

/*
given: 2 strings s, p
return: list of all start indices of p's anagrams in s

input: s = racecar p = car
output: 0, 4

input: s = p = face
output: ?

only lowercase english letters
order doesn't matter since anagrams
what to do if s is empty? return empty list



edge case check:
if (String s length == 0) return empty list
if (String s length < String p length) return empty list

hashmaps
2 pointer approach
start and end pointers to find anagrams

store string p in a hashmap and compare it to s
key: character
value: frequency

int start = 0
int end = 0

traverse s
    check if char at s is in hashmap
    if yes, remove from hashamap
    inremenet end index

    if hashmap empty, add start index to list
    update start index to be end index

racecar car
car in hashmap
c 1 -> 0
a 1 -> 0
r 1 -> 0

int start = 3
int end = 3

r yes! so remove r from hashmap (updating the frequency)
incrememnt end pointer


eventually check if hashmap empty (checking values contains only 0)
    add 0 to ret list
    update start to be at end


fade hashmaps, use array instead since only care about lowercase letters (26)
*/