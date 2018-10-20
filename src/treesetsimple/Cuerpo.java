package treesetsimple;
public class Cuerpo {
    public static void main(String[] args) {
        MyTreeSet<String> set = new MyTreeSet();
        passToSet(set);
        java.util.TreeSet<String> set2 = new java.util.TreeSet();
        passToSet(set2);
        /*------------------------------------*/
        //test1(set);
        /*------------------------------------*/        
        test2Ascending(set, set2);
        
        /*------------------------------------*/
    }
    private static void passToSet(java.util.Set xset){
        xset.clear();
        xset.add("Deborah");
        xset.add("Tomás");
        xset.add("Franco");
        xset.add("Manuela");
    }
    private static void test1(java.util.Set xset){
        System.out.println("---* Primer Testing: funcionalidades básicas---\n");
        xset.add(null);
        System.out.println("containsKey - parámetro Deborah: " + xset.contains("Deborah"));
        System.out.println("containsKey  - parámetro Kaiba: " + xset.contains("Kaiba"));
        System.out.println("containsKey  - parámetro null: " + xset.contains(null));
        System.out.println("-----------------------------");
        System.out.println("tamaño -> " + xset.size());
        System.out.println("\t --datos-- ");
        xset.stream().forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----------------------------");
        MyTreeSet<String> set2 = new MyTreeSet<>(xset);
        set2.remove("Deborah");
        set2.remove("Franco");
        set2.remove("Kaiba");
        set2.remove(null);
        System.out.println("tamaño -> " + set2.size());
        System.out.println("\t --con bajas-- ");
        set2.stream().forEach((s) -> {
            System.out.println(s);
        });        
        System.out.println("-----------------------------");
        set2.clear();
        System.out.println("tamaño -> " + set2.size());
        System.out.println("\t --limpiado-- ");
        set2.stream().forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----------------------------");
        MyTreeSet<String> set3 = new MyTreeSet();
        set3.add("Julia");
        set3.add("Juan");
        set3.add("Manuela");
        set3.add("Tommy");
        set3.add("John");
        set3.add("Luna");
        System.out.println("tamaño -> " + set3.size());
        System.out.println("\t --datos-- ");
        set3.stream().forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----------------------------");
        java.util.ArrayList<String>l1 = new java.util.ArrayList();
        l1.add("Juan");
        l1.add("Tommy");
        l1.add("Luna");
        System.out.println("Primer comprobación total: " + set3.containsAll(l1));
        l1.remove("Juan");
        l1.add("Cat");
        System.out.println("Segunda comprobación total: " + set3.containsAll(l1));
        System.out.println("-----------------------------");
        System.out.println("retención total: " + set3.retainAll(l1));
        System.out.println("tamaño -> " + set3.size());
        System.out.println("\t --datos-- ");
        set3.stream().forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----------------------------");
        System.out.println("baja total: " + set3.removeAll(l1));
        System.out.println("tamaño -> " + set3.size());
        System.out.println("\t --datos-- ");
        set3.stream().forEach((s) -> {
            System.out.println(s);
        });
    }
    private static void test2Ascending(java.util.NavigableSet xset,java.util.NavigableSet xset2){        
        System.out.println("MyTreeSet: " + xset);
        System.out.println("TreeSet: " + xset2); 
        System.out.println("---* Segundo Testing: probando subsets ascending---\n");
        System.out.println("--- Probando subSet MyTreeSet---");
        System.out.println("subSet [Deborah:Franco]: " + xset.subSet("Deborah", "Franco"));
        System.out.println("subSet [Franco:Tomás]: " + xset.subSet("Franco", "Tomás"));
        System.out.println("subSet [Deborah:nulo]: " + xset.subSet("Deborah", null));
        System.out.println("subSet [nulo:Tomás]: " + xset.subSet(null, "Tomás"));
        System.out.println("subSet [nulo:nulo]: " + xset.subSet(null, null));
        System.out.println("--- Probando subSet TreeSet---");
        System.out.println("subSet [Deborah:Franco]: " + xset2.subSet("Deborah", "Franco"));
        System.out.println("subSet [Franco:Tomás]: " + xset2.subSet("Franco", "Tomás"));
        System.out.println("--- Probando headSet MyTreeSet---");
        System.out.println("headSet [Deborah]: " + xset.headSet("Deborah"));
        System.out.println("headSet [Franco]: " + xset.headSet("Franco"));
        System.out.println("headSet [Manuela]: " + xset.headSet("Manuela"));
        System.out.println("headSet [Tomás]: " + xset.headSet("Tomás"));
        System.out.println("--- Probando headSet TreeSet---");
        System.out.println("headSet [Deborah]: " + xset2.headSet("Deborah"));
        System.out.println("headSet [Franco]: " + xset2.headSet("Franco"));
        System.out.println("headSet [Manuela]: " + xset2.headSet("Manuela"));
        System.out.println("headSet [Tomás]: " + xset2.headSet("Tomás"));
    }
}