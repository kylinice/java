package offer;
/*
将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class offer_49_StrToInt {
    public int StrToInt(String str) {
        if(str.length()==0 || str==null){
            return 0;
        }
        char a[] = str.toCharArray();
        //flag=0表示正数，flag=1表示负数
        int flag = 0;
        if(a[0]=='-'){
            flag = 1;
        }
        long sum = 0;
        for(int i=flag;i<a.length;i++){
            if(a[i]=='+' && i==0){
                continue;
            }
            if(a[i]<'0' || a[i]>'9'){
                return 0;
            }
            sum = sum*10 + (a[i]-'0');
            if(sum>Integer.MAX_VALUE){
                if(flag==0){
                    return 0;
                }else{
                    if(-1*sum<Integer.MIN_VALUE){
                        return 0;
                    }
                }
            }
        }
        return flag == 0 ? (int)sum : (int)sum * -1;
    }

    public static void main(String[] args) {
        offer_49_StrToInt test = new offer_49_StrToInt();
        String []a = {"", "--4", "sdsld", "12.34", "-344", "--5;asldf", "00088", "-+4", "++7", "+832", "443",
                "999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
                "2147483647", "-2147483648", "2147483648", "-2147483649"};
        for(int i=0;i<a.length;i++){
            System.out.println(test.StrToInt(a[i]));
        }
        //System.out.println(Integer.parseInt("++4"));

    }
}
