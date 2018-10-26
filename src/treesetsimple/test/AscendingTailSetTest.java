package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class AscendingTailSetTest extends Test
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
        MyTreeSet<String> aux = (MyTreeSet<String>) set.tailSet("Denisse");
        this.comprobar_que(aux.size() == 5);
        this.comprobar_que(aux.first() != null);
        this.comprobar_que(aux.last() != null);
    }
    private void probando_cola_nula() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.tailSet(null);
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
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}