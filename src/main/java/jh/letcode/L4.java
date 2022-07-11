package jh.letcode;

import jh.utils.array.ArrayView;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *  
 *
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L4 {

    // 归并排序中的合并数组思路
    public static double merge(int[] nums1,int[] nums2){
        // nums1 = [1,2]
        // nums2 = [3,4]
        int[] rs = new int[nums1.length+nums2.length];
        // nums1的当前位置
        int index1 = 0;
        // nums2的当前位置
        int index2 = 0;
        for(int i = 0;i <rs.length;i++){
            // 超出代表 nums1全部元素都比nums2小
            if((index1+1)>nums1.length){
                rs[i] = nums2[index2];
                index2++;
                continue;
            }
            if((index2+1)>nums2.length){
                rs[i] = nums1[index1];
                index1++;
                continue;
            }

            if(nums1[index1] <= nums2[index2]){
                rs[i] = nums1[index1];
                index1++;
            }else {
                rs[i] = nums2[index2];
                index2++;
            }
            
        }

        // 求中位数
        int temp = rs.length/2;
        double result = 0.f;
        if(rs.length%2 == 0){
            Integer sum = rs[temp-1]+rs[temp];
            result = Double.parseDouble(sum.toString())/2;
        }else{
            result = rs[temp];
        }
        ArrayView.view(rs);

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(merge(nums1,nums2));
    }

}
