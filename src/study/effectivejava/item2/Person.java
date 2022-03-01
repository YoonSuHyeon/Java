package study.effectivejava.item2;

public class Person {
    private String name;
    private int age;
    private double height;

    // ... 추가로 더 많은 변수강 있다고 가정
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age, double height) {
        this.age = age;
        this.height = height;
    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    //Java Bean 패턴

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //빌더패턴
    public static class Builder {
        private final String name;
        private final int age;
        private double height;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
    }
}
