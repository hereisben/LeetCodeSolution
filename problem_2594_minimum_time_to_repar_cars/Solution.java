package problem_2594_minimum_time_to_repar_cars;

public class Solution {
    public static long repairCars(int[] ranks, int cars) {
        long lo = 0;
        int rmin = Integer.MAX_VALUE;
        for (int r : ranks) rmin = Math.min(r, rmin);
        long hi = (long) (rmin * cars * cars);

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (canFinish(ranks, cars, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static boolean canFinish(int[] ranks, int cars, long T) {
        long total = 0;
        for (int r : ranks) {
            long maxCars = (long) Math.sqrt((double) T / r);
            total += maxCars;
            if (total >= cars) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] ranks = new int[]{4,2,3,1};
        int cars = 10;
        System.out.println(repairCars(ranks, cars));
    }
}
