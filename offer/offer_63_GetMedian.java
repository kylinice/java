package offer;
import java.util.PriorityQueue;
import java.util.Comparator;
public class offer_63_GetMedian {
    public int count=0;
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //默认为小根堆，重写compare方法改成大根堆
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public void Insert(Integer num) {
        count++;
        //如果是偶数
        if((count&1)==0){
            //左边是最大堆，右边是最小堆，最小堆的每个元素都要大于最大堆的堆顶
            //如果num比最大堆的堆顶还小，表示需要将最大堆的堆顶元素移动到最小堆中
            if(!maxHeap.isEmpty() && num<maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }else{
            //如果是奇数
            //如果num比最小堆的堆顶还大，表示需要将最小堆的堆顶元素移动到最大堆中
            if(!minHeap.isEmpty() && num>minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if(count==0)
            throw new RuntimeException("no available number!");
        double result;
        //总数为奇数时，最大堆的堆顶就是中位数
        if((count&1)==1)
            result=maxHeap.peek();
        else
            result=(minHeap.peek()+maxHeap.peek())/2.0;
        return result;
    }

    public static void main(String[] args) {
        offer_63_GetMedian test = new offer_63_GetMedian();
        int[] a = {2,3,5,7,6,10,12};
        for(int i=0;i<a.length;i++){
            test.Insert(a[i]);
        }
        System.out.println(test.GetMedian());
    }
}
