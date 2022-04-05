import java.util.ArrayList;
import java.util.LinkedList;

public class MyChainingHashMap <K extends Hashable, V> extends MyHashMap<K, V> {
    private ArrayList<LinkedList<Pair<K, V>>> table;

    public MyChainingHashMap() {
        table = new ArrayList<>(this.capacity);

        for (int i = 0; i < this.capacity; i++) {
            table.add(null);
        }
    }

    private LinkedList<Pair<K, V>> getList(K k) {
        return table.get(getTableIndex(k));
    }

    public void put(K k, V v) {
        LinkedList<Pair<K, V>> list = getList(k);

        if(list == null) {
            list = new LinkedList<Pair<K, V>>();
            table.set(getTableIndex(k), list);
        }

        for(Pair<K, V> p : list) {
            if (p.key.equals(k)) {
                p.value = v;
                return;
            }
        }

        list.add(new Pair<K, V>(k, v));
    }

    public V get(K k) {
        LinkedList<Pair<K, V>> list = getList(k);

        if(list == null) return null;

        for(Pair<K, V> p : list) {
            if (p.key.equals(k)) {
                return p.value;
            }
        }

        return null;
    }

    public void remove(K k) {
        LinkedList<Pair<K, V>> list = getList(k);

        if(list == null) return;

        Pair<K, V> doomed = null;

        for(Pair<K, V> p : list) {
            if (p.key.equals(k)) {
                doomed = p;
                break;
            }
        }

        if(doomed != null) list.remove(doomed);
    }

    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < table.size(); i++) {
            s += i + ": ";

            LinkedList<Pair<K, V>> list = table.get(i);

            if(list != null) {
                for (Pair<K, V> p : table.get(i)) {
                    s += "<" + p.key + ", " + p.value + ">\t";
                }
            }
            s += "\n";
        }

        return s;
    }
}