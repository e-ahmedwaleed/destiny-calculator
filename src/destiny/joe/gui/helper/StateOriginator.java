package destiny.joe.gui.helper;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.Combo;

import destiny.joe.items.Item;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Type;
import destiny.joe.items.enums.ItemProperty.Categorial;

public class StateOriginator implements Observer {

    private Deque<StateMomento> undoHistory;
    private Deque<StateMomento> redoHistory;

    private final Combo comboCharacter;
    private final Savable<Type, Item>[] itemRows;
    private final Savable<Stat, int[]>[] modRows;

    public StateOriginator(Savable<Type, Item>[] itemRows, Savable<Stat, int[]>[] modRows, Combo comboCharacter) {
        undoHistory = new LinkedList<>();
        redoHistory = new LinkedList<>();
        this.modRows = modRows;
        this.itemRows = itemRows;
        this.comboCharacter = comboCharacter;
    }

    private boolean externalChange = true;

    public void redo() {
        undoHistory.push(redoHistory.pop());
        undoHistory.peek().loadMomento(itemRows, modRows, comboCharacter);
        externalChange = false;
    }

    public void undo() {
        redoHistory.push(undoHistory.pop());
        redoHistory.peek().loadMomento(itemRows, modRows, comboCharacter);
        externalChange = false;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (externalChange) {
            redoHistory.clear();
            Character selectedChar = (Character) Categorial.identify(comboCharacter.getText(), Character.NULL);
            if (selectedChar != Character.NULL)
                undoHistory.push(new StateMomento(itemRows, modRows, selectedChar));
        }
        externalChange = true;
    }

}
