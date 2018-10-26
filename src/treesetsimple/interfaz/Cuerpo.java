package treesetsimple.interfaz;
import treesetsimple.test.*;
public class Cuerpo {
    public static void main(String[] args) {
        Test t1 = null;
        t1 = new ConstructorTest();
        t1.test();        
        t1 = new UpTest();
        t1.test();
        t1 = new ContainsTest();
        t1.test();
        t1 = new DownTest();
        t1.test();
        t1 = new ToArrayTest();
        t1.test();
        t1 = new UnionTest();
        t1.test();
        t1 = new DifferenceTest();
        t1.test();
        t1 = new IntersectionTest();
        t1.test();
        t1 = new SubSetTest();
        t1.test();
        t1 = new EntryTest();
        t1.test();
        t1 = new AscendingHeadSetTest();
        t1.test();
        t1 = new AscendingTailSetTest();
        t1.test();
        t1 = new AscendingSubSetTest();
        t1.test();
        t1 = new DescendingHeadSetTest();
        t1.test();
        t1 = new DescendingTailSetTest();
        t1.test();
        t1 = new DescendingSubSetTest();
        t1.test();
    }
}