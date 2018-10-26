package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class DifferenceTest extends Test
{
    //<editor-fold desc="relleno de datos">
        private void cargando(MyTreeSet<String> set){            
            set.add("Deborah");
            set.add("Tommy");
            set.add("Franco");
            set.add("Manuela");
            set.add("Miguel");
            set.add("Denisse");
        }
    //</editor-fold>
    //<editor-fold desc="pruebas">
        private void probando_diferencia_normal() throws Exception{
            MyTreeSet<String>s1 = new MyTreeSet();
            this.cargando(s1); 
            MyTreeSet<String>s2 = new MyTreeSet();
            s2.add("Deborah");
            s2.add("Tommy");
            s2.add("Denisse");
            s1.removeAll(s2);
            this.comprobar_que(s1.size() == 3);
        }
        private void probando_diferencia_S1_vacia() throws Exception{
            MyTreeSet<String>s1 = new MyTreeSet();
            MyTreeSet<String>s2 = new MyTreeSet();
            s2.add("Deborah");
            s2.add("Tommy");
            s2.add("Denisse");
            s1.removeAll(s2);
            this.comprobar_que(s1.isEmpty());
        }
        private void probando_diferencia_S2_vacia() throws Exception{
            MyTreeSet<String>s1 = new MyTreeSet();
            this.cargando(s1);
            MyTreeSet<String>s2 = new MyTreeSet();
            s1.removeAll(s2);
            this.comprobar_que(s1.size() == 6);
        }
        private void probando_diferencia_S1yS2_vacia() throws Exception{
            MyTreeSet<String>s1 = new MyTreeSet();
            MyTreeSet<String>s2 = new MyTreeSet();
            s1.removeAll(s2);
            this.comprobar_que(s1.isEmpty());
        }
        private void probando_diferencia_a_S1_mismo() throws Exception{
            MyTreeSet<String>s1 = new MyTreeSet();
            cargando(s1);
            s1.removeAll(s1);
            this.comprobar_que(s1.isEmpty());
        }
    //</editor-fold>
    @Override
    public void test() {
        try {
            this.probando_diferencia_normal();
            this.probando_diferencia_S1_vacia();
            this.probando_diferencia_S2_vacia();
            this.probando_diferencia_S1yS2_vacia();
            this.probando_diferencia_a_S1_mismo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
}