package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/7/11
 * Time: 22:27
 * Description: 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
 *                  counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 */
public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length==0){
            return new ArrayList<>();
        }
        if (nums.length==1){
            return new ArrayList<>(Arrays.asList(0));
        }
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        maxQueue.offer(nums[nums.length-1]);
        for (int i=nums.length-2;i>=0;i--){
            if (nums[i]<nums[i+1]&&list.get(list.size()-1)==0){
                list.add(0);
                maxQueue.offer(nums[i]);
            }else {
                Integer poll = maxQueue.poll();
                if (nums[i]>poll){
                    maxQueue.offer(poll);
                    poll = minQueue.poll();
                    if (poll!=null){
                        while (!minQueue.isEmpty()&&nums[i]>poll){
                            maxQueue.offer(poll);
                            poll = minQueue.poll();
                        }
                        if (minQueue.isEmpty()){
                            if (nums[i]>poll){
                                maxQueue.offer(poll);
                            }else {
                                minQueue.offer(poll);
                            }
                        }else {
                            minQueue.offer(poll);
                        }
                    }
                    list.add(maxQueue.size());
                    maxQueue.offer(nums[i]);
                }else {
                    while (!maxQueue.isEmpty()&&nums[i]<=poll){
                        minQueue.offer(poll);
                        poll = maxQueue.poll();
                    }
                    if (maxQueue.isEmpty()){
                        if (nums[i]<=poll){
                            minQueue.offer(poll);
                            list.add(maxQueue.size());
                            maxQueue.offer(nums[i]);
                        }else {
                            maxQueue.offer(poll);
                            list.add(maxQueue.size());
                            maxQueue.offer(nums[i]);
                        }
                    }else {
                        maxQueue.offer(poll);
                        list.add(maxQueue.size());
                        maxQueue.offer(nums[i]);
                    }
                }
            }
        }
        int tmp = 0;
        for (int i=0;i<list.size()/2;i++){
            tmp = list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,tmp);
        }
        return list;
    }

    public List<Integer> countSmaller1(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        List<Integer> tmplist = new ArrayList<>();
        maxQueue.offer(nums[nums.length-1]);
        for (int i=nums.length-2;i>=0;i--) {
            if (nums[i]<nums[i+1]&&list.get(list.size()-1)==0) {
                list.add(0);
            }else {
                tmplist.clear();
                Integer poll = maxQueue.poll();
                while (!maxQueue.isEmpty()&&nums[i]<=poll){
                    tmplist.add(poll);
                    poll = maxQueue.poll();
                }
                if (maxQueue.isEmpty()){
                    if (nums[i]<=poll){
                        list.add(maxQueue.size());
                        maxQueue.offer(poll);
                    }else {
                        maxQueue.offer(poll);
                        list.add(maxQueue.size());
                    }
                }else {
                    maxQueue.offer(poll);
                    list.add(maxQueue.size());
                }
                for (int n:tmplist){
                    maxQueue.add(n);
                }
            }
            map.put(nums[i],list.get(list.size()-1));
            maxQueue.offer(nums[i]);
        }
        int tmp = 0;
        for (int i=0;i<list.size()/2;i++){
            tmp = list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,tmp);
        }
        return list;
    }

    public List<Integer> countSmaller2(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }
        List<Integer> list = new LinkedList<>();
        List<Integer> sortlist = new ArrayList<>();
        list.add(0);
        sortlist.add(nums[nums.length-1]);
        int left,right;
        for (int i=nums.length-2;i>=0;i--){
            left = 0;
            right = sortlist.size()-1;
            while (left<right){
                int mid = (left+right)/2;
                if (sortlist.get(mid)>=nums[i]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
            sortlist.add(left,nums[i]);
            ((LinkedList<Integer>) list).addFirst(left);
        }
        return list;
    }

    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        List<Integer> list = countSmaller.countSmaller1(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41});
        System.out.println(list);
    }
}
