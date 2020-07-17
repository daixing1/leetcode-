package DataStructure;

import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/29
 * Time: 9:24
 * Description: No Description
 */
public class MountainArray {
    private List<Integer> mountain;
    public MountainArray(List<Integer> mountain){
        this.mountain = mountain;
    }

    public int get(int index) {
        return mountain.get(index);
    }
    public int length() {
        return mountain.size();
    }
}
