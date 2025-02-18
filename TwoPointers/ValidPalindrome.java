class Solution {
    public boolean isPalindrome(String s) {
        // convert string to lowercase
        s = s.toLowerCase();
        
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i != j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i != j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}

// given: string s

// task: return true if palindrome

// approach:
    /*
    convert string to lowercase, remove all non-alphanumeric characters
    use 2 pointers - one front one back and keep comparing until difference found
    if no difference found return true
    */

// time: O(n)
// space: O(1)