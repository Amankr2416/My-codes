class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {
            int start = map.firstKey(); // smallest card
            for (int i = 0; i < groupSize; i++) {
                int curr = start + i;
                if (!map.containsKey(curr)) return false;

                int freq = map.get(curr);
                if (freq == 1) map.remove(curr);
                else map.put(curr, freq - 1);
            }
        }
        return true;
    }
}
