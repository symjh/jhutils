package jh.letcode;

/**
 * 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2 {



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode();
        ListNode now1 = l1;
        ListNode now2 = l2;
        ListNode rsnow = rs;
        Integer temp = 0;
        while (now1!=null || now2!=null || temp>0){
            Integer n1 = now1 == null ? 0:now1.val;
            Integer n2 = now2 == null ? 0:now2.val;
            Integer sum = n1 + n2 + temp;
            rsnow.val = sum % 10;
            temp = sum /10;
            now1 = now1 == null ? null: now1.next;
            now2 = now2 == null ? null: now2.next;
            if(now1!=null || now2!=null || temp>0) {
                rsnow.next = new ListNode();
                rsnow = rsnow.next;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
//        l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        l8.next = l9;
        l9.next = l10;
        l10.next = l11;

        ListNode rs = addTwoNumbers(l1,l8);
        System.out.println(rs);
    }


}
