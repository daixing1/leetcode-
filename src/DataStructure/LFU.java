package DataStructure;

import java.util.Date;

/**
 * User: 兴希
 * Date: 2020/4/5
 * Time: 9:52
 * Description: LFC的节点数据结构
 */
public class LFU {
    private int cnt;
    private Date time;
    private int key;
    private int value;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LFU{" +
                "cnt=" + cnt +
                ", time=" + time +
                ", key=" + key +
                ", value=" + value +
                '}';
    }
}
