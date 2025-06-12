class Solution {
    public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }

    HashMap<Character, Integer> map = new HashMap<>();

    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    // subtract t from map
    for (char c : t.toCharArray()) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) - 1);
        } else {
            return false;
        }
    }
    for (char c : map.keySet()) {
        if (map.get(c) != 0) {
            return false;
        }
    }
    return true;
}

// time: O(n)
// space: O(n)
}

// tar rat

/*
return true if t is an anagram of s

hashmap

store characters of string s in a hashmap
key: character
value: frequency

first check - ensure that s and t are the same length

fill map with s

for (every letter in t) {
    if (letter is in hashmap) {
        update freqency
    } else {
        return false
    }
}

if hashmap values is empty, return true

// time: O(n)
// spce: O(n)
*/