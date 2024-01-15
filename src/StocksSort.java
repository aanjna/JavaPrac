import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.stream.Stream;

public class StocksSort {
    public static void main(String[] args) {
        solve();
    }

    public static void solve(){
        String validate = "abc";
        List<String> list = Stream.of("","jpmc", "cisco", "clix", "tata", "amazon", "apple", "google", "ig", "birla").toList();

//        ArrayList<Characters> charArray = validate.stream((Char) p -> p.getCharOf()).collect(Collector.toList);
//        ArrayList<String> sortedValidatedData = list.stream().filter(p ->  charArray.stream().forEach(element -> p.startsWith(element))).sort().collect(Collector.toList);

        Map<Character, Set<String>> map = new HashMap<>();
        Set<String> set = new TreeSet<>();
        //On
        for (String stocks : list){
            if(!stocks.equals("") && !stocks.equals(" ")){
                set = map.getOrDefault(stocks.charAt(0),new HashSet<>());
                set.add(stocks);
                map.put(stocks.charAt(0),set);
            }

        }
//        System.out.println(set);

        char[] arr = validate.toCharArray();
        Set<Character> starting = new HashSet<>();
        //Om
        for (int i=0;i<arr.length;i++) starting.add(arr[i]);
        Set<String> ans = new TreeSet<>();
        for (Character ch : starting){
            if(map.containsKey(ch)){
                for (String stock : map.get(ch)){
                    ans.add(stock);
                }
            }
        }
        // O(n+m)
//        Collections.sort(ans);
        System.out.println(ans);
    }
}
