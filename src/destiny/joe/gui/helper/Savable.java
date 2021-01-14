package destiny.joe.gui.helper;

public interface Savable<K, V> {

    public K getDataKey();

    public V getDataValue();

    public void setLoadedData(V value);

}
