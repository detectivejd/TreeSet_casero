package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class ConstructorTest extends Test
{
    private void creando_map_vacio() throws Exception{
        MyTreeSet<String>s= new MyTreeSet();
        this.comprobar_que(s.isEmpty());
    }
    private void creando_map_normal() throws Exception {
        MyTreeSet<String>s1= new MyTreeSet();
        s1.add("Deborah");
        s1.add("Tommy");
        s1.add("Franco");
        s1.add("Manuela");
        this.comprobar_que(s1.size() == 4);
    }
    private void pasar_datos_de_hashset_a_nuestro_set() throws Exception{
        java.util.HashSet<String> s = new java.util.HashSet();
        s.add("Agustin");
        s.add("Amanda");
        s.add("Olivia");
        s.add("Maite");
        /*---------------------------------------*/
        MyTreeSet<String> s3 = new MyTreeSet();
        s3.addAll(s);
        /*---------------------------------------*/
        this.comprobar_que(s3.size() == 4);
    }    
    @Override
    public void test() {
        try {
            creando_map_vacio();
            creando_map_normal();
            pasar_datos_de_hashset_a_nuestro_set();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}