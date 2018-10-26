package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class AscendingSubSetTest extends Test
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
        MyTreeSet<String> aux = (MyTreeSet<String>)set.subSet("Denisse","Tommy");
        this.comprobar_que(aux.size() == 4);
        this.comprobar_que(aux.first() != null);
        this.comprobar_que(aux.last() != null);
    }
    private void probando_subseta_nulo() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.subSet(null,null);
        this.comprobar_que(aux.isEmpty());
        this.comprobar_que(aux.first() == null);
        this.comprobar_que(aux.last() == null);
    }
    private void probando_subseta_derecha_nulo() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.subSet("Deborah",null);
        this.comprobar_que(aux.size() == 5);
        this.comprobar_que(aux.first() != null);
        this.comprobar_que(aux.last() != null);
    }
    private void probando_subseta_izquierda_nulo() throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.subSet(null,"Franco");
        this.comprobar_que(aux.size() == 2);
        this.comprobar_que(aux.first() != null);
        this.comprobar_que(aux.last() != null);
    }
    private void probando_subseta_claves(String ini,String fin) throws Exception {
        MyTreeSet<String> set = cargando();
        MyTreeSet<String> aux = (MyTreeSet<String>) set.subSet(ini,fin);
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
            probando_subseta_claves("Alexis","Zeta");
            probando_subseta_claves("Deborah","Denisse");
            probando_subseta_claves("Denisse","Pedro");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}