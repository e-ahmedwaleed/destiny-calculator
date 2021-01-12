package destiny.joe.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import destiny.joe.items.Item;
import destiny.joe.items.ItemComparator;
import destiny.joe.items.ItemsManager;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.ItemProperty.Column;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Type;

public class FavoriteItemChooser extends ItemChooser {

    private Combo comboItemType;
    private final int columnWidth = 64;

    public FavoriteItemChooser(Shell parent, int style, Character character) {
        super(parent, style, Type.NULL, character);
    }

    @Override
    void intializeItemList() {
        items = ItemsManager.getFavorites(character);
        items.sort(new ItemComparator(null));
        items.sort(new ItemComparator(Type.NULL));
    }

    @Override
    void addTableEntry(Item i) {
        TableItem tableItem = new TableItem(table, SWT.NONE);
        tableItem.setText(0, i.name);
        tableItem.setText(1, i.tier.getString());
        tableItem.setText(2, i.masterWork.getFirstString());
        tableItem.setText(3, i.stats.get(Stat.MOBILITY).toString());
        tableItem.setText(4, i.stats.get(Stat.RESILIENCE).toString());
        tableItem.setText(5, i.stats.get(Stat.RECOVERY).toString());
        tableItem.setText(6, i.stats.get(Stat.DISCIPLINE).toString());
        tableItem.setText(7, i.stats.get(Stat.INTELLECT).toString());
        tableItem.setText(8, i.stats.get(Stat.STRENGTH).toString());
        tableItem.setText(9, i.stats.get(Stat.MASTER_WORK).toString());
        tableItem.setText(10, i.type.getFirstString());
    }

    @Override
    boolean toBeFiltered(Item item) {

        if (comboItemType == null)
            return super.toBeFiltered(item);

        Type filterType = (Type) Column.identifyColumn(comboItemType.getText(), Type.NULL);
        if (filterType != Type.NULL && filterType != item.type)
            return true;

        return super.toBeFiltered(item);
    }

    @Override
    void createContents() {
        super.createContents();
        shlChooseItem.setText("Favorite items (" + character.getString() +")");

        Point size = shlChooseItem.getSize();
        size.x += columnWidth;
        shlChooseItem.setSize(size);
    }

    @Override
    void intializeColumns() {
        super.intializeColumns();
        TableColumn itemType = new TableColumn(table, SWT.LEFT);
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
    void intializeSearch(int extra) {
        super.intializeSearch(2);
        new Label(grpSearch, SWT.NONE);
        comboItemType = new Combo(grpSearch, SWT.NONE);
        comboItemType.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (contained(comboItemType.getText(), comboItemType.getItems()))
                    filterTable();
            }
        });
        comboItemType.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (comboItemType.getText().contains("Any"))
                    comboItemType.setText("Item");
            }
        });
        comboItemType.setItems(new String[] { "Any", "Helmet", "Gauntlets", "Chest", "Leg" });
        comboItemType.setText("Item");
        comboItemType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
    }

}
