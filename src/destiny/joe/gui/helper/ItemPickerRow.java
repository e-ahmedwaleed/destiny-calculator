package destiny.joe.gui.helper;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import destiny.joe.gui.ItemChooser;
import destiny.joe.items.Item;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Type;

public class ItemPickerRow {

    private final Type type;

    /**
     * [0]: clear. [1]: master-work.
     */
    private final Button[] buttons;

    /**
     * [0] Item name. [1] Item tier. [2->7] base stats [8] base stats total [9->14]
     * mw stats [15] mw stats total [16] mw type [17] mw tier
     */
    private final Label[] labels;

    public ItemPickerRow(Type type, Button[] buttons, Label[] labels) {
        this.buttons = buttons;
        this.labels = labels;
        this.type = type;
        updateItem(Item.NULL);
        buttons[0].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                updateItem(Item.NULL);
            }
        });
        buttons[1].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                masterworkToggle(buttons[1].getSelection());
            }
        });
    }

    public void pickItem(Shell shell, Character selectedChar) {
        updateItem(new ItemChooser(shell, SWT.CLOSE, type, selectedChar).open());
    }

    public void updateItem(Item item) {
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

        labels[16].setText(item.masterWork.type);

        int masterwork = item.stats.get(Stat.MASTER_WORK);
        labels[17].setText(masterwork + "/ 10");

        buttons[0].setEnabled(item != Item.NULL);

        masterworkToggle(masterwork >= 10);
        buttons[1].setEnabled(masterwork < 10);
    }

    private void masterworkToggle(boolean on) {
        buttons[1].setSelection(on);
        for (int i = 1; i < 8; i++) {
            labels[i + 1].setEnabled(!on);
            labels[i + 8].setEnabled(on);
        }
    }

}
