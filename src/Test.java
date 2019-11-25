import java.io.IOException;
import java.util.*;
class A{};
class B extends A{};
class C extends B{};

public class Test {
    public static void main(String[] args) throws IOException {

        C c = new C();
        B b = new B();

        c = (C) b;

        Map< String,Integer> hm =
                new HashMap< String,Integer>();
        hm.put("a", 100);
        hm.put("b", 200);
        hm.put("c", 300);
        hm.put("d", 400);

        // Returns Set view
        Set< Map.Entry< String,Integer> > st = hm.entrySet();

        for (Map.Entry< String,Integer> me:st)
        {
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
        }


        Iterator itr = hm.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry current = (Map.Entry<String, Integer>) itr.next();

            if(current.getKey().equals("a")){
                itr.remove(); // this will remove the current entry.
            }
        }

        hm.entrySet().removeIf( e -> e.getValue() > 300 );
        System.out.println();
        Set<String> se = hm.keySet();
        for(String s : se){
            System.out.print(s +":");
            System.out.println(hm.get(s));
        }


        String[] asset = {"equity", "stocks", "gold", "foreign exchange","fixed income", "futures", "options"};
        List<String> assetList = Arrays.asList(asset);
    }
}
