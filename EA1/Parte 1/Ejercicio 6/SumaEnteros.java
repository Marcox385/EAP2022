public class SumaEnteros {

    public static boolean SumaEnteros1(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == x) return true;
            }
        }

        return false;
    }

    public static boolean SumaEnteros2(int[] nums, int x) {
        int l = 0, r = nums.length - 1, sumHolder;

        while (l != r) {
            System.out.printf("L: %d; R: %d\n",l, r);
            sumHolder = nums[l] + nums[r];

            if (sumHolder > x) r--;
            else if (sumHolder < x) l++;
            else return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] A = {1,3,4,5,7,10,11}; 
        int x = 9;

        System.out.println(SumaEnteros2(A,x));
    }
}