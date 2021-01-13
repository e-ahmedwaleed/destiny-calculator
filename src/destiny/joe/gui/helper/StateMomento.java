package destiny.joe.gui.helper;

import java.util.HashMap;
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
        mods = new HashMap<>();
        items = new HashMap<>();
        selectedChar = Character.NULL;
    }

    public StateMomento(ItemPickerRow[] itemRows, ModsRow[] modRows, Character selectedChar) {
        this();

        this.selectedChar = selectedChar;

        for (ItemPickerRow iRow : itemRows)
            items.put(iRow.getType(), iRow.getItem());

        for (ModsRow mRow : modRows)
            mods.put(mRow.getType(), mRow.getMod());

    }

    public void loadMomento(ItemPickerRow[] itemRows, ModsRow[] modRows, Combo comboCharacter) {

        comboCharacter.setText(selectedChar.getString());

        for (Type t : items.keySet())
            itemRows[t.ordinal() - 1].updateItem(items.get(t));

        for (Stat s : mods.keySet())
            modRows[s.ordinal() - 1].updateMod(mods.get(s)[0], mods.get(s)[1]);

    }

}
