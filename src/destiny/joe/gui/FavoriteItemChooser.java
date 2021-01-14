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
import org.eclipse.wb.swt.SWTResourceManager;

import destiny.joe.items.Item;
import destiny.joe.items.ItemComparator;
import destiny.joe.items.ItemsManager;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.ItemProperty.Categorial;
import destiny.joe.items.enums.Type;

public class FavoriteItemChooser extends ItemChooser {

    private Combo comboItemType;
    private final int columnWidth = 68;

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
        super.addTableEntry(i);
        TableItem tableItem = table.getItems()[table.getItemCount() - 1];
        tableItem.setText(11, i.type.getFirstString());
        tableItem.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
    }

    @Override
    boolean toBeFiltered(Item item) {

        if (comboItemType == null)
            return super.toBeFiltered(item);

        Type filterType = (Type) Categorial.identify(comboItemType.getText(), Type.NULL);
        if (filterType != Type.NULL && filterType != item.type)
            return true;

        return super.toBeFiltered(item);
    }

    @Override
    void createContents() {
        super.createContents();
        shlChooseItem.setText("Favorite items (" + character.getString() + ")");

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
