package 栈;

import java.util.ArrayList;
/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 

示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 

提示：

pop、top 和 getMin 操作总是在 非空栈 上调用。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    ArrayList<Integer> list;
    ArrayList<Integer> min;
    int minInt;
    int top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        top = -1;
        list = new ArrayList<>();
        min = new ArrayList<>();
        minInt = 0x7fffffff;
    }

    public void push(int x) {
        list.add(x);
        if(top<0){
            min.clear();
        }
        ++top;
        if (x < minInt)
            minInt = x;
        min.add(minInt);
    }

    public void pop() {
        list.remove(top);
        min.remove(top);
        top--;
        if(top >= 0) minInt = min.get(top);
        if(top < 0 )
            minInt = 0x7fffffff;
    }

    public int top() {
        return list.get(top);
    }

    public int getMin() {
        return min.get(top);
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-10);
        obj.push(-10);
        int param_1 = obj.getMin();
        int param_2 = obj.getMin();
        obj.push(-20);
        int param_3 = obj.getMin();

        System.out.println(param_1+" "+param_2+" "+param_3);
        param_1 = obj.getMin();
        param_2 = obj.top();
        param_3 = obj.getMin();
        System.out.println(param_1+" "+param_2+" "+param_3);
        obj.pop();
        obj.push(10);
        obj.push(-7);
        System.out.println(obj.getMin());
        System.out.println(Integer.MAX_VALUE);
    }
}
