package 数学;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class myPow {

    public double f(double x, int n) {
        double res = 1.0;
        for(int i = n ; i != 0; i  /=  2){ //这里的n不能取abs(n),因为n的范围是int的范围,-2^31~2^31-1,故取绝对值统一处理成正数会导致n溢出
            if((i%2) != 0){
                res *= x;                   //x的n次方,如果是奇数的话,就是要多乘一个x,偶 = 奇 + 偶
            }
            x *= x;                         //如果是偶数的话,就直接是平方了
        }
        return n > 0? res:1/res;

    }


}
