package offer;

/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

 */
public class offer_53_isNumeric {
    //正则表达式法
    public static boolean isNumeric(char[] str) {
        String string = String.valueOf(str);

        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    public static void main(String[] args) {
        String str = "123.45e+6";
        char a[] = str.toCharArray();
        System.out.println(isNumeric(a));
    }
}
