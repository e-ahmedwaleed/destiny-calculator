package destiny.joe.items.sets;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import destiny.joe.items.Item;
import destiny.joe.items.ItemManager;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Type;
import destiny.joe.utils.DataConvertionUtil;
import destiny.joe.utils.FileChooser;
import destiny.joe.utils.GUI;

public class ItemSetBuilder extends Loadable {

    private static final int MAX_ROWS_PER_SHEET = 65535;
    private final Shell parent;

    public ItemSetBuilder(Shell parent) {
        this.parent = parent;
    }

    @Override
    public void load() {
        int[] filesCount = { generateCombinations(Character.HUNTER, 2), generateCombinations(Character.TITAN, 2),
                generateCombinations(Character.WARLOCK, 2) };
        convertToExcel(filesCount);
        updateStatus("You can't see me :)");
    }

    private int generateCombinations(Character character, int tolerance) {
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

        int index = 0;
        int maxTier = sets.get(0).getSetTier();
        int currentTier = sets.get(0).getSetTier();
        while (currentTier >= maxTier - tolerance && index * MAX_ROWS_PER_SHEET <= sets.size())
            try (FileWriter out = new FileWriter(csvFilePath(character, index))) {
                out.write("Total,Mob,Res,Rec,Dis,Int,Str,");
                out.write("Helmet,HTier,HType,HMob,HRes,HRec,HDis,HInt,HStr,");
                out.write("Gauntlets,GTier,GType,GMob,GRes,GRec,GDis,GInt,GStr,");
                out.write("Chest,CTier,CType,CMob,CRes,CRec,CDis,CInt,CStr,");
                out.write("Leg,LTier,LType,LMob,LRes,LRec,LDis,LInt,LStr\n");

                for (int i = 0; i < MAX_ROWS_PER_SHEET; i++) {
                    if (sets.get(i + index * MAX_ROWS_PER_SHEET).getSetTier() < currentTier)
                        currentTier--;
                    if (currentTier < maxTier - tolerance)
                        break;
                    out.write(sets.get(i + index * MAX_ROWS_PER_SHEET).toString() + "\n");
                }

                index++;

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        updateStatus(character.getString() + " done.");

        return index;
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
                s.append(item.toString() + "\n,,,,,,,,\n");
            index++;
        }

        if (s.length() > 0)
            try (FileWriter out = new FileWriter(GUI.getAbsolutePath("destiny-calculator_analysis/")
                    + character.getString().toLowerCase() + "-" + type.getFirstString() + "-duplicates.csv")) {

                out.write("Item,Tier,Type,Mob,Res,Rec,Dis,Int,Str\n" + s.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        return list;
    }

    private void convertToExcel(int[] filesCount) {
        updateStatus("Converting to excel ...");
        String[] filters = { "Excel 97-2003 Wrokbook", ".xls", "destiny-calculator_analysis/" };
        String excelPath = new FileChooser(parent, SWT.CLOSE).open(true, filters);

        List<String> analysisCSV = new ArrayList<>();
        for (Character c : Character.values()) {
            if (c == Character.NULL)
                continue;
            for (int i = 0; i < filesCount[c.ordinal() - 1]; i++)
                analysisCSV.add(csvFilePath(c, i));
        }
        if (excelPath != null)
            DataConvertionUtil.csvToExcel(analysisCSV, excelPath);
    }

    private String csvFilePath(Character character, int index) {
        return GUI.getAbsolutePath("destiny-calculator_analysis/") + character.getString().toLowerCase() + "-" + index
                + ".csv";
    }

}
