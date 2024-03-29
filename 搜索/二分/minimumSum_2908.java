package 搜索.二分;

public class minimumSum_2908 {
    public int minimumSum(int[] nums) {
        boolean isSeq = false;
        if(nums.length == 3 && (nums[0]==nums[1]) || (nums[1]==nums[2]))
            return -1;
        boolean leftToRight = nums[1] > nums[0];
        if(leftToRight)
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] > nums[i-1]){

                }else {
                    isSeq = true;
                }
            }
        else

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                isSeq = true;
            }else {
                
            }
        }
        if(isSeq) return -1;
        return binarySum(nums);
    }

    private int binarySum(int[] nums) {
    }

    public static void main(String[] args) {
        minimumSum_2908 obj = new minimumSum_2908();
        System.out.println(obj.minimumSum(new int[]{5,4,8,7,10,2}));
    }
}
