
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Phones {
    public static void addNumberToBook(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    public static void printPhonesBook(Map<String, ArrayList<Integer>> map){
        for (var item : map.entrySet()) {
            StringJoiner joiner = new StringJoiner(", " ,"[", "]");
            for(int el: item.getValue()){
                joiner.add(String.valueOf(el));
            }
            System.out.printf("%s: %s \n", item.getKey(), joiner.toString());
        }
    }
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> book = new HashMap<>();

        addNumberToBook("Ivanov", 123, book);
        addNumberToBook("Ivanov", 1234, book);
        addNumberToBook("Petrov", 546585, book);
        addNumberToBook("Sidorov", 8956477, book);
        addNumberToBook("Ivanov", 12356233, book);
        addNumberToBook("Petrov", 787897, book);
        printPhonesBook(book);
       }
}
