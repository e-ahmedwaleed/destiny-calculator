package destiny.joe.gui.helper;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.Label;

import destiny.joe.items.enums.Stat;

public class StatTotal extends Observable implements Observer {

    private final Stat stat;
    private final Label label;
    private final ItemPickerRow[] items;

    public StatTotal(Stat stat, Label label, ItemPickerRow[] items) {
        this.stat = stat;
        this.label = label;
        this.items = items;
        for (ItemPickerRow item : items)
            item.addObserver(this);
    }

    public Integer getValue() {
        return Integer.parseInt(label.getText());
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer total = stat == Stat.NULL ? 12 : 2;

        for (ItemPickerRow item : items)
            if (stat == Stat.NULL)
                total += item.getTotalStats();
            else
                total += item.getStat(stat);

        label.setText(total.toString());

        setChanged();
        super.notifyObservers();
    }

}
