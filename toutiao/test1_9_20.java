package toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1_9_20 {
    public static String simplifyPath(String path) {
        String ret = "";
        path = path.replaceAll("//", "/");
        String[] str = path.split("/");
        int len = str.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (str[i].equals(".") || str[i].isEmpty()) {
                continue;
            }
            if (str[i].equals("..")) {
                if (list.size() > 0) {
                    list.remove(list.size() - 1);
                }
                continue;
            }
            list.add(str[i]);
        }
        for (int j = 0; j < list.size(); j++) {
            ret = ret + "/" + list.get(j);
        }
        if (ret.isEmpty()) {
            ret = "/";
        }

        return ret;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String path = in.next();
        System.out.println(simplifyPath(path));
    }
}
