package destiny.joe.items;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Column;
import destiny.joe.items.enums.MasterWork;
import destiny.joe.items.enums.Tier;
import destiny.joe.items.enums.Type;
import destiny.joe.utils.FileReader;

public class ItemsFactory {

    private static final String[] REQUIRED = { "Name", "Tier", "Type", "Equippable", "Masterwork Type",
            "Mobility (Base)", "Resilience (Base)", "Recovery (Base)", "Discipline (Base)", "Intellect (Base)",
            "Strength (Base)", "Masterwork Tier" };

    private static Map<Character, Map<Type, List<Item>>> availableItems;
    static {
        try {
            availableItems = ItemsFactory.parseItems(new FileReader("destinyArmor.csv", ",").read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ItemsFactory() {
    }

    public static List<Item> getItems(Type type, Character character) {
        return new ArrayList<>(availableItems.get(character).get(type));
    }

    private static Map<Character, Map<Type, List<Item>>> parseItems(String[][] dataFile) {

        Map<String, Integer> indices = new HashMap<>();

        for (int i = 0; i < dataFile[0].length; i++)
            if (isRequired(dataFile[0][i]))
                indices.put(dataFile[0][i], i);

        Map<Character, Map<Type, List<Item>>> items = new EnumMap<>(Character.class);

        for (Character c : Character.values()) {
            if (c == Character.NULL)
                continue;
            items.put(c, new EnumMap<>(Type.class));
            for (Type t : Type.values())
                items.get(c).put(t, new ArrayList<>());
        }

        for (int i = 0; i < dataFile.length - 1; i++) {
            Item item = parseItem(dataFile[i + 1], indices);
            if (item != null)
                items.get(item.character).get(item.type).add(item);
        }

        return items;
    }

    private static boolean isRequired(String column) {
        for (String r : REQUIRED)
            if (column.equals(r))
                return true;
        return false;
    }

    private static Item parseItem(String[] data, Map<String, Integer> indices) {
        try {
            String itemName = data[indices.get("Name")];

            Column[] itemProperties = new Column[4];
            itemProperties[0] = Column.identifyColumn(data[indices.get("Tier")], Tier.NULL);
            itemProperties[1] = Column.identifyColumn(data[indices.get("Type")], Type.NULL);
            itemProperties[2] = Column.identifyColumn(data[indices.get("Equippable")], Character.NULL);
            itemProperties[3] = Column.identifyColumn(data[indices.get("Masterwork Type")], MasterWork.NULL);

            int[] itemStats = new int[7];
            itemStats[0] = Integer.parseInt(data[indices.get("Mobility (Base)")]);
            itemStats[1] = Integer.parseInt(data[indices.get("Resilience (Base)")]);
            itemStats[2] = Integer.parseInt(data[indices.get("Recovery (Base)")]);
            itemStats[3] = Integer.parseInt(data[indices.get("Discipline (Base)")]);
            itemStats[4] = Integer.parseInt(data[indices.get("Intellect (Base)")]);
            itemStats[5] = Integer.parseInt(data[indices.get("Strength (Base)")]);
            itemStats[6] = Integer.parseInt(data[indices.get("Masterwork Tier")]);

            return new Item(itemName, itemProperties, itemStats);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
