package study.effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    //해당 부분에서 메모리 누수 발생
    //pop() 함수 반환 전에 명시적으로 elements[size] =null 처리를 해줘야한다.
    //그래야 가비지  컬렉터가 만기 참조를 인지하여 자원 해제를 할 수 있다.
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
