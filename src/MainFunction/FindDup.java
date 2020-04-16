package MainFunction;

/**
 * User: 兴希
 * Date: 2020/3/6
 * Time: 23:50
 * Description: No Description
 */
public class FindDup {

    public static int find_dup( int numbers[], int length) {

        for ( int i= 0 ; i<length; i++) {

            int index = numbers[i];

            if (index >= length) {

                index -= length;

            }

            if (numbers[index] >= length) {

                return index;

            }

            numbers[index] = numbers[index] + length;

        }

        return - 1 ;

    }

    public static void main(String[] args) {
        find_dup(new int[]{1,2,1},3);
    }
}
