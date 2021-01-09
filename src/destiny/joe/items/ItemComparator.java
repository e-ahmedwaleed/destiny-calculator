package destiny.joe.items;

import java.util.Comparator;

import destiny.joe.items.enums.Stat;

public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {

        int o1Tot = 0;
        for (int s : o1.stats.values())
            o1Tot += s;

        int o2Tot = 0;
        for (int s : o2.stats.values())
            o2Tot += s;

        o1Tot -= o1.stats.get(Stat.MASTER_WORK);
        o2Tot -= o2.stats.get(Stat.MASTER_WORK);

        return -1 * Integer.compare(o1Tot, o2Tot);
    }

}
