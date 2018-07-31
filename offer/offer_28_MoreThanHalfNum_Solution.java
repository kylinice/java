package offer;
import java.util.Arrays;
import java.util.Stack;
public class offer_28_MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==1){
            return array[0];
        }
        Arrays.sort(array);
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        int limit = array.length/2;
        int num = 0;
        stack.push(array[0]);
        for(int i=1;i<array.length;i++){
            if(stack.empty()){
                stack.push(array[i]);
                count++;
            }
            //如果和栈顶元素相同，压入栈
            if(array[i] == stack.peek()){
                stack.push(array[i]);
                count++;
                //如果大于数字长度的一半直接return
                if(count>limit){
                    num = stack.peek();
                    break;
                }
            }
            else{ //如果和栈顶元素不相同，所有元素出栈
                //如果遍历超过数组一半，而且还是没有找到
                if(i+1>limit){
                    break;
                }
                //遍历未超过时，继续出栈
                while(!stack.empty()){
                    stack.pop();
                    count=0;
                }
            }
        }
        return num;
    }
    //中位数
    public int MoreThanHalfNum(int [] array) {
        int len = array.length;
        if(len<1){
            return 0;
        }
        Arrays.sort(array);
        int count = 0;
        int num = array[len/2];
        for(int i=0;i<len;i++){
            if(array[i] == num){
                count++;
            }
        }
        if(count<=len/2){
            num = 0;
        }
        return num;
    }
    //offer解法二：
    /*
    采用阵地攻守的思想：
    第一个数字作为第一个士兵，守阵地；count = 1；
    遇到相同元素，count++;
    遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
    再加一次循环，记录这个士兵的个数看是否大于数组一半即可。
     */


    public static void main(String[] args) {
        offer_28_MoreThanHalfNum_Solution test = new offer_28_MoreThanHalfNum_Solution();
        int a[] = {1,2,2,4,4,4};
        System.out.println(test.MoreThanHalfNum_Solution(a));
    }
}
