
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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
        Map<String, ArrayList<Integer>> result = new HashMap<>(map);
        result = result
            .entrySet()
            .stream()
            .sorted((k1, k2) -> k1.getValue().size() - k2.getValue().size())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (prev, next) -> next, HashMap::new));
            
        for (var item : result.entrySet()) {
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
        addNumberToBook("Pushkin", 8978979, book);
        addNumberToBook("Pushkin", 545454, book);

        book.entrySet().stream().sorted((k1, k2) -> Integer.compare(k1.getValue().size(), k1.getValue().size()));
        // System.out.println(book.entrySet().stream().sorted((k1, k2) -> Integer.compare(k1.getValue().size(), k1.getValue().size())));
        printPhonesBook(book);
       }
}
