package set;

import LinkedList.LinkedList;

/**
 * 链表实现的集合
 *
 * @author 陶波利
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList();
    }

    @Override
    public void add(E e) {
        if (!linkedList.contains(e)) {
            // 在链表头插入元素时间复杂度更小
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
