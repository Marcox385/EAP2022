public abstract class MyHashMap <K extends Hashable, V> {
    public static final int C = 10;

    // Factor de carga = división de estos atributos
    protected int size = 0;
    protected int capacity = C;

    protected final int getTableIndex(K k) {
        return k.hashCode(this.capacity);
    }

    public abstract void put(K k, V v);
    public abstract V get(K k);
    public abstract void remove(K k);

    public final int size() {
        return size;
    }
}