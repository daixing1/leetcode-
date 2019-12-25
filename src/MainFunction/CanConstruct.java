package MainFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * User: 兴希
 * Date: 2019/12/25
 * Time: 11:48
 * Description: 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom
 *              能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *              (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        for (char c:ransomNote.toCharArray()){
            int i = magazine.indexOf(String.valueOf(c));
            if (i>=0){
                magazine = magazine.substring(0,i)+magazine.substring(i+1,magazine.length());
            }else {
                return false;
            }
        }
        return true;
//        char[] ransChar = ransomNote.toCharArray();
//        char[] mageChar = magazine.toCharArray();
//        Map<Character, Integer> rMap = new HashMap<>();
//        Map<Character,Integer> mMap = new HashMap<>();
//        for (int i=0;i<ransChar.length;i++){
//            if (rMap.containsKey(ransChar[i])){
//                rMap.put(ransChar[i],rMap.get(ransChar[i])+1);
//            }else {
//                rMap.put(ransChar[i],1);
//            }
//        }
//        for (int j=0;j<mageChar.length;j++){
//            if (mMap.containsKey(mageChar[j])){
//                mMap.put(mageChar[j],mMap.get(mageChar[j])+1);
//            }else {
//                mMap.put(mageChar[j],1);
//            }
//        }
//        AtomicBoolean flag = new AtomicBoolean(true);
//        rMap.forEach((k,v) ->{
//            if (!mMap.containsKey(k) || mMap.get(k)<v){
//                flag.set(false);
//            }
//        });
//        return flag.get();
//
    }
}
