package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/14
 * Time: 10:53
 * Description: 实现支持下列接口的「快照数组」- SnapshotArray：
 *              SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，
 *              每个元素都等于 0。
 *              void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 *              int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 
 *              的总次数减去 1）。
 *              int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引
 *              index 的值。
 */
public class SnapshotArray {
    private int[] array;
    private Map<Integer,int[]> map = new HashMap<>();
    public SnapshotArray(int length) {
        array = new int[length];
    }

    public void set(int index, int val) {
        if (index>=array.length){
            return;
        }
        array[index] = val;
    }

    public int snap() {
        int snapId = map.size();
        int[] newArray = new int[array.length];
        for (int i=0;i<array.length;i++){
            newArray[i] = array[i];
        }
        map.put(snapId,newArray);
        return snapId;
    }

    public int get(int index, int snap_id) {
        if (map.containsKey(snap_id)){
            return map.get(snap_id)[index];
        }else {
            return -1;
        }
    }
}
