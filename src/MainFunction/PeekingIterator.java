package MainFunction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/15
 * Time: 10:03
 * Description: 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 
 *              peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 */
public class PeekingIterator {
    Iterator<Integer> iterator;
    List<Integer> list;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        list = new ArrayList<>();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (hasNext()){
            if (list.isEmpty()){
                Integer next = iterator.next();
                list.add(next);
                return next;
            }else {
                return list.get(list.size()-1);
            }
        }else {
            return null;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        if (list.isEmpty()){
            return iterator.next();
        }else {
            Integer integer = list.get(list.size() - 1);
            list.remove(list.size()-1);
            return integer;
        }

    }

    public boolean hasNext() {
        if (list.isEmpty()){
            return iterator.hasNext();
        }else {
            return true;
        }
    }
}
