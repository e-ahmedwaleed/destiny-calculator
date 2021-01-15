package destiny.joe.items.sets;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import destiny.joe.items.Item;
import destiny.joe.items.enums.Tier;
import destiny.joe.items.enums.Type;
import destiny.joe.items.enums.MasterWork;
import destiny.joe.items.enums.Stat;

public class ItemSet {

    private int[] stats;
    private Map<Type, Item> items;

    public ItemSet() {
        stats = new int[6];
        items = new EnumMap<>(Type.class);
    }

    ItemSet append(Item item) {
        // You can't equip two EXOTIC items.
        if (hasExotic() && item.tier == Tier.EXOTIC)
            return null;
        return new ItemSet(this, item);
    }

    public Integer getSetTier() {
        int score = 0;
        for (Stat s : Stat.values())
            if (s.ordinal() % 7 != 0)
                score += getStatScore(s);
        score = penaltyFilter(score);
        return score;
    }

    private int penaltyFilter(int score) {
        /**
         * Assuming that the class item is always ARC, then it is a shame to waste the
         * +20 Mod. same goes if there is anther ARC item.
         */
        int penalty = 0;
        if (hasArc()) {
            penalty = getStatScore(Stat.STRENGTH) + getStatScore(Stat.MOBILITY) - 16;
        } else {
            int penaltySTR = getStatScore(Stat.STRENGTH) - 8;
            int penaltyMOB = getStatScore(Stat.MOBILITY) - 8;
            penalty = penaltySTR < penaltyMOB ? penaltySTR : penaltyMOB;
        }
        score -= penalty > 0 ? penalty : 0;
        return score;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("T" + getSetTier() + ",");
        for (int stat : stats) {
            s.append(stat + ",");
        }
        for (Item item : items.values()) {
            s.append(item.name + ",");
            for (Stat stat : Stat.values())
                if (stat.ordinal() % 7 != 0)
                    s.append(item.stats.get(stat) + ",");
            s.append(item.tier.getString() + ",");
            s.append(item.masterWork.getFirstString() + ",");
        }

        return s.toString();
    }

    private ItemSet(ItemSet set, Item item) {
        stats = Arrays.copyOf(set.stats, set.stats.length);
        items = new EnumMap<>(set.items);
        addItem(item);
    }

    private void addItem(Item item) {
        items.put(item.type, item);

        for (Stat s : Stat.values())
            if (s.ordinal() % 7 != 0)
                stats[s.ordinal() - 1] += item.stats.get(s);
    }

    private boolean hasExotic() {
        for (Type t : items.keySet())
            if (items.get(t).tier == Tier.EXOTIC)
                return true;
        return false;
    }

    private boolean hasArc() {
        for (Type t : items.keySet())
            if (items.get(t).masterWork == MasterWork.ARC)
                return true;
        return false;
    }

    private int getStatScore(Stat stat) {
        int value = stats[stat.ordinal() - 1] + 2 * (items.size() + 1);
        value = value < 100 ? (value / 10) : 10;
        return value;
    }

}
