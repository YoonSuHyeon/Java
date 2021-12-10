package study.serialize;

import java.io.Serializable;

public class SerializeTest {

    private static class Test implements Serializable {
        private String name;
        private int age;

        public Test(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "name: " + name +"\n"+ "age: " + age;
        }
    }

    public static void main(String[] args) {
        Test test = new Test("TEST", 1);
        try {
            String serialize = SerializeSupport.serialize(test);
            System.out.println(serialize);

            Object deserialize = SerializeSupport.deserialize(serialize);
            System.out.println(deserialize);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
