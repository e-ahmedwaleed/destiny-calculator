package destiny.joe.gui;

import java.util.Comparator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import destiny.joe.items.Item;
import destiny.joe.items.ItemComparator;
import destiny.joe.items.ItemsManager;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.ItemProperty.Column;
import destiny.joe.items.enums.MasterWork;
import destiny.joe.items.enums.Stat;
import destiny.joe.items.enums.Tier;
import destiny.joe.items.enums.Type;
import destiny.joe.utils.GUI;

public class ItemChooser extends Dialog {

    List<Item> items;

    final Character character;

    Table table;
    Shell shlChooseItem;
    Group grpSearch;

    private final Type type;
    private Item result = null;
    private TableColumn tblclmnName;
    private TableColumn tblclmnTier;
    private TableColumn tblclmnType;
    private TableColumn tblclmnStat;
    private TableColumn tblclmnStat_1;
    private TableColumn tblclmnStat_2;
    private TableColumn tblclmnStat_3;
    private TableColumn tblclmnStat_4;
    private TableColumn tblclmnStat_5;
    private Combo comboTier;
    private Combo comboType;
    private Label lblStat;
    private Label lblStat_1;
    private Label lblStat_2;
    private Label lblStat_3;
    private Label lblStat_4;
    private Label lblStat_5;
    private Text textStat;
    private Text textStat_1;
    private Text textStat_2;
    private Text textStat_3;
    private Text textStat_4;
    private Text textStat_5;
    private Text txtItemName;
    private TableColumn tblclmnMWTier;

    /**
     * Create the dialog.
     * 
     * @param parent
     * @param style
     */
    public ItemChooser(Shell parent, int style, Type type, Character character) {
        super(parent, style);
        this.type = type;
        this.character = character;
        intializeItemList();
    }

    public void close() {
        shlChooseItem.dispose();
    }

    /**
     * Open the dialog.
     * 
     * @return the result
     */
    public Item open() {
        createContents();
        shlChooseItem.setLayout(new GridLayout(1, false));

        table = new Table(shlChooseItem, SWT.BORDER | SWT.FULL_SELECTION);
        // https://stackoverflow.com/questions/18966169/showing-a-right-click-menu-for-a-swt-tableitem
        table.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event event) {
                int index = table.getSelectionIndex();
                if (index == -1)
                    return; // no row selected

                result = items.get(index);
                close();
            }

        });

        intializeColumns();
        intializeSearch(0);

        Display display = getParent().getDisplay();

        /* CUSTOM CODE: START */
        populateTable();
        for (TableColumn tableColumn : table.getColumns())
            GUI.scaleColumnDisplay(display, tableColumn);
        GUI.scaleWindowDisplay(display, shlChooseItem);
        GUI.shellCenter(display, shlChooseItem);
        /* CUSTOM CODE: END */

        shlChooseItem.open();
        shlChooseItem.layout();
        while (!shlChooseItem.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        return result;
    }

    void intializeItemList() {
        items = ItemsManager.getItems(type, character);
        items.sort(new ItemComparator(null));
    }

    void createContents() {
        shlChooseItem = new Shell(getParent(), getStyle());
        shlChooseItem.setMinimumSize(new Point(544, 470));
        shlChooseItem.setImage(GUI.loadImage(getParent().getDisplay(), "destiny-2.ico"));
        shlChooseItem.setSize(544, 470);
        shlChooseItem.setText("Choose " + type.getString() + " (" + character.getString() + ")");
    }

    void intializeColumns() {

        GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        gd_table.heightHint = 347;
        table.setLayoutData(gd_table);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        tblclmnName = new TableColumn(table, SWT.LEFT);
        tblclmnName.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(null));
            }
        });
        tblclmnName.setResizable(false);
        tblclmnName.setWidth(200);
        tblclmnName.setText("Name");

        tblclmnTier = new TableColumn(table, SWT.LEFT);
        tblclmnTier.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Tier.NULL));
            }
        });
        tblclmnTier.setResizable(false);
        tblclmnTier.setWidth(70);
        tblclmnTier.setText("Tier");

        tblclmnType = new TableColumn(table, SWT.LEFT);
        tblclmnType.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(MasterWork.NULL));
            }
        });
        tblclmnType.setResizable(false);
        tblclmnType.setWidth(45);
        tblclmnType.setText("Type");

        tblclmnStat = new TableColumn(table, SWT.CENTER);
        tblclmnStat.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Stat.MOBILITY));
            }
        });
        tblclmnStat.setToolTipText("Mobility");
        tblclmnStat.setImage(GUI.loadImage(getParent().getDisplay(), "mobility.png"));
        tblclmnStat.setResizable(false);
        tblclmnStat.setWidth(26);

        tblclmnStat_1 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Stat.RESILIENCE));
            }
        });
        tblclmnStat_1.setToolTipText("Resilience");
        tblclmnStat_1.setImage(GUI.loadImage(getParent().getDisplay(), "resiliance.png"));
        tblclmnStat_1.setResizable(false);
        tblclmnStat_1.setWidth(26);

        tblclmnStat_2 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Stat.RECOVERY));
            }
        });
        tblclmnStat_2.setToolTipText("Recovery");
        tblclmnStat_2.setImage(GUI.loadImage(getParent().getDisplay(), "recovery.png"));
        tblclmnStat_2.setResizable(false);
        tblclmnStat_2.setWidth(26);

        tblclmnStat_3 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Stat.DISCIPLINE));
            }
        });
        tblclmnStat_3.setToolTipText("Discipline");
        tblclmnStat_3.setImage(GUI.loadImage(getParent().getDisplay(), "discipline.png"));
        tblclmnStat_3.setResizable(false);
        tblclmnStat_3.setWidth(26);

        tblclmnStat_4 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_4.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Stat.INTELLECT));
            }
        });
        tblclmnStat_4.setToolTipText("Intellect");
        tblclmnStat_4.setImage(GUI.loadImage(getParent().getDisplay(), "intellect.png"));
        tblclmnStat_4.setResizable(false);
        tblclmnStat_4.setWidth(26);

        tblclmnStat_5 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_5.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Stat.STRENGTH));
            }
        });
        tblclmnStat_5.setToolTipText("Strength");
        tblclmnStat_5.setImage(GUI.loadImage(getParent().getDisplay(), "strength.png"));
        tblclmnStat_5.setResizable(false);
        tblclmnStat_5.setWidth(26);

        tblclmnMWTier = new TableColumn(table, SWT.CENTER);
        tblclmnMWTier.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                resortTable(new ItemComparator(Stat.MASTER_WORK));
            }
        });
        tblclmnMWTier.setToolTipText("Masterwork Tier");
        tblclmnMWTier.setResizable(false);
        tblclmnMWTier.setWidth(26);
        tblclmnMWTier.setText("M");
    }

    void resortTable(Comparator<Item> comparator) {
        items.sort(comparator);
        populateTable();
    }

    void intializeSearch(int extra) {
        grpSearch = new Group(shlChooseItem, SWT.NONE);
        grpSearch.setLayout(new GridLayout(12 + extra, false));
        GridData gd_grpSearch = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_grpSearch.widthHint = 486;
        grpSearch.setLayoutData(gd_grpSearch);
        grpSearch.setText("Search");
        new Label(grpSearch, SWT.NONE);
        new Label(grpSearch, SWT.NONE);
        new Label(grpSearch, SWT.NONE);
        new Label(grpSearch, SWT.NONE);
        new Label(grpSearch, SWT.NONE);
        new Label(grpSearch, SWT.NONE);

        lblStat = new Label(grpSearch, SWT.NONE);
        lblStat.setAlignment(SWT.CENTER);
        lblStat.setToolTipText("Mobility");
        lblStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat.setImage(GUI.loadImage(getParent().getDisplay(), "mobility.png"));

        lblStat_1 = new Label(grpSearch, SWT.NONE);
        lblStat_1.setAlignment(SWT.CENTER);
        lblStat_1.setToolTipText("Resilience");
        lblStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_1.setImage(GUI.loadImage(getParent().getDisplay(), "resiliance.png"));

        lblStat_2 = new Label(grpSearch, SWT.NONE);
        lblStat_2.setAlignment(SWT.CENTER);
        lblStat_2.setToolTipText("Recovery");
        lblStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_2.setImage(GUI.loadImage(getParent().getDisplay(), "recovery.png"));

        lblStat_3 = new Label(grpSearch, SWT.NONE);
        lblStat_3.setAlignment(SWT.CENTER);
        lblStat_3.setToolTipText("Discipline");
        lblStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_3.setImage(GUI.loadImage(getParent().getDisplay(), "discipline.png"));

        lblStat_4 = new Label(grpSearch, SWT.NONE);
        lblStat_4.setAlignment(SWT.CENTER);
        lblStat_4.setToolTipText("Intellect");
        lblStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_4.setImage(GUI.loadImage(getParent().getDisplay(), "intellect.png"));

        lblStat_5 = new Label(grpSearch, SWT.NONE);
        lblStat_5.setAlignment(SWT.CENTER);
        lblStat_5.setToolTipText("Strength");
        lblStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_5.setImage(GUI.loadImage(getParent().getDisplay(), "strength.png"));

        for (int i = 0; i < extra; i++)
            new Label(grpSearch, SWT.NONE);

        txtItemName = new Text(grpSearch, SWT.BORDER);
        txtItemName.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (txtItemName.getText().isEmpty() || txtItemName.getText().contains("Item name"))
                    return;
                filterTable();
            }
        });
        txtItemName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                txtItemName.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtItemName.getText().isEmpty()) {
                    txtItemName.setText("Item name");
                    filterTable();
                }
            }
        });
        txtItemName.setText("Item name");
        txtItemName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(grpSearch, SWT.NONE);

        comboTier = new Combo(grpSearch, SWT.NONE);
        comboTier.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (contained(comboTier.getText(), comboTier.getItems()))
                    filterTable();
            }
        });
        comboTier.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (comboTier.getText().contains("Any"))
                    comboTier.setText("Tier");
            }
        });
        comboTier.setItems(new String[] { "Any", "Exotic", "Legendary", "Rare" });
        comboTier.setText("Tier");
        new Label(grpSearch, SWT.NONE);

        comboType = new Combo(grpSearch, SWT.NONE);
        comboType.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (contained(comboType.getText(), comboType.getItems()))
                    filterTable();
            }
        });
        comboType.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (comboType.getText().contains("Any"))
                    comboType.setText("Type");
            }
        });
        comboType.setItems(new String[] { "Any", "Arc", "Solar", "Void" });
        comboType.setText("Type");
        new Label(grpSearch, SWT.NONE);

        textStat = new Text(grpSearch, SWT.BORDER | SWT.CENTER);
        textStat.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (!textStat.getText().isEmpty() && parseInt(textStat) > -1)
                    filterTable();
            }
        });
        textStat.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textStat.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textStat.getText().isEmpty())
                    textStat.setText("00");
            }
        });
        textStat.setText("00");
        textStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        textStat_1 = new Text(grpSearch, SWT.BORDER | SWT.CENTER);
        textStat_1.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (!textStat_1.getText().isEmpty() && parseInt(textStat_1) > -1)
                    filterTable();
            }
        });
        textStat_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textStat_1.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textStat_1.getText().isEmpty())
                    textStat_1.setText("00");
            }
        });
        textStat_1.setText("00");
        textStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        textStat_2 = new Text(grpSearch, SWT.BORDER | SWT.CENTER);
        textStat_2.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (!textStat_2.getText().isEmpty() && parseInt(textStat_2) > -1)
                    filterTable();
            }
        });
        textStat_2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textStat_2.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textStat_2.getText().isEmpty())
                    textStat_2.setText("00");
            }
        });
        textStat_2.setText("00");
        textStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        textStat_3 = new Text(grpSearch, SWT.BORDER | SWT.CENTER);
        textStat_3.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (!textStat_3.getText().isEmpty() && parseInt(textStat_3) > -1)
                    filterTable();
            }
        });
        textStat_3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textStat_3.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textStat_3.getText().isEmpty())
                    textStat_3.setText("00");
            }
        });
        textStat_3.setText("00");
        textStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        textStat_4 = new Text(grpSearch, SWT.BORDER | SWT.CENTER);
        textStat_4.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (!textStat_4.getText().isEmpty() && parseInt(textStat_4) > -1)
                    filterTable();
            }
        });
        textStat_4.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textStat_4.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textStat_4.getText().isEmpty())
                    textStat_4.setText("00");
            }
        });
        textStat_4.setText("00");
        textStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        textStat_5 = new Text(grpSearch, SWT.BORDER | SWT.CENTER);
        textStat_5.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (!textStat_5.getText().isEmpty() && parseInt(textStat_5) > -1)
                    filterTable();
            }
        });
        textStat_5.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textStat_5.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textStat_5.getText().isEmpty())
                    textStat_5.setText("00");
            }
        });
        textStat_5.setText("00");
        textStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
    }

    // http://www.java2s.com/Code/Java/SWT-JFace-Eclipse/CreateaSWTtablecolumnsheaderslines.htm
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
    }

    void filterTable() {
        intializeItemList();

        for (int i = items.size() - 1; i >= 0; i--)
            if (toBeFiltered(items.get(i)))
                items.remove(i);

        populateTable();
    }

    boolean toBeFiltered(Item item) {

        if (!txtItemName.getText().equals("Item name")
                && !item.name.toLowerCase().contains(txtItemName.getText().toLowerCase()))
            return true;

        MasterWork filterType = (MasterWork) Column.identifyColumn(comboType.getText(), MasterWork.NULL);
        if (filterType != MasterWork.NULL && filterType != item.masterWork)
            return true;

        Tier filterTier = (Tier) Column.identifyColumn(comboTier.getText(), Tier.NULL);
        if (filterTier != Tier.NULL && filterTier != item.tier)
            return true;

        int[] stats = { parseInt(textStat), parseInt(textStat_1), parseInt(textStat_2), parseInt(textStat_3),
                parseInt(textStat_4), parseInt(textStat_5) };
        for (Stat s : Stat.values())
            if (s != Stat.NULL && s != Stat.MASTER_WORK && item.stats.get(s) < stats[s.ordinal() - 1])
                return true;

        return false;
    }

    boolean contained(String s, String[] arr) {
        for (String a : arr)
            if (a.equals(s))
                return true;
        return false;
    }

    private void populateTable() {
        table.removeAll();
        for (Item i : items)
            addTableEntry(i);
    }

    private int parseInt(Text textbox) {

        int i = -1;

        if (textbox == null)
            return i;

        try {
            i = Integer.parseInt(textbox.getText());
            if (i > 100)
                throw new Exception("Out of bounds!");
        } catch (Exception e) {
            i = -1;
            textbox.setText("00");
        }
        return i;
    }

}
