/*
given: int nums[], int k
return k most frequent elements

any order


*/

public int[] topKFrequentElements(int nums[], int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a, b) -> map.get() - map.get(b)
    );

    for (int key : map.keySet()) {
        pq.add(key);
        if (pq.size() > k) {
            pq.poll(); // remove smallest if we already have k in pq
        }
    }

    int[] ret = new int[k];
    for (int i = 0; i < k; i++) {
        ret[i] = pq.poll();
    }

    return ret;
}

// time: O(nlogk) for building then maintaining heap
// space: O(n)

/*
hashmap to count the frequency of each unique element
key: element
value: frequency

sort by frequency, return the top k - Priority Queue

map

traverse nums
    add to hashmap


*/