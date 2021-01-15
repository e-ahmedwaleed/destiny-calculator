package destiny.joe.items.sets;

import java.util.Comparator;

public class ItemSetComparator implements Comparator<ItemSet> {

    @Override
    public int compare(ItemSet o1, ItemSet o2) {
        return -1 * Integer.compare(o1.getSetTier(), o2.getSetTier());
    }

}
