package ez;

class Solution {
    public int countOdds(int l, int h) {
        return l == h ? 1 : ((h - l) % 2 == 0 ? (((h - l) >> 1) + (l % 2)) : (h - l + 1) >> 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countOdds(3,7));
    }
}