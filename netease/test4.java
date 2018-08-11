package netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test4 {

    public List<List<Character>> permuteUnique(char[] nums) {
        List<List<Character>>res=new ArrayList<>();
        List<Character>list=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        if(nums==null||nums.length<=0){return res;}
        //Arrays.sort(nums);
        backtracking(nums,list,res,used);
        return res;
    }
    private void backtracking(char[] nums,List<Character> list,List<List<Character>> res,boolean[] used){
        if(list.size()==used.length){res.add(new ArrayList<>(list));return;}
        for(int i=0;i<used.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){continue;}
            if(used[i]){continue;}
            used[i]=true;
            list.add(nums[i]);
            backtracking(nums,list,res,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public static void main(String[] args){
        test4 test = new test4();


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        String str = "";
        for(int i=0;i<n;i++){
            str += 'a';
        }
        for(int i=0;i<m;i++){
            str += 'z';
        }

        char num[] = str.toCharArray();
        //list = test.Permutation(str);
        List<List<Character>> list = test.permuteUnique(num);
        if(k>list.size()){
            System.out.println(-1);
        }else{
            StringBuilder temp = new StringBuilder();
            for(Character ch:list.get(k-1)){
                temp.append(ch);
            }
            System.out.println(temp.toString());
        }
    }
}
