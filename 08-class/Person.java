/**
 * 8단계: 클래스와 객체
 * 
 * 클래스 = 설계도, 객체 = 그 설계도로 만든 것
 */
public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("저는 " + name + ", " + age + "살입니다.");
    }

    public static void main(String[] args) {
        Person p = new Person("김자바", 25);
        p.introduce();
    }
}
