/**
 * 컬렉션 예제 (List, Set, Map)
 *
 * List - 순서 O 중복 O, Set - 중복 X, Map - 키·값 쌍
 * 실행: javac CollectionExample.java && java CollectionExample
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionExample {

    /** 진입점: List, Set, Map 예시를 순서대로 실행 */
    public static void main(String[] args) {
        System.out.println("=== 1. List (ArrayList) ===");
        listExample();

        System.out.println("\n=== 2. Set (HashSet) - 중복 제거 ===");
        setExample();

        System.out.println("\n=== 3. Map (HashMap) - 키·값 쌍 ===");
        mapExample();

        System.out.println("\n=== 4. List 반복문 ===");
        listLoopExample();

        System.out.println("\n=== 5. Map 순회 (keySet, entrySet) ===");
        mapLoopExample();
    }

    /** 예시 1: List - 순서 보장, 중복 허용. add, get, size, remove */
    static void listExample() {
        List<String> names = new ArrayList<>();
        names.add("김철수");
        names.add("이영희");
        names.add("김철수");  // 중복 허용

        System.out.println("names = " + names);
        System.out.println("get(1) = " + names.get(1));  // 인덱스 1번 값
        System.out.println("size() = " + names.size());

        names.remove(0);  // 인덱스 0 제거
        System.out.println("remove(0) 후 = " + names);
    }

    /** 예시 2: Set - 중복 불가. 같은 값 두 번 add 해도 하나만 저장됨 */
    static void setExample() {
        Set<String> ids = new HashSet<>();
        ids.add("a");
        ids.add("b");
        ids.add("a");  // 중복 → 무시

        System.out.println("ids = " + ids);
        System.out.println("size() = " + ids.size());
        System.out.println("contains(\"b\") = " + ids.contains("b"));
    }

    /** 예시 3: Map - 키·값 쌍. 같은 키로 put 하면 값이 덮어씌워짐 */
    static void mapExample() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("김철수", 90);
        scores.put("이영희", 85);
        scores.put("김철수", 95);  // 같은 키 → 90이 95로 덮어씀

        System.out.println("scores = " + scores);
        System.out.println("get(\"김철수\") = " + scores.get("김철수"));
        System.out.println("getOrDefault(\"박민수\", 0) = " + scores.getOrDefault("박민수", 0));  // 키 없으면 0
    }

    /** 예시 4: List for-each (향상된 for) - 각 요소를 변수에 넣으며 순회 */
    static void listLoopExample() {
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);

        System.out.print("for-each: ");
        for (Integer n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    /** 예시 5: Map 순회 - keySet()으로 키만, entrySet()으로 키·값 쌍 순회 */
    static void mapLoopExample() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("김철수", 95);
        scores.put("이영희", 85);

        System.out.println("keySet():");
        for (String name : scores.keySet()) {
            System.out.println("  " + name + " : " + scores.get(name));
        }
        System.out.println("entrySet():");
        for (Map.Entry<String, Integer> e : scores.entrySet()) {
            System.out.println("  " + e.getKey() + " : " + e.getValue());
        }
    }
}
