import java.util.Iterator;

/**
 * @author CuiJunJie
 * @create 2020/11/24-17:09
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer cur;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        cur = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cur != null) {
            return cur;
        }
        cur = iterator.next();
        return cur;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cur != null) {
            Integer ret = cur;
            cur = null;
            return ret;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return cur != null || iterator.hasNext();
    }
}