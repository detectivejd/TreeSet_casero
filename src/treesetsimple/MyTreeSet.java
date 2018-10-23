package treesetsimple;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
/**
 *
 * @author detectivejd
 * @param <E>
 */
public class MyTreeSet<E> implements NavigableSet<E>
{
    private NavigableMap<E,Object> map;
    private final Object PRESENT = new Object();
    
    MyTreeSet(NavigableMap<E,Object> xm) {
        this.map = xm;
    }    
    public MyTreeSet() {
        this(new MyTreeMap<E,Object>());
    }
    public MyTreeSet(Comparator<? super E> comparator) {
        this(new MyTreeMap<>(comparator));
    }
    public MyTreeSet(Collection<? extends E> c) {
        this();
        addAll(c);
    }
    public MyTreeSet(SortedSet<E> s) {
        this(s.comparator());
        addAll(s);
    }
    /*----------------------------------------------------------*/ 
    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c.size() > 0){
            c.forEach((obj) -> {
                this.add(obj);
            });
            return true;
        }
        return false;
    }
    /*----------------------------------------------------------*/ 
    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        if(c.size() > 0){
            c.forEach((obj) -> {
                if(this.contains((E)obj)){
                    map.remove((E)obj);
                }
            });
            return true;
        }
        return false;
    }
    /*----------------------------------------------------------*/ 
    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        if(c.size() > 0){
            for(Object e : c){
                if(!this.contains((E)e)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    /*----------------------------------------------------------*/ 
    @Override
    public Object[] toArray() {
        Object[] array = new Object[map.size()];
        int i=0;
        for(E obj : map.keySet()){
            array[i] = obj;
            i++;
        }
        return array;
    }
    @Override
    public <T> T[] toArray(T[] a) {
        int i=0;
        for(E obj : map.keySet()){
            a[i] = (T)obj;
            i++;
        }
        return a;
    }            
    @Override
    public boolean retainAll(Collection<?> c) {
        if(c.size() > 0){
            for(E e : map.keySet()) {
                if(!c.contains(e)){
                    this.remove(e);
                }
            }
            return true;
        }
        return false;
    }
    /*----------------------------------------------------------*/
    @Override
    public int size() {
        return map.size();
    }
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
    @Override
    public void clear() {
        map.clear();
    }    
    @Override
    public Comparator<? super E> comparator() {
        return map.comparator();
    }
    /*----------------------------------------------------------*/
    @Override
    public Iterator<E> iterator() {
        return map.navigableKeySet().iterator();
        //return map.keySet().iterator();
    }
    @Override
    public NavigableSet<E> descendingSet() {
        return new MyTreeSet<>(map.descendingMap());
    }
    @Override
    public Iterator<E> descendingIterator() {
        return map.descendingKeySet().iterator();
    }
    /*----------------------------------------------------------*/
    @Override
    public E lower(E e) {
        return map.lowerKey(e);
    }
    @Override
    public E floor(E e) {
        return map.floorKey(e);
    }
    @Override
    public E ceiling(E e) {
        return map.ceilingKey(e);
    }
    @Override
    public E higher(E e) {
        return map.higherKey(e);
    }
    @Override
    public E first() {
        return map.firstKey();    
    }
    @Override
    public E last() {
        return map.lastKey();
    }
    @Override
    public E pollFirst() {
        Map.Entry<E,?> e = map.pollFirstEntry();
        return (e == null) ? null : e.getKey();
    }
    @Override
    public E pollLast() {
        Map.Entry<E,?> e = map.pollLastEntry();
        return (e == null) ? null : e.getKey();
    }
    /*----------------------------------------------------------*/
    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return subSet(fromElement, true, toElement, false);
    }
    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return new MyTreeSet(map.subMap(fromElement, fromInclusive,toElement,toInclusive));
    }
    @Override
    public SortedSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }
    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return new MyTreeSet<>(map.headMap(toElement, inclusive));
    }
    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }
    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return new MyTreeSet<>(map.tailMap(fromElement, inclusive));
    }
    @Override
    public String toString() {
        Iterator<E> it = iterator();
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if(!it.hasNext()){
            sb.append(']');
        } else {
            while(it.hasNext()){
                E e = it.next();
                if(it.hasNext()){
                    sb.append(e).append(',').append(' ');
                } else {
                    sb.append(e).append(']');
                }
            }
        } 
        return sb.toString();
    }
}