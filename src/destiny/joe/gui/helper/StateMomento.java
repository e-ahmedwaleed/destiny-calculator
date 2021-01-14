package destiny.joe.gui.helper;

import java.util.EnumMap;
import java.util.Map;

import org.eclipse.swt.widgets.Combo;

import destiny.joe.items.Item;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Type;

public class StateMomento {

    public Character selectedChar;
    public Map<Type, Item> items;
    public Map<Stat, int[]> mods;

    public StateMomento() {
        mods = new EnumMap<>(Stat.class);
        items = new EnumMap<>(Type.class);
        selectedChar = Character.NULL;
    }

    public StateMomento(Savable<Type, Item>[] itemRows, Savable<Stat, int[]>[] modRows, Character selectedChar) {
        this();

        this.selectedChar = selectedChar;

        for (Savable<Type, Item> iRow : itemRows)
            items.put(iRow.getDataKey(), iRow.getDataValue());

        for (Savable<Stat, int[]> mRow : modRows)
            mods.put(mRow.getDataKey(), mRow.getDataValue());

    }

    public void loadMomento(Savable<Type, Item>[] itemRows, Savable<Stat, int[]>[] modRows, Combo comboCharacter) {

        comboCharacter.setText(selectedChar.getString());

        for (Type t : items.keySet())
            itemRows[t.ordinal() - 1].setLoadedData(items.get(t));

        for (Stat s : mods.keySet())
            modRows[s.ordinal() - 1].setLoadedData(mods.get(s));

    }

}
