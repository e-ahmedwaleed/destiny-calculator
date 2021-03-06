package destiny.joe.items;

import java.util.EnumMap;
import java.util.Map;

import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.ItemProperty.Categorial;
import destiny.joe.items.enums.MasterWork;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Tier;
import destiny.joe.items.enums.Type;

public class Item {

    public static final Item NULL = new Item();

    public String name;

    public Tier tier;
    public Type type;
    public Character character;
    public MasterWork masterWork;

    public Map<Stat, Integer> stats;

    public Item() {
        name = "Item name";

        tier = Tier.NULL;
        type = Type.NULL;
        character = Character.NULL;
        masterWork = MasterWork.NULL;

        stats = new EnumMap<>(Stat.class);

        stats.put(Stat.MOBILITY, 0);
        stats.put(Stat.RESILIENCE, 0);
        stats.put(Stat.RECOVERY, 0);
        stats.put(Stat.DISCIPLINE, 0);
        stats.put(Stat.INTELLECT, 0);
        stats.put(Stat.STRENGTH, 0);
        stats.put(Stat.MASTER_WORK, 0);
    }

    public Item(String itemName, Categorial[] itemProperties, int[] itemStats) {
        name = itemName;

        tier = (Tier) itemProperties[0];
        type = (Type) itemProperties[1];
        character = (Character) itemProperties[2];
        masterWork = (MasterWork) itemProperties[3];

        stats = new EnumMap<>(Stat.class);
        stats.put(Stat.MOBILITY, itemStats[0]);
        stats.put(Stat.RESILIENCE, itemStats[1]);
        stats.put(Stat.RECOVERY, itemStats[2]);
        stats.put(Stat.DISCIPLINE, itemStats[3]);
        stats.put(Stat.INTELLECT, itemStats[4]);
        stats.put(Stat.STRENGTH, itemStats[5]);
        stats.put(Stat.MASTER_WORK, itemStats[6]);
    }

    public Integer getTotalStats() {
        int total = 0;
        for (int i = 1; i < 7; i++)
            total += stats.get(Stat.values()[i]);
        return total;
    }

    public boolean isSimilarTo(Item oItem) {
        if (!oItem.character.equals(character))
            return false;
        for (Stat s : Stat.values())
            if (s != Stat.NULL && s != Stat.MASTER_WORK && !oItem.stats.get(s).equals(stats.get(s)))
                return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Item))
            return false;

        Item oItem = (Item) o;

        if (!oItem.name.equals(name))
            return false;
        if (!oItem.tier.equals(tier))
            return false;
        if (!oItem.type.equals(type))
            return false;
        if (!oItem.masterWork.equals(masterWork))
            return false;
        if (!oItem.stats.get(Stat.MASTER_WORK).equals(stats.get(Stat.MASTER_WORK)))
            return false;

        return isSimilarTo(oItem);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name + ",");
        s.append(tier.getString() + ",");
        s.append(masterWork.getFirstString() + ",");
        for (Stat stat : Stat.values())
            if (stat.ordinal() % 7 != 0)
                s.append(stats.get(stat) + ",");
        return s.toString();
    }

    @Override
    // "equals(Object obj)" and "hashCode()" should be overridden in pairs.
    public int hashCode() {
        return super.hashCode();
    }

}
