/**
 * 컴파일 과정 연습용
 *
 * 1. javac HelloWorld.java  → HelloWorld.class (바이트코드) 생성
 * 2. java HelloWorld       → JVM이 .class를 실행
 */
public class HelloWorld {
    /** JVM이 가장 먼저 실행하는 진입점 */
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
