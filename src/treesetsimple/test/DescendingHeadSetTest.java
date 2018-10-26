package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class DescendingHeadSetTest extends Test
{
    MyTreeSet<String>set;
    public DescendingHeadSetTest() {
        set = new MyTreeSet();
        this.cargando();
    }
    //<editor-fold desc="relleno de datos">
    private void cargando(){
        set.add("Deborah");
        set.add("Tommy");
        set.add("Franco");
        set.add("Manuela");
        set.add("Miguel");
        set.add("Denisse");
    }
    //</editor-fold>
    //<editor-fold desc="pruebas">
    private void probando_cabeza_normal() throws Exception {
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().headSet("Franco");
        this.comprobar_que(aux.size() == 3);
        this.comprobar_que(aux.first() != null);
        this.comprobar_que(aux.last() != null);
    }
    private void probando_cabeza_nula() throws Exception {
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().headSet(null);
        this.comprobar_que(aux.isEmpty());
        this.comprobar_que(aux.first() == null);
        this.comprobar_que(aux.last() == null);
    }
    private void probando_cabeza_con_clave_inexistente() throws Exception {
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().headSet("Pedro");
        this.comprobar_que(aux.isEmpty());
        this.comprobar_que(aux.first() == null);
        this.comprobar_que(aux.last() == null);
    }
    //</editor-fold>
    @Override
    public void test() {
        try {
            probando_cabeza_normal();
            probando_cabeza_nula();
            probando_cabeza_con_clave_inexistente();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}