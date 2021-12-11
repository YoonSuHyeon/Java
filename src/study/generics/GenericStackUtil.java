package study.generics;

import java.util.List;


/**
 * 메소드에 제네릭 적용
 * ex) public static <T> T  getXX(T t)
 * <T>  -> Generic Type , T -> return Type
 */
public class GenericStackUtil {
    public static <T> GenericStack<T> as(List<T> list) {
        GenericStack<T> genericStack = new GenericStack<>();
        list.forEach(genericStack::push);

        return genericStack;
    }
}
