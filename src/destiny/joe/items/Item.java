package destiny.joe.items;

import java.util.EnumMap;
import java.util.Map;

import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Column;
import destiny.joe.items.enums.MasterWork;
import destiny.joe.items.enums.Tier;
import destiny.joe.items.enums.Type;

public class Item {

    public static final Item NULL = new Item();

    public final String name;

    public final Tier tier;
    public final Type type;
    public final Character character;
    public final MasterWork masterWork;

    public final Map<Stat, Integer> stats;

    public Item(String itemName, Column[] itemProperties, int[] itemStats) {

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

    private Item() {
        name = "";

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

    public String toString() {
        return name + "\n";
    }

}
