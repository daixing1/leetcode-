package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/12
 * Time: 20:28
 * Description: 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek()
 *              操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 */
public class PeekingIteratorI implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peek;
    public PeekingIteratorI(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()){
            peek = iterator.next();
        }else {
            peek = null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peek==null){
            return -1;
        }
        Integer next = peek;
        if (iterator.hasNext()){
            peek = iterator.next();
        }else {
            peek = null;
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        if (peek==null){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        PeekingIteratorI peekingIteratorI = new PeekingIteratorI(list.iterator());
        Integer next = peekingIteratorI.next();
        Integer peek = peekingIteratorI.peek;
        Integer next1 = peekingIteratorI.next();
        Integer next2 = peekingIteratorI.next();
        boolean b = peekingIteratorI.hasNext();
        System.out.println();
    }
}
