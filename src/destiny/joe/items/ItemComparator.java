package destiny.joe.items;

import java.util.Comparator;

import destiny.joe.items.enums.ItemProperty;
import destiny.joe.items.enums.MasterWork;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Tier;
import destiny.joe.items.enums.Type;

public class ItemComparator implements Comparator<Item> {

    private ItemProperty property;

    public ItemComparator(ItemProperty property) {
        this.property = property;
    }

    @Override
    public int compare(Item o1, Item o2) {

        if (property instanceof MasterWork)
            return -1 * Integer.compare(o1.masterWork.ordinal(), o2.masterWork.ordinal());

        else if (property instanceof Tier)
            return -1 * Integer.compare(o1.tier.ordinal(), o2.tier.ordinal());

        else if (property instanceof Stat) {

            if (property.equals(Stat.NULL))
                return -1 * Integer.compare(o1.getTotalStats(), o2.getTotalStats());
            else
                return -1 * Integer.compare(o1.stats.get(property), o2.stats.get(property));

        }

        else if (property instanceof Type)
            return Integer.compare(o1.type.ordinal(), o2.type.ordinal());

        else
            return o1.name.compareTo(o2.name);

    }

}