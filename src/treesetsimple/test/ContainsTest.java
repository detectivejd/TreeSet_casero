package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class ContainsTest extends Test
{
    MyTreeSet<String> set;
    public ContainsTest() {
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
        private void probando_verificacion_normal() throws Exception{
            this.comprobar_que(set.contains("Deborah"));
            this.comprobar_que(set.contains("Franco"));
            this.comprobar_que(set.contains("Miguel"));            
        }
        private void probando_verificacion_con_nulas_que_no_debería_obtener_nada() throws Exception{
            this.comprobar_que(!set.contains(null));            
        }
        private void probando_verificacion_con_inexistentes_que_debería_dar_falso() throws Exception{
            this.comprobar_que(!set.contains("Pepe"));
            this.comprobar_que(!set.contains("Luis"));            
        }
    //</editor-fold>
    @Override
    public void test() {
        try {
            this.probando_verificacion_normal();
            this.probando_verificacion_con_nulas_que_no_debería_obtener_nada();
            this.probando_verificacion_con_inexistentes_que_debería_dar_falso();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}