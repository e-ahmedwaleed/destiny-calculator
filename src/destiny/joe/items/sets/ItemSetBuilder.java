package destiny.joe.items.sets;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import destiny.joe.items.Item;
import destiny.joe.items.ItemManager;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Type;
import destiny.joe.utils.GUI;

public class ItemSetBuilder extends Loadable {

    private void generateCombinations(Character character, int tolerance) {
        Map<Type, List<Item>> items = new EnumMap<>(Type.class);
        for (Type t : Type.values())
            if (t != Type.NULL) {
                items.put(t, ItemManager.getItems(t, character));
            }

        ItemSet set = new ItemSet();
        List<ItemSet> sets = new ArrayList<>();

        madeProgress();
        for (Item helmet : items.get(Type.HELMET)) {
            ItemSet setH = set.append(helmet);
            for (Item gauntlets : items.get(Type.GAUNTLETS)) {
                if (setH != null) {
                    ItemSet setHG = setH.append(gauntlets);
                    for (Item chest : items.get(Type.CHEST_ARMOR)) {
                        if (setHG != null) {
                            ItemSet setHGC = setHG.append(chest);
                            for (Item leg : items.get(Type.LEG_ARMOR)) {
                                if (setHGC != null) {
                                    ItemSet setHGCL = setHGC.append(leg);
                                    if (setHGCL != null) {
                                        sets.add(setHGCL);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        madeProgress();
        System.out.print(character.getString() + ": ");
        System.out.print(items.get(Type.HELMET).size() + ", ");
        System.out.print(items.get(Type.GAUNTLETS).size() + ", ");
        System.out.print(items.get(Type.CHEST_ARMOR).size() + ", ");
        System.out.print(items.get(Type.LEG_ARMOR).size() + ", ");
        System.out.println(sets.size());

        sets.sort(new ItemSetComparator());

        try (FileWriter out = new FileWriter(GUI.getAbsolutePath("") + character.getString().toLowerCase() + ".csv")) {
            out.write("Total,Mob,Res,Rec,Dis,Int,Str,");
            out.write("Helmet,Mob,Res,Rec,Dis,Int,Str,Tier,Type,");
            out.write("Gauntlets,Mob,Res,Rec,Dis,Int,Str,Tier,Type,");
            out.write("Chest,Mob,Res,Rec,Dis,Int,Str,Tier,Type,");
            out.write("Leg,Mob,Res,Rec,Dis,Int,Str,Tier,Type\n");

            for (ItemSet s : sets)
                if (sets.get(0).getSetTier() - tolerance <= s.getSetTier())
                    out.write(s.toString() + "\n");
                else
                    break;

        } catch (IOException e) {
            e.printStackTrace();
        }
        madeProgress();
    }

    @Override
    public void load() {
        generateCombinations(Character.HUNTER, 1);
        generateCombinations(Character.TITAN, 1);
        generateCombinations(Character.WARLOCK, 1);
        madeProgress();
    }

}
