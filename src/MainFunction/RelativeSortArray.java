package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/5/4
 * Time: 12:26
 * Description: No Description
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2.length==0){
            Arrays.sort(arr1);
            return arr1;
        }
        List<Integer> collect = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        int pos = 0;
        List<Integer> retain = new ArrayList<>();
        int tmp = 0;
        for(int i=0;i<arr2.length;i++){
            for (int j=pos;j<arr1.length;j++){
                if (arr1[j]==arr2[i]){
                    tmp = arr1[j];
                    arr1[j] = arr2[pos];
                    arr1[pos] = tmp;
                    pos++;
                }
            }
        }
        for (int i=pos;i<arr1.length;i++){
            retain.add(arr1[i]);
        }
        if (retain.size()==0){
            return arr1;
        }
        List<Integer> collect1 = retain.stream().sorted().collect(Collectors.toList());
        for (int i=0;i<collect1.size();i++){
            arr1[pos+i] = collect1.get(i);
        }
        return arr1;
    }
}
