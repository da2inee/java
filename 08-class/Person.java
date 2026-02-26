/**
 * 8단계: 클래스와 객체
 *
 * 클래스 = 설계도, 객체 = new로 만든 것. 생성자로 초기화, this로 자기 자신 참조
 */
public class Person {
    String name;  // 필드 (인스턴스 변수)
    int age;

    /** 생성자: 클래스 이름과 같고, 리턴 타입 없음. 객체 생성 시 name, age 초기화 */
    Person(String name, int age) {
        this.name = name;  // this: 이 객체 자신 (매개변수와 필드 구분)
        this.age = age;
    }

    /** 인스턴스 메서드: 이 객체의 name, age로 자기소개 출력 */
    void introduce() {
        System.out.println("저는 " + name + ", " + age + "살입니다.");
    }

    public static void main(String[] args) {
        Person p = new Person("김자바", 25);  // 생성자 호출로 객체 생성
        p.introduce();  // 인스턴스 메서드 호출
    }
}
