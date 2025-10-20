package problem_2187_minimum_time_to_complete_trips;

public class Solution {
    public static long minimumTime(int[] time, int totalTrips) {
        long lo = 1;
        int minTime = Integer.MAX_VALUE;
        for (int t : time) minTime = Math.min(t, minTime);
        long hi = (long) minTime * totalTrips;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (canFinish(time, totalTrips, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static boolean canFinish(int[] time, int totalTrips, long T) {
        long total = 0;
        for (int t : time) {
            total += (long) T / t;
            if (total >= totalTrips) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] time = new int[]{1,2,3};
        int totalTrips = 5;
        System.out.println(minimumTime(time, totalTrips));
    }
}
