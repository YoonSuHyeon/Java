package study.effectivejava.item1;

/**
 * Static Factory Method Example 1
 * One Advantage : Can have a name.
 */
public class Member {
    private String name;
    private int age;
    private MemberType type;

    public Member(String name, int age, MemberType type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public static Member admin(String name, int age) {
        return new Member(name, age, MemberType.ADMIN);
    }

    private enum MemberType {
        ADMIN, DEFAULT
    }

    public static void main(String[] args) {
        String name = "TestName";
        int age = 20;
        MemberType type = MemberType.ADMIN;

        //생성자를 통해서 객체 생성
        Member member = new Member(name, age, type);
        //Static Factory Method 사용
        Member admin = Member.admin(name, age);

    }
}
