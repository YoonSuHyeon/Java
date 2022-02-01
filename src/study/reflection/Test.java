package study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {

        //Class 찾기
        Class<Child> childClass = Child.class;
        System.out.println("Class name :" + childClass.getName());

        //클래스 이름만으로 클래스 정보를 가져오기
        Class<?> childClassName = Class.forName("study.reflection.Child");
        System.out.println("Class name :" + childClassName.getName());

        //인자없는 생성자 찾기
        Constructor<?> noParamConstructor = childClassName.getDeclaredConstructor();
        System.out.println("Constructor :" + noParamConstructor.getName());

        //인자있는 생성자 찾기
        Constructor<?> ParamConstructor = childClassName.getDeclaredConstructor(String.class);
        System.out.println("Constructor :" + ParamConstructor.getName());

        //모든 생성자 찾기 (private,public ... 모두)
        Constructor<?>[] allConstructors = childClassName.getDeclaredConstructors();
        for (Constructor<?> cons : allConstructors) {
            System.out.println("Child Constructor : " + cons);
        }

        Constructor<?>[] publicConstructors = childClassName.getConstructors();
        for (Constructor<?> cons : publicConstructors) {
            System.out.println("Child Constructor : " + cons);
        }

        //존재하지 않는 생성자 찾기 : NoSuchMethodException 발생
//        Constructor<?> noFindConstructor = childClassName.getDeclaredConstructor(String.class,Integer.class);
//        System.out.println("Constructor :" + noFindConstructor.getName());

        //Method 찾기 (메소드 이름으로 찾기)
        Method methodByNameAndNoParam = childClassName.getDeclaredMethod("method3", null);
        Method methodByName = childClassName.getDeclaredMethod("method4", int.class);
        System.out.println("methodByNameAndNoParam : " + methodByNameAndNoParam);
        System.out.println("mthodByName : " + methodByName);

        //인자가 두개 이상인 경우
        Class<?>[] params = new Class[2];
        params[0] = int.class;
        params[1] = String.class;
        Method multiParamMethod = childClassName.getDeclaredMethod("method6", params);
        System.out.println("multiParam : " + multiParamMethod);

        //Super 클래스의 정보는 가져오지 않는다.
        Method[] declaredMethods = childClassName.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }

        //public method , 상속받은 메소드
        Method[] methods = childClassName.getMethods();
        for (Method m : methods) {
            System.out.println("public and Super :" + m);
        }

        //Field 변경
        Field cs = childClassName.getDeclaredField("cs");
        System.out.println("field :" + cs);

        Field[] declaredFields = childClassName.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println("declaredField : " + f);
        }

        Field[] fields = childClassName.getFields();
        for (Field f : fields) {
            System.out.println("getFields : " + f);
        }

        //Method 호출(public)
        Child child = new Child();
        Method method4 = childClassName.getDeclaredMethod("method4", int.class);
        int value = (int) method4.invoke(child, 10);
        System.out.println("return value :" + value);

        //Method 호출(private)
        Class<?> parent = Class.forName("study.reflection.Parent");
        Method method3 = parent.getDeclaredMethod("method3");
        method3.setAccessible(true);
        method3.invoke(child);

        //Field 변경
        Field cs2 = childClassName.getDeclaredField("cs2");
        System.out.println("cs2 :" + cs2);

        cs2.setAccessible(true);
        cs2.set(child, "TEMP");
        System.out.println(cs2.get(child));

        //Static 메소드 호출 또는 필드 변경
        Class<?> staticClass = Class.forName("study.reflection.StaticExample");
        Method getStatic = staticClass.getDeclaredMethod("getStatic", int.class);
        System.out.println(getStatic.invoke(null, 10));

        Field declaredField = staticClass.getDeclaredField("EXAMPLE");
        declaredField.set(null, "Hi");
        System.out.println(declaredField.get(null));
    }
}
