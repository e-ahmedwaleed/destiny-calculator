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
                items.put(t, filterDuplicates(t, character));
            }

        updateStatus(character.getString() + " duplicates filtered.");

        ItemSet set = new ItemSet();
        List<ItemSet> sets = new ArrayList<>();

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
        updateStatus(character.getString() + " combinations generated.");

        System.out.print(character.getString() + ": ");
        System.out.print(items.get(Type.HELMET).size() + ", ");
        System.out.print(items.get(Type.GAUNTLETS).size() + ", ");
        System.out.print(items.get(Type.CHEST_ARMOR).size() + ", ");
        System.out.print(items.get(Type.LEG_ARMOR).size() + ", ");
        System.out.println(sets.size());

        sets.sort(new ItemSetComparator());

        try (FileWriter out = new FileWriter(
                GUI.getAbsolutePath("destiny-calculator_analysis/") + character.getString().toLowerCase() + ".csv")) {
            out.write("Total,Mob,Res,Rec,Dis,Int,Str,");
            out.write("Helmet,Tier,HType,HMob,HRes,HRec,HDis,HInt,HStr,");
            out.write("Gauntlets,GTier,GType,GMob,GRes,GRec,GDis,GInt,GStr,");
            out.write("Chest,Tier,CType,CMob,CRes,CRec,CDis,CInt,CStr,");
            out.write("Leg,LTier,LType,LMob,LRes,LRec,LDis,LInt,LStr\n");

            for (ItemSet s : sets)
                // TODO
                if (/* sets.get(0).getSetTier() - tolerance */ 30 <= s.getSetTier())
                    out.write(s.toString() + "\n");
                else
                    break;

        } catch (IOException e) {
            e.printStackTrace();
        }

        updateStatus(character.getString() + " done.");
    }

    private List<Item> filterDuplicates(Type type, Character character) {

        List<Item> list = ItemManager.getItems(type, character);
        StringBuilder s = new StringBuilder();

        int index = 0;
        while (index < list.size()) {
            boolean deleted = false;
            Item item = list.get(index);
            for (int i = list.size() - 1; i > index; i--)
                if (list.get(i).isSimilarTo(item)) {
                    deleted = true;
                    s.append(list.remove(i).toString() + "\n");
                }
            if (deleted)
                s.append(item.toString() + "\n,,,,,,\n");
            index++;
        }

        if (s.length() > 0)
            try (FileWriter out = new FileWriter(GUI.getAbsolutePath("destiny-calculator_analysis/")
                    + character.getString().toLowerCase() + "-" + type.getFirstString() + "-duplicates.csv")) {

                out.write("Item,Mob,Res,Rec,Dis,Int,Str\n" + s.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        return list;
    }

    @Override
    public void load() {
        generateCombinations(Character.HUNTER, 1);
        generateCombinations(Character.TITAN, 1);
        generateCombinations(Character.WARLOCK, 1);
        updateStatus("Closing ...");
    }

}
