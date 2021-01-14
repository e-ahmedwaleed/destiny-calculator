package destiny.joe.gui.helper;

import java.util.Observable;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;

import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.ItemProperty.Categorial;

public class CharacterChooser extends Observable implements ModifyListener {

    private Character selectedChar = Character.NULL;
    private Character prevSelectedChar;

    private final Runnable reset;
    private final Group grpItemPicker;
    private final Combo comboCharacter;

    public CharacterChooser(Group grpItemPicker, Combo comboCharacter, Runnable reset) {
        this.grpItemPicker = grpItemPicker;
        this.comboCharacter = comboCharacter;
        this.reset = reset;
    }

    public Character getCharacter() {
        return selectedChar;
    }

    @Override
    public void modifyText(ModifyEvent e) {
        selectedChar = (Character) Categorial.identify(comboCharacter.getText(), Character.NULL);
        grpItemPicker.setEnabled(selectedChar != Character.NULL);
        if (grpItemPicker.getEnabled() && selectedChar != prevSelectedChar) {
            setChanged();
            notifyObservers(selectedChar);
            reset.run();
        }
        prevSelectedChar = selectedChar;
    }

}
