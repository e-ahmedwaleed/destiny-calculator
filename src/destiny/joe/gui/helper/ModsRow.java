package destiny.joe.gui.helper;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

public class ModsRow implements Observer {

    private Integer p5 = 0;
    private Integer p10 = 0;

    private final StatTotal stat;

    /**
     * [0]: stat. [1]: +5. [2]: +10.
     */
    private final Label[] labels;

    /**
     * [0]: +5. [1]: +10. [2]: clear.
     */
    private final Button[] buttons;

    public ModsRow(StatTotal stat, Label[] labels, Button[] buttons) {
        this.stat = stat;
        this.labels = labels;
        this.buttons = buttons;
        stat.addObserver(this);
        buttons[0].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                p5++;
                update(null, null);
            }
        });
        buttons[1].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                p10++;
                update(null, null);
            }
        });
        buttons[2].addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                clearMod();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer total = stat.getValue();

        for (int i = 0; i < p5; i++)
            total += 5;

        for (int i = 0; i < p10; i++)
            total += 10;

        labels[0].setText(total.toString());
        labels[1].setText(p5.toString());
        labels[2].setText(p10.toString());

        buttons[2].setEnabled(p5 + p10 != 0);
    }

    public void clearMod() {
        p5 = 0;
        p10 = 0;
        update(null, null);
    }

}