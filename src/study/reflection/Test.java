package study.reflection;

public class Test {
    public static void main(String[] args) throws Exception {

        //Class 찾기
        Class<Child> childClass = Child.class;
        System.out.println("Class name :" + childClass.getName());

        //클래스 이름만으로 클래스 정보를 가져오기
        Class<?> childClassName = Class.forName("study.reflection.Child");
        System.out.println("Class name :" + childClassName.getName());

        //생성자 찾기


    }
}
