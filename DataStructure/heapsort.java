package DataStructure;

public class heapsort {
    private static void heapsort(int[] a){
        int len = a.length;
        //建立大顶堆
        buildHeap(a, len);
        //交换堆顶和末尾元素
        for(int i=len-1;i>0;i--){
            swap(a, 0, i);
            //建立大顶堆
            buildHeap(a, i);
        }
    }
    //建立大顶堆,从第一个非叶子节点开始，从右到左，从下到上
    private static void buildHeap(int[] a, int len){
        for(int i=len/2-1;i>=0;i--){
            heapAdjust(a, i, len);
        }
    }
    //调整堆
    private static void heapAdjust(int[] a, int index, int len){
        int i=2*index+1;
        if(i+1<len && a[i]<a[i+1]) {
            i++;
        }
        if(a[i]>a[index]){
            swap(a, i, index);
        }
    }
    private static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        int[] a = {49, 35, 12, 56, 67, 95, 19, 49};
        //从小到大排序
        heapsort(a);
        for(int i:a){
            System.out.print(i+",");
        }
    }
}
