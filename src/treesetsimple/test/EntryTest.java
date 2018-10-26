package treesetsimple.test;
import treesetsimple.structs.MyTreeSet;
public class EntryTest extends Test
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
    private void probando_first_last_normal() throws Exception {
        MyTreeSet<String> set = cargando();
        comprobar_que(set.first() != null && set.first().equals("Deborah"));
        comprobar_que(set.last() != null && set.last().equals("Tommy"));
    }
    private void probando_first_last_poll() throws Exception {
        MyTreeSet<String> set = cargando();        
        comprobar_que(set.first().equals(set.pollFirst()));
        comprobar_que(set.last().equals(set.pollLast()));
        comprobar_que(set.first() != null && !set.first().equals("Deborah"));
        comprobar_que(set.last() != null && !set.last().equals("Tommy"));
        comprobar_que(set.size() == 4);
    }
    private void probando_ceiling_higher_normal() throws Exception {
        MyTreeSet<String> set = cargando();
        comprobar_que(set.ceiling("Franco") != null && set.ceiling("Franco").equals("Franco"));
        comprobar_que(set.higher("Manuela") != null && set.higher("Manuela").equals("Miguel"));
    }
    private void probando_ceiling_higher_nulo() throws Exception {
        MyTreeSet<String> set = cargando();
        comprobar_que(set.ceiling(null) == null && set.ceiling(null) == null);
        comprobar_que(set.higher(null) == null && set.higher(null) == null);
    }
    private void probando_ceiling_higher_poll() throws Exception {
        MyTreeSet<String> set = cargando();
        comprobar_que(set.ceiling("Deborah") != null && set.ceiling("Deborah").equals("Deborah"));
        comprobar_que(set.higher("Deborah") != null && set.higher("Deborah").equals("Denisse"));
        comprobar_que(set.ceiling("Miguel") != null && set.ceiling("Miguel").equals("Miguel"));
        comprobar_que(set.higher("Miguel") != null && set.higher("Miguel").equals("Tommy"));
        set.pollFirst();
        set.pollLast();
        
        comprobar_que(set.ceiling("Deborah") != null && !set.ceiling("Deborah").equals("Deborah"));
        comprobar_que(set.higher("Deborah") != null && set.higher("Deborah").equals("Denisse"));
        comprobar_que(set.ceiling("Miguel") != null && set.ceiling("Miguel").equals("Miguel"));
        comprobar_que(set.higher("Miguel") == null && set.higher("Miguel") == null);
        comprobar_que(set.size() == 4);
    }
    private void probando_floor_lower_normal() throws Exception {
        MyTreeSet<String> set = cargando();
        comprobar_que(set.floor("Franco") != null && set.floor("Franco").equals("Franco"));
        comprobar_que(set.lower("Franco") != null && set.lower("Franco").equals("Denisse"));
    }
    private void probando_floor_lower_nulo() throws Exception {
        MyTreeSet<String> set = cargando();
        comprobar_que(set.floor(null) == null && set.floor(null) == null);
        comprobar_que(set.lower(null) == null && set.lower(null) == null);
    }
    private void probando_floor_lower_poll() throws Exception {
        MyTreeSet<String> set = cargando();
        comprobar_que(set.floor("Franco") != null && set.floor("Franco").equals("Franco"));
        comprobar_que(set.lower("Franco") != null && set.lower("Franco").equals("Denisse"));
        set.pollFirst();
        set.pollLast();
        comprobar_que(set.floor("Franco") != null);
        comprobar_que(set.lower("Franco") != null);
        comprobar_que(set.floor("Miguel") != null && set.floor("Miguel").equals("Miguel"));
        comprobar_que(set.lower("Miguel") != null && set.lower("Miguel").equals("Manuela"));
        comprobar_que(set.size() == 4);
    }
    //</editor-fold>
    @Override
    public void test() {
        try{
            probando_first_last_normal();
            probando_first_last_poll();
            probando_ceiling_higher_normal();
            probando_ceiling_higher_nulo();
            probando_ceiling_higher_poll();
            probando_floor_lower_normal();
            probando_floor_lower_nulo();
            probando_floor_lower_poll();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }    
}