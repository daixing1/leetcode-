package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/2/20
 * Time: 10:42
 * Description: 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有子文件夹，
 *              并以 任意顺序 返回剩下的文件夹。
 */
public class RemoveSubfolders {
    public static List<String> removeSubfolders(String[] folder) {
        List<String> fileDirs = new ArrayList<>();
        if (folder.length==0){
            return fileDirs;
        }
        List<String> folders = Arrays.stream(folder).sorted().collect(Collectors.toList());
        for (int i=0;i<folders.size();i++){
            String fileDir =  folders.get(i);
            if (isSubfolder(fileDirs,fileDir)){
                fileDirs.add(fileDir);
            }
        }
        return fileDirs;
    }

    public static boolean isSubfolder(List<String> fileDirs, String folder){
        boolean flag = true;
        for (int i=0;i<fileDirs.size();i++){
            if (folder.contains(fileDirs.get(i)) && fileDirs.get(i).split("/").length<folder.split("/").length){
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        List<String> stringList = removeSubfolders(new String[]{"/ah/al/am","/ah/al"});
        System.out.println(stringList);
    }
}
