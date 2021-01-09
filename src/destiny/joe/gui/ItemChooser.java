package destiny.joe.gui;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
import destiny.joe.items.ItemsFactory;
import destiny.joe.items.Stat;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Type;
import destiny.joe.utils.FileReader;
import destiny.joe.utils.GUI;

public class ItemChooser extends Dialog {

    private final List<Item> items;

    private static Map<Character, Map<Type, List<Item>>> availableItems;
    static {
        try {
            availableItems = ItemsFactory.parseItems(new FileReader("destiny.csv", ",").read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Object result = Item.NULL;
    protected Shell shlChooseItem;
    private Table table;
    private TableColumn tblclmnTier;
    private TableColumn tblclmnType;
    private TableColumn tblclmnStat;
    private TableColumn tblclmnStat_1;
    private TableColumn tblclmnStat_2;
    private TableColumn tblclmnStat_3;
    private TableColumn tblclmnStat_4;
    private TableColumn tblclmnStat_5;
    private Group grpFilter;
    private Button btnSearch;
    private Combo comboTier;
    private Combo comboType;
    private Label lblAtLeast;
    private Label lblStat;
    private Label lblStat_1;
    private Label lblStat_2;
    private Label lblStat_3;
    private Label lblStat_4;
    private Label lblStat_5;
    private Text textStat;
    private Text text;
    private Text text_1;
    private Text text_2;
    private Text text_3;
    private Text text_4;

    /**
     * Create the dialog.
     * 
     * @param parent
     * @param style
     */
    public ItemChooser(Shell parent, int style, Type type, Character character) {
        super(parent, style);
        items = availableItems.get(character).get(type);
        setText("SWT Dialog");
    }

    /**
     * Open the dialog.
     * 
     * @return the result
     */
    public Object open() {
        createContents();
        /* CUSTOM CODE: START */
        GUI.shellCenter(getParent().getDisplay(), shlChooseItem);
        /* CUSTOM CODE: END */
        shlChooseItem.setLayout(new GridLayout(1, false));

        table = new Table(shlChooseItem, SWT.BORDER | SWT.FULL_SELECTION);
        // https://stackoverflow.com/questions/18966169/showing-a-right-click-menu-for-a-swt-tableitem
        table.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event event) {
                int index = table.getSelectionIndex();
                if (index == -1)
                    return; // no row selected

                TableItem item = table.getItem(index);
                result = item.getText();
                shlChooseItem.dispose();
            }

        });

        GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        gd_table.heightHint = 347;
        table.setLayoutData(gd_table);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn tblclmnName = new TableColumn(table, SWT.LEFT);
        tblclmnName.setResizable(false);
        tblclmnName.setWidth(205);
        tblclmnName.setText("Name");

        tblclmnTier = new TableColumn(table, SWT.NONE);
        tblclmnTier.setResizable(false);
        tblclmnTier.setWidth(75);
        tblclmnTier.setText("Tier");

        tblclmnType = new TableColumn(table, SWT.NONE);
        tblclmnType.setResizable(false);
        tblclmnType.setWidth(55);
        tblclmnType.setText("Type");

        tblclmnStat = new TableColumn(table, SWT.CENTER);
        tblclmnStat.setToolTipText("Mobility");
        tblclmnStat.setImage(GUI.loadImage(getParent().getDisplay(), "mobility.png"));
        tblclmnStat.setResizable(false);
        tblclmnStat.setWidth(26);

        tblclmnStat_1 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_1.setToolTipText("Resilience");
        tblclmnStat_1.setImage(GUI.loadImage(getParent().getDisplay(), "resiliance.png"));
        tblclmnStat_1.setResizable(false);
        tblclmnStat_1.setWidth(26);

        tblclmnStat_2 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_2.setToolTipText("Recovery");
        tblclmnStat_2.setImage(GUI.loadImage(getParent().getDisplay(), "recovery.png"));
        tblclmnStat_2.setResizable(false);
        tblclmnStat_2.setWidth(26);

        tblclmnStat_3 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_3.setToolTipText("Discipline");
        tblclmnStat_3.setImage(GUI.loadImage(getParent().getDisplay(), "discipline.png"));
        tblclmnStat_3.setResizable(false);
        tblclmnStat_3.setWidth(26);

        tblclmnStat_4 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_4.setToolTipText("Intellect");
        tblclmnStat_4.setImage(GUI.loadImage(getParent().getDisplay(), "intellect.png"));
        tblclmnStat_4.setResizable(false);
        tblclmnStat_4.setWidth(26);

        tblclmnStat_5 = new TableColumn(table, SWT.CENTER);
        tblclmnStat_5.setToolTipText("Strength");
        tblclmnStat_5.setImage(GUI.loadImage(getParent().getDisplay(), "strength.png"));
        tblclmnStat_5.setResizable(false);
        tblclmnStat_5.setWidth(26);

        /* CUSTOM CODE: START */
        for (Item i : items)
            addTableEntry(i);
        /* CUSTOM CODE: END */

        grpFilter = new Group(shlChooseItem, SWT.NONE);
        grpFilter.setLayout(new GridLayout(14, false));
        GridData gd_grpFilter = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_grpFilter.widthHint = 486;
        grpFilter.setLayoutData(gd_grpFilter);
        grpFilter.setText("Filter");
        new Label(grpFilter, SWT.NONE);
        new Label(grpFilter, SWT.NONE);
        new Label(grpFilter, SWT.NONE);
        new Label(grpFilter, SWT.NONE);
        new Label(grpFilter, SWT.NONE);
        new Label(grpFilter, SWT.NONE);

        lblStat = new Label(grpFilter, SWT.NONE);
        lblStat.setToolTipText("Mobility");
        lblStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat.setImage(GUI.loadImage(getParent().getDisplay(), "mobility.png"));

        lblStat_1 = new Label(grpFilter, SWT.NONE);
        lblStat_1.setToolTipText("Resilience");
        lblStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_1.setImage(GUI.loadImage(getParent().getDisplay(), "resiliance.png"));

        lblStat_2 = new Label(grpFilter, SWT.NONE);
        lblStat_2.setToolTipText("Recovery");
        lblStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_2.setImage(GUI.loadImage(getParent().getDisplay(), "recovery.png"));

        lblStat_3 = new Label(grpFilter, SWT.NONE);
        lblStat_3.setToolTipText("Discipline");
        lblStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_3.setImage(GUI.loadImage(getParent().getDisplay(), "discipline.png"));

        lblStat_4 = new Label(grpFilter, SWT.NONE);
        lblStat_4.setToolTipText("Intellect");
        lblStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_4.setImage(GUI.loadImage(getParent().getDisplay(), "intellect.png"));

        lblStat_5 = new Label(grpFilter, SWT.NONE);
        lblStat_5.setToolTipText("Strength");
        lblStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStat_5.setImage(GUI.loadImage(getParent().getDisplay(), "strength.png"));
        new Label(grpFilter, SWT.NONE);
        new Label(grpFilter, SWT.NONE);

        comboTier = new Combo(grpFilter, SWT.NONE);
        comboTier.setItems(new String[] { "Any", "Rare", "Legendary", "Exotic" });
        comboTier.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        comboTier.setText("Tier");
        new Label(grpFilter, SWT.NONE);

        comboType = new Combo(grpFilter, SWT.NONE);
        comboType.setItems(new String[] { "Any", "Arc", "Solar", "Void" });
        comboType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        comboType.setText("Type");
        new Label(grpFilter, SWT.NONE);

        lblAtLeast = new Label(grpFilter, SWT.NONE);
        lblAtLeast.setText("At least:");
        new Label(grpFilter, SWT.NONE);

        textStat = new Text(grpFilter, SWT.BORDER);
        textStat.setText("00");
        textStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));

        text = new Text(grpFilter, SWT.BORDER);
        text.setText("00");
        text.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));

        text_1 = new Text(grpFilter, SWT.BORDER);
        text_1.setText("00");
        text_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));

        text_2 = new Text(grpFilter, SWT.BORDER);
        text_2.setText("00");
        text_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));

        text_3 = new Text(grpFilter, SWT.BORDER);
        text_3.setText("00");
        text_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));

        text_4 = new Text(grpFilter, SWT.BORDER);
        text_4.setText("00");
        text_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        new Label(grpFilter, SWT.NONE);

        btnSearch = new Button(grpFilter, SWT.NONE);
        btnSearch.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
        btnSearch.setText("Search");

        shlChooseItem.open();
        shlChooseItem.layout();
        Display display = getParent().getDisplay();
        while (!shlChooseItem.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        return result;
    }

    // http://www.java2s.com/Code/Java/SWT-JFace-Eclipse/CreateaSWTtablecolumnsheaderslines.htm
    private void addTableEntry(Item i) {
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
    }

    /**
     * Create contents of the dialog.
     */
    private void createContents() {
        shlChooseItem = new Shell(getParent(), getStyle());
        shlChooseItem.setMinimumSize(new Point(540, 470));
        shlChooseItem.setImage(GUI.loadImage(getParent().getDisplay(), "destiny-2.ico"));
        shlChooseItem.setSize(434, 230);
        shlChooseItem.setText("Choose an item");

    }
}
