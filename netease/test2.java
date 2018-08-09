package netease;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Scanner;
// !@#$^&*()_+{}[],.<>/?
public class test2 {
    public static void check(String password){
        if(password.length()<8){
            System.out.println("no");
            return;
        }else{
            String sp = "!@#$^&*()_+{}[],.<>/?";
            //不同时包含大写小写数字和特殊字符
            HashMap<Character,Integer> map = new HashMap<>();
            // 'a':大写 'b':小写 'c':数字 'd':特殊
            map.put('a',0);
            map.put('b',0);
            map.put('c',0);
            map.put('d',0);
            for(int i=0;i<password.length();i++){
                if(password.charAt(i)>='A' && password.charAt(i)<='Z'){
                    if(map.containsKey('a')){
                        int index = map.get('a');
                        map.put('a', index+1);
                    }
                }
                if(password.charAt(i)>='a' && password.charAt(i)<='z'){
                    if(map.containsKey('b')){
                        int index = map.get('b');
                        map.put('b', index+1);
                    }
                }
                if(password.charAt(i)>='0' && password.charAt(i)<='9'){
                    if(map.containsKey('c')){
                        int index = map.get('c');
                        map.put('c', index+1);
                    }
                }
                for(int j=0;j<sp.length();j++){
                    if(sp.charAt(j)==password.charAt(i)){
                        if(map.containsKey('d')){
                            int index = map.get('d');
                            map.put('d', index+1);
                        }
                    }
                }
            }
            //判断时候都是有没同时包含
            if(map.get('a')==0 || map.get('b')==0 || map.get('c')==0 || map.get('d')==0){
                System.out.println("no");
                return;
            }

            //正则表达式
            Pattern pattern1 = Pattern.compile("\\d+");
            Matcher matcher1 = pattern1.matcher(password);
            Pattern pattern2 = Pattern.compile("[a-z]+");
            Matcher matcher2 = pattern2.matcher(password);
            Pattern pattern3 = Pattern.compile("[A-Z]+");
            Matcher matcher3 = pattern3.matcher(password);
            //数字
            ArrayList<String> list1 = new ArrayList<>();
            while(matcher1.find()){
                list1.add(matcher1.group());
            }
            for(int i=0;i<list1.size();i++){
                if(list1.get(i).length()>=3){
                    for(int j=1;j<list1.get(i).length()-1;j++){
                        if(list1.get(i).charAt(j)-list1.get(i).charAt(j-1)==
                                list1.get(i).charAt(j+1)-list1.get(i).charAt(j)){
                            System.out.println("no");
                            return;
                        }
                    }
                }
            }
            //小写字母
            ArrayList<String> list2 = new ArrayList<>();
            while(matcher2.find()){
                list2.add(matcher2.group());
            }
            if (checkA(list2)) return;
            //大写字母
            ArrayList<String> list3 = new ArrayList<>();
            while(matcher3.find()){
                list3.add(matcher3.group());
            }
            if (checkA(list3)) return;
            //判断是否包含常见字符串
            if(password.contains("password") || password.contains("admin")
                    ||password.contains("qwerty") || password.contains("hello") ||
                    password.contains("iloveyou") || password.contains("112233")){
                System.out.println("no");
                return;
            }
            System.out.println("yes");
        }
    }

    private static boolean checkA(ArrayList<String> list3) {
        for(int i=0;i<list3.size();i++){
            if(list3.get(i).length()>=3){
                for(int j=1;j<list3.get(i).length()-1;j++){
                    if(list3.get(i).charAt(j)-list3.get(i).charAt(j-1)==1 &&
                            list3.get(i).charAt(j+1)-list3.get(i).charAt(j)==1){
                        System.out.println("no");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] a = new String[n];
        for(int i=0;i<n;i++){
            a[i] = in.next();
        }
        for(int i=0;i<n;i++){
            check(a[i]);
        }
    }
}
