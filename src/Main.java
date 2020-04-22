import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a","b");
        test(map);
        System.out.println(map.toString());
    }

    public static void test(Map<String,String> map){
        //map = new HashMap();
        map.put("aaa","bbb");
    }
}
