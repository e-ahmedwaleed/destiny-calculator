package destiny.joe.gui.helper;

import java.util.Observable;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;

import destiny.joe.gui.ItemChooser;
import destiny.joe.items.Item;
import destiny.joe.items.ItemManager;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Type;
import destiny.joe.utils.GUI;

public class ItemPickerRow extends Observable implements Savable<Type, Item> {

    private Item item;
    private boolean mw;

    private final Type type;
    private final ToolItem favorite;

    /**
     * [0]: clear. [1]: master-work.
     */
    private final Button[] buttons;

    /**
     * [0] Item name. [1] Item tier. [2->7] base stats [8] base stats total [9->14]
     * mw stats [15] mw stats total [16] mw type [17] mw tier
     */
    private final Label[] labels;

    public ItemPickerRow(Type type, Button[] buttons, Label[] labels, ToolItem favorite, Shell shell) {
        this.buttons = buttons;
        this.labels = labels;
        this.type = type;
        this.favorite = favorite;
        setLoadedData(Item.NULL);
        buttons[0].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setLoadedData(Item.NULL);
                shell.forceFocus();
            }
        });
        buttons[1].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                masterworkToggle(buttons[1].getSelection());
                shell.forceFocus();
            }
        });
        favorite.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (getDataValue() != null && ItemManager.isFavorite(getDataValue())) {
                    favorite.setImage(GUI.loadImage(shell.getDisplay(), "favorite-off.png"));
                    ItemManager.deleteFromFavorites(getDataValue());
                } else {
                    favorite.setImage(GUI.loadImage(shell.getDisplay(), "favorite-on.png"));
                    ItemManager.addToFavorites(getDataValue());
                }
                shell.forceFocus();
            }
        });
    }

    public void pickItem(Shell shell, Character selectedChar) {
        setLoadedData(new ItemChooser(shell, SWT.CLOSE, getDataKey(), selectedChar).open());
    }

    public int getStat(Stat stat) {
        return getDataValue().stats.get(stat) + (mw ? 2 : 0);
    }

    public int getTotalStats() {
        return getDataValue().getTotalStats() + (mw ? 12 : 0);
    }

    public Type getDataKey() {
        return type;
    }

    public Item getDataValue() {
        return item;
    }

    public void setLoadedData(Item item) {
        if (item == null)
            return;
        this.item = item;

        labels[0].setText(item.name);
        labels[1].setText(item.tier.getString());

        Integer total = 0;
        for (int i = 1; i < 7; i++) {
            Integer stat = item.stats.get(Stat.values()[i]);
            labels[i + 1].setText(stat.toString());
            total += stat;
        }
        labels[8].setText(total.toString());

        Integer mwTotal = 0;
        for (int i = 1; i < 7; i++) {
            Integer mwStat = item.stats.get(Stat.values()[i]) + 2;
            labels[i + 8].setText(mwStat.toString());
            mwTotal += mwStat;
        }
        labels[15].setText(mwTotal.toString());

        labels[16].setText(item.masterWork.getFirstString());

        int masterwork = item.stats.get(Stat.MASTER_WORK);
        labels[17].setText(masterwork + " / 10");

        buttons[0].setEnabled(!item.equals(Item.NULL));

        masterworkToggle(!item.equals(Item.NULL));
        buttons[1].setEnabled(masterwork < 10);

        favorite.getParent().setVisible(!item.equals(Item.NULL));

        if (!item.equals(Item.NULL) && ItemManager.isFavorite(item)) {
            favorite.setImage(GUI.loadImage(Display.getDefault(), "favorite-on.png"));
        } else {
            favorite.setImage(GUI.loadImage(Display.getDefault(), "favorite-off.png"));
        }
    }

    private void masterworkToggle(boolean on) {
        mw = on;
        buttons[1].setSelection(on);
        for (int i = 1; i < 8; i++) {
            labels[i + 1].setEnabled(!on);
            labels[i + 8].setEnabled(on);
        }
        // All functions end up calling masterworkToggle.
        notifyObservers();
    }

    // https://stackoverflow.com/questions/21962276/observable-observer-not-working
    @Override
    public void notifyObservers() {
        setChanged();
        super.notifyObservers();
    }

}
