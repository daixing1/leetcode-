package SeqThread;

import java.util.concurrent.RecursiveTask;

/**
 * User: 兴希
 * Date: 2020/7/22
 * Time: 16:52
 * Description: No Description
 */
public class ForkJoinExample extends RecursiveTask<Integer> {

    private final int threshold = 5;
    private int first ;
    private int last;

    public ForkJoinExample(int first,int last){
        this.first=first;
        this.last=last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (last - first <= threshold) {
// 任务足够小则直接计算
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
// 拆分成小任务
            int middle = first + (last - first) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(first, middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle + 1, last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }

    public static void main(String[] args) {
        ForkJoinExample forkJoinExample = new ForkJoinExample(2,10);
        Integer compute = forkJoinExample.compute();
        System.out.println(compute);
    }
}
