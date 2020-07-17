package MainFunction;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: 兴希
 * Date: 2020/7/9
 * Time: 9:54
 * Description: 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
 *              像句子"I reset the computer. It still didn’t boot!"
 *              已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。
 *              当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，
 *              设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *              注意：本题相对原题稍作改动，只需返回未识别的字符数
 */
public class Respace {
    public int respace(String[] dictionary, String sentence) {
        Arrays.sort(dictionary, (o1, o2) -> o2.length()-o1.length());
        for (String s:dictionary){
            if (sentence.contains(s)){
                System.out.println(s);
            }
            sentence = sentence.replace(s, " ");
            System.out.println(sentence);
        }
        return sentence.replace(" ","").length();
    }

    public static void main(String[] args) {
        Respace respace = new Respace();
        int count = respace.respace(new String[]{
                "bt","vbtbvtvvbbvtbvvbbbvbtbbv",
                        "bvvbbbvvvbvttbtbvtvtvvbttbbbtvvvb",
                        "btttbvbbbtbbtbvvttbvbvtvbtbbttb",
                        "bt","vvbvbvbvtbvbvvvvtv",
                        "tbvvvtttvtbvbtttvvbtvvvvtvvbvvtvvbbvbbbvb",
                        "v","bvb","vvtbvtvbttbttvvbvttbt",
                        "btbtbtttvbbtbttbtvvttbvtbtvtbvvtbbbb",
                        "bttbvbbttvvbtvvvvb",
                        "bvvbvbvttbvtbvvtbttvvvvtvbtvbttbbvvtvtvv",
                        "vbtttt","btbvbbbvbtvtbvvv","b",
                        "tbtbtv","vbvbbvvbvbbvvb",
                        "vbvvtvbvbvbttvbvbtvbtbtvtbvbbtb",
                        "bvvbvvttttttbtvvvttvbvtvvbvtbtvtbvttvvtbt",
                        "bvtbttv","bbbt","vtt","ttvv","b","vbb",
                        "vtvvbtttvtbbvvbbtbb","vvv","vvvvbbbtbbbvbbbb",
                        "ttvvbtvv","v","btvbbvtbbvbvtvttvvbbbtbvvvtbtb",
                        "vv","btbttbtbbvbvvbvttbttvtbbtbvtttvbbtbbtvtvvvvbbttvtvvbbbv",
                        "ttvbbbbttbtbtb","tvvbvbvvb","vv","ttbttvtvbtbbbbv",
                        "bvvvtbbvvvbtvbvtvtvvvvbb","vtbvvbvvvvvttvbbttbbvtvt",
                        "tbvbbt","b","v","tvbbtvvtvvtbtbttvvvb",
                        "tbttbttbbbtbtvtvtvtbbbvvtbbbvbbvvvbbttvvt",
                        "bbvttvtvvtbvbbttvbbtbvvttbvbvbtbvvvbbbvbvbvbtvbtvvvtvvtbttbttbbvbbbttvvvbvvtb",
                        "vttvvbvv","tbttbvvttvbtvvtbbvvv","bvbbbbbbbb","vtbvvtbbvtt",
                        "bvttbvvbvb","tvttttbbvvvbbtttvvv"},
        "btbvtttttbvttbvvbbtvvbvbvvbtbtbtvbtttbvbbbtbbtbvvttbvbvtvbtbbttbvvbvbtttbvttbvvbbvvv");
        System.out.println(count);
    }
}
