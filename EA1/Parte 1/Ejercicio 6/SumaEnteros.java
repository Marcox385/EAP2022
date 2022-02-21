public class SumaEnteros {

    public static boolean SumaEnteros1(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == x) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 5, 7, 9, 12, 13};
        int x = 16;

        System.out.println(SumaEnteros1(A,x));
    }
}