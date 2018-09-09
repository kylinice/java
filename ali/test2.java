package ali;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class test2 {
    private static void find(String loc, String xy_arr){
        String[] a = loc.split(",");
        String[] b = xy_arr.split(",");
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        ArrayList<Double> polygonXA = new ArrayList<>();
        ArrayList<Double> polygonYA = new ArrayList<>();
        for(int i=0;i<b.length;i=i+2){
            polygonXA.add(Double.parseDouble(b[i]));
        }
        for(int i=1;i<b.length;i=i+2){
            polygonYA.add(Double.parseDouble(b[i]));
        }
        boolean flag = isPointInPolygon(Double.parseDouble(a[0]), Double.parseDouble(a[1]), polygonXA, polygonYA);
        if(flag){
            System.out.println("yes,0");
        }else{
            calculate(Double.parseDouble(a[0]), Double.parseDouble(a[1]), polygonXA, polygonYA);
        }
    }
    private static void calculate(double px, double py,
                                  ArrayList<Double> polygonXA, ArrayList<Double> polygonYA){
        ArrayList<Double> arr = new ArrayList<>();
        for(int i=0;i<polygonXA.size();i++){
            double sum = distance(px, py, polygonXA.get(i), polygonYA.get(i));
            arr.add(sum);
        }
        ArrayList<Double> copy = new ArrayList<>(arr);
        Collections.sort(arr);
        //System.out.println("no," + Math.round(arr.get(0)));
        //System.out.println("no," + Math.round(copy.get(0)));
        double first = arr.get(0);
        double second = arr.get(1);
        int first_index=0;
        int second_index=0;
        int flag = 0;
        for(int i=0;i<copy.size();i++){
            if(first==copy.get(i)){
                first_index = i;
                flag++;
            }
            if(second==copy.get(i)){
                second_index = i;
                flag++;
            }
            if(flag==2){
                break;
            }
        }
        //System.out.println(first_index + "," + second_index);
        double aa = distance(px, py, polygonXA.get(first_index), polygonYA.get(first_index));
        double bb = distance(px, py, polygonXA.get(second_index), polygonYA.get(second_index));
        double cc = distance(polygonXA.get(first_index), polygonYA.get(first_index),
                polygonXA.get(second_index), polygonYA.get(second_index));
        double ESP = 1e-9;
        double dis;
        if(cc<=ESP){
            dis = aa;
        }else{
            if(bb*bb >= aa*aa + cc*cc){
                dis = aa;
            }else if(aa*aa >= bb*bb + cc*cc){
                dis = bb;
            }else{
                double pp = (aa+bb+cc)/2;
                double s = Math.sqrt(pp*(pp-aa)*(pp-bb)*(pp-cc));
                dis = 2*s/cc;
            }
        }
        System.out.println("no," + Math.round(dis));

    }
    public static boolean isPointInPolygon(double px, double py,
                                    ArrayList<Double> polygonXA, ArrayList<Double> polygonYA) {
        boolean isInside = false;
        double ESP = 1e-9;
        int count = 0;
        double linePoint1x;
        double linePoint1y;
        double linePoint2x = 180;
        double linePoint2y;

        linePoint1x = px;
        linePoint1y = py;
        linePoint2y = py;

        for (int i = 0; i < polygonXA.size() - 1; i++) {
            double cx1 = polygonXA.get(i);
            double cy1 = polygonYA.get(i);
            double cx2 = polygonXA.get(i + 1);
            double cy2 = polygonYA.get(i + 1);
            if (isPointOnLine(px, py, cx1, cy1, cx2, cy2)) {
                return true;
            }
            if (Math.abs(cy2 - cy1) < ESP) {
                continue;
            }

            if (isPointOnLine(cx1, cy1, linePoint1x, linePoint1y, linePoint2x,
                    linePoint2y)) {
                if (cy1 > cy2)
                    count++;
            } else if (isPointOnLine(cx2, cy2, linePoint1x, linePoint1y,
                    linePoint2x, linePoint2y)) {
                if (cy2 > cy1)
                    count++;
            } else if (isIntersect(cx1, cy1, cx2, cy2, linePoint1x,
                    linePoint1y, linePoint2x, linePoint2y)) {
                count++;
            }
        }
        if (count % 2 == 1) {
            isInside = true;
        }

        return isInside;
    }

    public static double Multiply(double px0, double py0, double px1, double py1,
                           double px2, double py2) {
        return ((px1 - px0) * (py2 - py0) - (px2 - px0) * (py1 - py0));
    }
    public static double distance(double px0, double py0, double px1, double py1) {
        return Math.sqrt((px1 - px0) * (px1 - px0) + (py1 - py0) * (py1 - py0));
    }

    public static boolean isPointOnLine(double px0, double py0, double px1,
                                 double py1, double px2, double py2) {
        boolean flag = false;
        double ESP = 1e-9;
        if ((Math.abs(Multiply(px0, py0, px1, py1, px2, py2)) < ESP)
                && ((px0 - px1) * (px0 - px2) <= 0)
                && ((py0 - py1) * (py0 - py2) <= 0)) {
            flag = true;
        }
        return flag;
    }
    public static boolean isIntersect(double px1, double py1, double px2, double py2,
                               double px3, double py3, double px4, double py4) {
        boolean flag = false;
        double d = (px2 - px1) * (py4 - py3) - (py2 - py1) * (px4 - px3);
        if (d != 0) {
            double r = ((py1 - py3) * (px4 - px3) - (px1 - px3) * (py4 - py3))
                    / d;
            double s = ((py1 - py3) * (px2 - px1) - (px1 - px3) * (py2 - py1))
                    / d;
            if ((r >= 0) && (r <= 1) && (s >= 0) && (s <= 1)) {
                flag = true;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String loc = in.next();
        String xy_arr = in.next();
        find(loc, xy_arr);
    }
}
/*
1,1
6,6,2,2,3,3,4,4,5,5
1,1
2,1.5,1.5,2
 */