package MainFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 20:11
 * Description: 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用
 *              connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *              网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *              给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，
 *              并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。
 *              如果不可能，则返回 -1 。
 */
public class MakeConnected {
    int[][] edge;
    boolean[] flag;
    public int makeConnected(int n, int[][] connections) {
        Arrays.sort(connections,(o1, o2) -> {
            if (o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else {
                return o1[0]-o2[0];
            }
        });
        if (connections.length<n-1){
            return -1;
        }
        edge = connections;
        flag = new boolean[n];
        int count = 0;
        for (int i=0;i<n;i++){
            if (!flag[i]){
                count++;
                dfs(i);
            }
        }
        return count-1;
    }

    private void dfs(int i){
        for (int[] arr:edge){
            if (arr[0]==i&&!flag[arr[1]]||(arr[1]==i&&!flag[arr[0]])){
                flag[arr[0]]=true;
                flag[arr[1]]=true;
                if (arr[0]==i){
                    dfs(arr[1]);
                }else {
                    dfs(arr[0]);
                }
            }

        }
    }

    public static void main(String[] args) {
        MakeConnected makeConnected = new MakeConnected();
        int i = makeConnected.makeConnected(8, new int[][]{
                {0,6},{2,3},{2,6},{2,7},{1,7},{2,4},{3,5},{0,2}});
        System.out.println(i);
    }
}
