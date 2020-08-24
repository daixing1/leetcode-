package MainFunction;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/8/11
 * Time: 22:56
 * Description: 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *               处理:
 *                  1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，
 *                  错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 *                  2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，
 *                  而只是文件名的后16个字符和行号相同，也不要合并)
 *                  3.输入的文件可能带路径，记录文件名称不能带路径
 *              输入描述:
 *                  一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *                  文件路径为windows格式
 *                  如：E:\V1R2\product\fpgadrive.c 1325
 *              输出描述:
 *                  将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 *                  结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
 *                  如果超过8条记录，则只输出前8条记录.
 *                  如果文件名的长度超过16个字符，则只输出后16个字符
 */
public class RecordError {

    public static void main(String[] args) {
        Map<String, Record> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            int i = s.lastIndexOf('\\');
            int line = scanner.nextInt();
            String name = i<0?s:s.substring(i+1);
            String shortname = name.length()>16?name.substring(name.length()-16):name;
            Record record = new Record(shortname,line,1);
            if (!map.containsKey(name)){
                if (map.size()<8){
                    map.put(name+"#"+line,record);
                }
            }else {
                map.get(name+"#"+line).count++;
            }
        }
        List<Record> list = map.values().stream().sorted((o1, o2) -> o2.count-o1.count).collect(Collectors.toList());
        list.forEach(r->{
            System.out.println(r.name+" "+r.row+" "+r.count);
        });
    }
}

class Record{
    String name;
    int row;
    int count;
    public Record(String name, int row, int count){
        this.name = name;
        this.row = row;
        this.count = count;
    }
}
