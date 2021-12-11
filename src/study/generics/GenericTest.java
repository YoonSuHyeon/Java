package study.generics;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {

        //GenericStack Test
        GenericStack<String> genericStack = new GenericStack<>();
        genericStack.push("TEST1");
        genericStack.push("TEST2");
        // 타입 String 이 아니므로 컴파일 에러
        //genericStack.push(1);
        String popString = genericStack.pop();

        //GenericUtil Test
        List<String> list = new ArrayList<>();
        list.add("TEST1");
        list.add("TEST2");
        GenericStack<String> asList = GenericStackUtil.as(list);



    }
}
