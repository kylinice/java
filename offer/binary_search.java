package offer;

public class binary_search {
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType[] a, AnyType x){
        int low = 0, high = a.length -1;
        while (low<=high){
            int mid = (low+high)/2;
            if(a[mid].compareTo(x) < 0){
                low = mid+1;
            }else if(a[mid].compareTo(x)>0){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();
        Integer a[] = {1,2,3,4,5,6,7,8};
        int num = binarySearch(a, 6);
        System.out.println(num);
        long end_time = System.currentTimeMillis();
        System.out.println("耗时：" + (end_time - start_time) + "ms");
    }
}
