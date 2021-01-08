package destiny.joe.items;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsFactory {

    private static final String[] REQUIRED = { "Name", "Tier", "Type", "Equippable", "Masterwork Tier",
            "Mobility (Base)", "Resilience (Base)", "Recovery (Base)", "Discipline (Base)", "Intellect (Base)",
            "Strength (Base)" };

    private ItemsFactory() {
    }

    public static Map<Character, Map<Type, List<Item>>> parseItems(String[][] dataFile) {

        Map<String, Integer> indices = new HashMap<>();

        for (int i = 0; i < dataFile[0].length; i++)
            if (isRequired(dataFile[0][i]))
                indices.put(dataFile[0][i], i);

        // Item[] items = new Item[];

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
            itemProperties[0] = Tier.identifyColumn(data[indices.get("Tier")]);
            itemProperties[1] = Type.identifyColumn(data[indices.get("Type")]);
            itemProperties[2] = Character.identifyColumn(data[indices.get("Equippable")]);
            itemProperties[3] = MasterWork.identifyColumn(data[indices.get("Masterwork Tier")]);

            int[] itemStats = new int[6];
            itemStats[0] = Integer.parseInt(data[indices.get("Mobility (Base)")]);
            itemStats[1] = Integer.parseInt(data[indices.get("Resilience (Base)")]);
            itemStats[2] = Integer.parseInt(data[indices.get("Recovery (Base)")]);
            itemStats[3] = Integer.parseInt(data[indices.get("Discipline (Base)")]);
            itemStats[4] = Integer.parseInt(data[indices.get("Intellect (Base)")]);
            itemStats[5] = Integer.parseInt(data[indices.get("Strength (Base)")]);

            return new Item(itemName, itemProperties, itemStats);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
