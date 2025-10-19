public class Solution {
    public static int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h == 0) return 0;

        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(piles, h, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k;
            if (hours > h) return false;
        }
        return hours <= h;
    }
    
    public static void main(String[] args) {
        int[] piles = new int[]{30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }
}
