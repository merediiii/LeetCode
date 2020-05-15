package 数学;

/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

 

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class findMedianSortedArrays {
    //O(m+n)
    public static double f(int[] nums1, int[] nums2) {
        int j = 0, k = 0, i = 0, jlen = nums1.length, klen = nums2.length;
        int len = jlen + klen;
        int[] ans = new int[len];
        while (j != nums1.length && k != nums2.length) {
            if (nums1[j] < nums2[k])
                ans[i++] = nums1[j++];
            else
                ans[i++] = nums2[k++];
        }
        if (j == nums1.length)
            while (k != nums2.length) {
                ans[i++] = nums2[k++];
            }
        if (k == nums2.length)
            while (j != nums1.length)
                ans[i++] = nums1[j++];
        if ((len & 1) == 1)
            return ans[len >> 1];
        else
            return (ans[(len >> 1) - 1] + ans[len >> 1]) / 2.0;
    }

    //O(log(m+n))
    public static double g(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length,len = m + n;
        int pri = (m + n + 1) / 2;
        int nxt = (m + n + 2) / 2;
        return (find(nums1,0,nums2,0,pri) + find(nums1,0,nums2,0,nxt)) / 2;
    }

    public static int find(int[] nums1,int i ,int[] nums2, int j, int k){
        if(i > nums1.length)
            return 0;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(g(new int[]{1, 2}, new int[]{1, 2, 3, 4, 5, 6}));
    }
}
