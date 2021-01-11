package destiny.joe.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import destiny.joe.items.Item;
import destiny.joe.items.ItemComparator;
import destiny.joe.items.ItemsFactory;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Type;

public class FavoriteItemChooser extends ItemChooser {

    private TableColumn itemType;
    private final int columnWidth = 64;

    public FavoriteItemChooser(Shell parent, int style, Character character) {
        super(parent, style, Type.NULL, character);
    }

    @Override
    void intializeItemList() {
        items = ItemsFactory.getFavorites(character);
        items.sort(new ItemComparator(null));
        items.sort(new ItemComparator(Type.NULL));
    }

    @Override
    void addTableEntry(Item i) {
        TableItem tableItem = new TableItem(table, SWT.NONE);
        tableItem.setText(0, i.name);
        tableItem.setText(1, i.tier.getString());
        tableItem.setText(2, i.masterWork.type);
        tableItem.setText(3, i.stats.get(Stat.MOBILITY).toString());
        tableItem.setText(4, i.stats.get(Stat.RESILIENCE).toString());
        tableItem.setText(5, i.stats.get(Stat.RECOVERY).toString());
        tableItem.setText(6, i.stats.get(Stat.DISCIPLINE).toString());
        tableItem.setText(7, i.stats.get(Stat.INTELLECT).toString());
        tableItem.setText(8, i.stats.get(Stat.STRENGTH).toString());
        tableItem.setText(9, i.stats.get(Stat.MASTER_WORK).toString());
        tableItem.setText(10, i.type.getString().split(" ")[0]);
    }

    @Override
    void intializeColumns() {
        super.intializeColumns();
        itemType = new TableColumn(table, SWT.LEFT);
        itemType.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Type.NULL));
            }
        });
        itemType.setResizable(false);
        itemType.setWidth(columnWidth);
        itemType.setText("");
    }

    @Override
    void createContents() {
        super.createContents();
        shlChooseItem.setText("Choose an item");

        Point size = shlChooseItem.getSize();
        size.x += columnWidth;
        shlChooseItem.setSize(size);
    }
}
