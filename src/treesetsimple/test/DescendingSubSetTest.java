package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class DescendingSubSetTest extends Test
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
    private void probando_subseta_normal() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().subSet("Tommy","Denisse");
        this.comprobar_que(aux.size() == 4);
        this.comprobar_que(aux.first() != null);
        this.comprobar_que(aux.last() != null);
    }
    private void probando_subseta_nulo() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().subSet(null,null);
        this.comprobar_que(aux.isEmpty());
        this.comprobar_que(aux.first() == null);
        this.comprobar_que(aux.last() == null);
    }
    private void probando_subseta_derecha_nulo() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().subSet("Deborah",null);
        this.comprobar_que(aux.isEmpty());
        this.comprobar_que(aux.first() == null);
        this.comprobar_que(aux.last() == null);
    }
    private void probando_subseta_izquierda_nulo() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().subSet(null,"Franco");
        this.comprobar_que(aux.size() == 3);
        this.comprobar_que(aux.first() != null);
        this.comprobar_que(aux.last() != null);
    }
    private void probando_subseta_claves(String ini,String fin) throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.descendingSet().subSet(ini,fin);
        if(!aux.isEmpty()){
            this.comprobar_que(aux.first() != null);
            this.comprobar_que(aux.last() != null);
        } else {
            this.comprobar_que(aux.first() == null);
            this.comprobar_que(aux.last() == null);
        }
    }
    //</editor-fold>
    @Override
    public void test() {
        try {
            probando_subseta_normal();
            probando_subseta_nulo();
            probando_subseta_derecha_nulo();
            probando_subseta_izquierda_nulo();
            probando_subseta_claves("Felipe","Alicia");
            probando_subseta_claves("Enrique","Manuela");
            probando_subseta_claves("Manuela","Alberto");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}