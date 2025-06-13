/*
given String s
*/

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) { // if its a key, keep going
                stack.push(c);
            } else {
                // // if its a value, check that the most current key on the stack matches it
                if (stack.isEmpty() || !(c == map.get(stack.pop()))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

/*
stack

input things on the stack

only 3 possibilies:
- () [] {}

while we have open brackets, we push onto stack
when we see closed brackets, we pop off and check for a match

hashmap
key: open
value: close

1. add to hashmap
2. declare stack
3. traverse s, if we see a key, push onto stack
4. if we see a value, pop off and check
5. if no issues and stack is empty, return true

input: s = "({[]})"
output: true

input: s = "({)}"
output: false // wrong order

time: O(n)
space: O(n)
*/