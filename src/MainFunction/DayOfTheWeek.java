package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/22
 * Time: 8:44
 * Description: 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *              输入为三个整数：day、month 和 year，分别表示日、月、年。
 *              您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday",
 *              "Thursday", "Friday", "Saturday"}。
 */
public class DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int y = year%100;
        int c = year/100;
        int n = y+(y/4)+(c/4)-2*c+(26*(month+1)/10)+day-1;
        int index = n%7;
        return week[index];
    }
}
