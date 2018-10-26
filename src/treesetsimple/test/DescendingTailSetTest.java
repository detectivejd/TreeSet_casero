package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class DescendingTailSetTest extends Test 
{
    //<editor-fold desc="relleno de datos">
    private MyTreeSet<String>cargando(){
        MyTreeSet<String> set = new MyTreeSet();
        set.add("Deborah");
        set.add("Tommy");
        set.add("Franco");
        set.add("Manuela");
        set.add("Miguel");
        set.add("Denisse");
        return set;
    }
    //</editor-fold>
    //<editor-fold desc="pruebas">
    private void probando_cola_normal() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().tailSet("Franco");
        this.comprobar_que(aux.size() == 3);
        this.comprobar_que(aux.first() != null);
        this.comprobar_que(aux.last() != null);
    }
    private void probando_cola_nula() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().tailSet(null);
        this.comprobar_que(aux.isEmpty());
        this.comprobar_que(aux.first() == null);
        this.comprobar_que(aux.last() == null);
    }
    private void probando_cola_con_clave_inexistente() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().tailSet("Daniel");
        this.comprobar_que(aux.isEmpty());
        this.comprobar_que(aux.first() == null);
        this.comprobar_que(aux.last() == null);
    }
    //</editor-fold>
    @Override
    public void test() {
        try {
            probando_cola_normal();
            probando_cola_nula();
            probando_cola_con_clave_inexistente();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}