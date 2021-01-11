package destiny.joe.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import destiny.joe.gui.helper.ItemPickerRow;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Column;
import destiny.joe.items.enums.Type;
import destiny.joe.utils.GUI;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class MainWindow {

    private static ItemPickerRow helmet;
    private static ItemPickerRow gauntlets;
    private static ItemPickerRow chest;
    private static ItemPickerRow leg;
    private static Character selectedChar = Character.NULL;

    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Display display = Display.getDefault();
        // https://www.eclipse.org/forums/index.php/t/146112/
        Shell shlDestinyCalculator = new Shell(SWT.CLOSE | SWT.MIN);
        shlDestinyCalculator.setMinimumSize(new Point(650, 560));
        shlDestinyCalculator.setImage(GUI.loadImage(display, "destiny-2.ico"));
        shlDestinyCalculator.setSize(640, 560);
        shlDestinyCalculator.setText("Destiny Calculator");
        shlDestinyCalculator.setLayout(new FormLayout());

        Group grpItemPicker = new Group(shlDestinyCalculator, SWT.NONE);
        grpItemPicker.setEnabled(false);
        FormData fd_grpItemPicker = new FormData();
        fd_grpItemPicker.top = new FormAttachment(0, 10);
        fd_grpItemPicker.left = new FormAttachment(0, 10);
        grpItemPicker.setLayoutData(fd_grpItemPicker);
        grpItemPicker.setText("Item Picker");
        grpItemPicker.setLayout(new GridLayout(16, false));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblMob = new Label(grpItemPicker, SWT.NONE);
        lblMob.setToolTipText("Mobility");
        lblMob.setImage(GUI.loadImage(display, "mobility.png"));
        lblMob.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblMob.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblRes = new Label(grpItemPicker, SWT.NONE);
        lblRes.setToolTipText("Resilience");
        lblRes.setImage(GUI.loadImage(display, "resiliance.png"));
        lblRes.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblRec = new Label(grpItemPicker, SWT.NONE);
        lblRec.setToolTipText("Recovery");
        lblRec.setImage(GUI.loadImage(display, "recovery.png"));
        lblRec.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblRec.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblDis = new Label(grpItemPicker, SWT.NONE);
        lblDis.setToolTipText("Discipline");
        lblDis.setImage(GUI.loadImage(display, "discipline.png"));
        lblDis.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblDis.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblInt = new Label(grpItemPicker, SWT.NONE);
        lblInt.setToolTipText("Intellect");
        lblInt.setImage(GUI.loadImage(display, "intellect.png"));
        lblInt.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblInt.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblStr = new Label(grpItemPicker, SWT.NONE);
        lblStr.setToolTipText("Strength");
        lblStr.setImage(GUI.loadImage(display, "strength.png"));
        lblStr.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblStr.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label v_bar = new Label(grpItemPicker, SWT.SEPARATOR | SWT.VERTICAL);
        GridData gd_v_bar = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_v_bar.heightHint = 14;
        v_bar.setLayoutData(gd_v_bar);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label vLine_0 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_0.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        Label lblHelmet = new Label(grpItemPicker, SWT.NONE);
        lblHelmet.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        lblHelmet.setText("Helmet");

        Label lblHelmetName = new Label(grpItemPicker, SWT.NONE);
        lblHelmetName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        lblHelmetName.setText("Item name");

        Button btnHelmet = new Button(grpItemPicker, SWT.NONE);
        btnHelmet.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                helmet.pickItem(shlDestinyCalculator, selectedChar);
            }
        });
        btnHelmet.setToolTipText("Choose item.");
        btnHelmet.setText("C");

        Label lblHelmetStat = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat.setText("00");
        lblHelmetStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_1.setText("00");
        lblHelmetStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_2.setText("00");
        lblHelmetStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_3.setText("00");
        lblHelmetStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_4.setText("00");
        lblHelmetStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_5.setText("00");
        lblHelmetStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_6.setText("000");
        lblHelmetStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetMW = new Label(grpItemPicker, SWT.NONE);
        lblHelmetMW.setToolTipText("Masterwork Type");
        lblHelmetMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblHelmetMW.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.BOLD));
        lblHelmetMW.setText("Solar");

        Button btnHelmetClear = new Button(grpItemPicker, SWT.NONE);
        btnHelmetClear.setEnabled(false);
        btnHelmetClear.setToolTipText("Clear item.");
        btnHelmetClear.setText("x");
        btnHelmetClear.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetTier_1 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetTier_1.setText("Tier: ");

        Label lblHelmetTier = new Label(grpItemPicker, SWT.NONE);
        lblHelmetTier.setText("Legendary");
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetStatMW = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW.setText("02");
        lblHelmetStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW.setEnabled(false);

        Label lblHelmetStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_1.setText("02");
        lblHelmetStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_1.setEnabled(false);

        Label lblHelmetStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_2.setText("02");
        lblHelmetStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_2.setEnabled(false);

        Label lblHelmetStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_3.setText("02");
        lblHelmetStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_3.setEnabled(false);

        Label lblHelmetStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_4.setText("02");
        lblHelmetStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_4.setEnabled(false);

        Label lblHelmetStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_5.setText("02");
        lblHelmetStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_5.setEnabled(false);
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_6.setText("012");
        lblHelmetStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_6.setEnabled(false);

        Button chkBtnHelmetMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnHelmetMW.setToolTipText("+2 for each stat.");

        Label lblHelmetMWTier = new Label(grpItemPicker, SWT.NONE);
        lblHelmetMWTier.setToolTipText("Masterwork Tier");
        lblHelmetMWTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblHelmetMWTier.setText("0 / 10");
        lblHelmetMWTier.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label vLine_1 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        Label lblGauntlets = new Label(grpItemPicker, SWT.NONE);
        lblGauntlets.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        lblGauntlets.setText("Gauntlets");

        Label lblGauntletsName = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        lblGauntletsName.setText("Item name");

        Button btnGauntlets = new Button(grpItemPicker, SWT.NONE);
        btnGauntlets.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                gauntlets.pickItem(shlDestinyCalculator, selectedChar);
            }
        });
        btnGauntlets.setToolTipText("Choose item.");
        btnGauntlets.setText("C");

        Label lblGauntletsStat = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat.setText("00");
        lblGauntletsStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_1.setText("00");
        lblGauntletsStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_2.setText("00");
        lblGauntletsStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_3.setText("00");
        lblGauntletsStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_4.setText("00");
        lblGauntletsStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_5.setText("00");
        lblGauntletsStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_6.setText("000");
        lblGauntletsStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsMW = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsMW.setToolTipText("Masterwork Type");
        lblGauntletsMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblGauntletsMW.setText("Solar");
        lblGauntletsMW.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.BOLD));

        Button btnGauntletsClear = new Button(grpItemPicker, SWT.NONE);
        btnGauntletsClear.setEnabled(false);
        btnGauntletsClear.setToolTipText("Clear item.");
        btnGauntletsClear.setText("x");
        btnGauntletsClear.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblTier_1 = new Label(grpItemPicker, SWT.NONE);
        lblTier_1.setText("Tier: ");

        Label lblGauntletsTier = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsTier.setText("Legendary");
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsStatMW = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW.setText("02");
        lblGauntletsStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW.setEnabled(false);

        Label lblGauntletsStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_1.setText("02");
        lblGauntletsStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_1.setEnabled(false);

        Label lblGauntletsStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_2.setText("02");
        lblGauntletsStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_2.setEnabled(false);

        Label lblGauntletsStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_3.setText("02");
        lblGauntletsStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_3.setEnabled(false);

        Label lblGauntletsStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_4.setText("02");
        lblGauntletsStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_4.setEnabled(false);

        Label lblGauntletsStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_5.setText("02");
        lblGauntletsStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_5.setEnabled(false);
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_6.setText("012");
        lblGauntletsStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_6.setEnabled(false);

        Button chkBtnGauntletsMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnGauntletsMW.setToolTipText("+2 for each stat.");

        Label lblGauntletsMWTier = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsMWTier.setToolTipText("Masterwork Tier");
        lblGauntletsMWTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblGauntletsMWTier.setText("0 / 10");
        lblGauntletsMWTier.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label vLine_2 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        Label lblChest = new Label(grpItemPicker, SWT.NONE);
        lblChest.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        lblChest.setText("Chest");

        Label lblChestName = new Label(grpItemPicker, SWT.NONE);
        lblChestName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        lblChestName.setText("Item name");

        Button btnChest = new Button(grpItemPicker, SWT.NONE);
        btnChest.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                chest.pickItem(shlDestinyCalculator, selectedChar);
            }
        });
        btnChest.setToolTipText("Choose item.");
        btnChest.setText("C");

        Label lblChestStat = new Label(grpItemPicker, SWT.NONE);
        lblChestStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat.setText("00");
        lblChestStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_1.setText("00");
        lblChestStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_2.setText("00");
        lblChestStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_3.setText("00");
        lblChestStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_4.setText("00");
        lblChestStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_5.setText("00");
        lblChestStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_6.setText("000");
        lblChestStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestMW = new Label(grpItemPicker, SWT.NONE);
        lblChestMW.setToolTipText("Masterwork Type");
        lblChestMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblChestMW.setText("Solar");
        lblChestMW.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.BOLD));

        Button btnChestClear = new Button(grpItemPicker, SWT.NONE);
        btnChestClear.setEnabled(false);
        btnChestClear.setToolTipText("Clear item.");
        btnChestClear.setText("x");
        btnChestClear.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblTier_2 = new Label(grpItemPicker, SWT.NONE);
        lblTier_2.setText("Tier: ");

        Label lblChestTier = new Label(grpItemPicker, SWT.NONE);
        lblChestTier.setText("Legendary");
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestStatMW = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW.setText("02");
        lblChestStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW.setEnabled(false);

        Label lblChestStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_1.setText("02");
        lblChestStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_1.setEnabled(false);

        Label lblChestStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_2.setText("02");
        lblChestStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_2.setEnabled(false);

        Label lblChestStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_3.setText("02");
        lblChestStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_3.setEnabled(false);

        Label lblChestStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_4.setText("02");
        lblChestStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_4.setEnabled(false);

        Label lblChestStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_5.setText("02");
        lblChestStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_5.setEnabled(false);
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_6.setText("012");
        lblChestStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_6.setEnabled(false);

        Button chkBtnChestMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnChestMW.setToolTipText("+2 for each stat.");

        Label lblChestMWTier = new Label(grpItemPicker, SWT.NONE);
        lblChestMWTier.setToolTipText("Masterwork Tier");
        lblChestMWTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblChestMWTier.setText("0 / 10");
        lblChestMWTier.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label vLine_3 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        Label lblLeg = new Label(grpItemPicker, SWT.NONE);
        lblLeg.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        lblLeg.setText("Leg");

        Label lblLegName = new Label(grpItemPicker, SWT.NONE);
        lblLegName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        lblLegName.setText("Item name");

        Button btnLeg = new Button(grpItemPicker, SWT.NONE);
        btnLeg.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                leg.pickItem(shlDestinyCalculator, selectedChar);
            }
        });
        btnLeg.setToolTipText("Choose item.");
        btnLeg.setText("C");

        Label lblLegStat = new Label(grpItemPicker, SWT.NONE);
        lblLegStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat.setText("00");
        lblLegStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_1.setText("00");
        lblLegStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_2.setText("00");
        lblLegStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_3.setText("00");
        lblLegStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_4.setText("00");
        lblLegStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_5.setText("00");
        lblLegStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_6.setText("000");
        lblLegStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegMW = new Label(grpItemPicker, SWT.NONE);
        lblLegMW.setToolTipText("Masterwork Type");
        lblLegMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblLegMW.setText("Solar");
        lblLegMW.setFont(SWTResourceManager.getFont("Segoe UI", 7, SWT.BOLD));

        Button btnLegClear = new Button(grpItemPicker, SWT.NONE);
        btnLegClear.setEnabled(false);
        btnLegClear.setToolTipText("Clear item.");
        btnLegClear.setText("x");
        btnLegClear.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblTier_3 = new Label(grpItemPicker, SWT.NONE);
        lblTier_3.setText("Tier: ");

        Label lblLegTier = new Label(grpItemPicker, SWT.NONE);
        lblLegTier.setText("Legendary");
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegStatMW = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW.setText("02");
        lblLegStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW.setEnabled(false);

        Label lblLegStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_1.setText("02");
        lblLegStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_1.setEnabled(false);

        Label lblLegStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_2.setText("02");
        lblLegStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_2.setEnabled(false);

        Label lblLegStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_3.setText("02");
        lblLegStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_3.setEnabled(false);

        Label lblLegStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_4.setText("02");
        lblLegStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_4.setEnabled(false);

        Label lblLegStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_5.setText("02");
        lblLegStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_5.setEnabled(false);
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_6.setText("012");
        lblLegStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_6.setEnabled(false);

        Button chkBtnLegMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnLegMW.setToolTipText("+2 for each stat.");

        Label lblLegMWTier = new Label(grpItemPicker, SWT.NONE);
        lblLegMWTier.setToolTipText("Masterwork Tier");
        lblLegMWTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblLegMWTier.setText("0 / 10");
        lblLegMWTier.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label vLine_4 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        GridData gd_vLine_4 = new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1);
        gd_vLine_4.widthHint = 486;
        vLine_4.setLayoutData(gd_vLine_4);

        Label lblExtra = new Label(grpItemPicker, SWT.NONE);
        lblExtra.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        lblExtra.setText("Class");

        Label lblExtraName = new Label(grpItemPicker, SWT.NONE);
        lblExtraName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
        lblExtraName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
        lblExtraName.setText("Helm of the Emperor's Champion");
        new Label(grpItemPicker, SWT.NONE);

        Label lblExtraStatMW = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW.setText("2");

        Label lblExtraStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_1.setText("2");

        Label lblExtraStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_2.setText("2");

        Label lblExtraStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_3.setText("2");

        Label lblExtraStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_4.setText("2");

        Label lblExtraStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_5.setText("2");
        new Label(grpItemPicker, SWT.NONE);

        Label lblExtraStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_6.setText("12");
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Combo comboCharacter = new Combo(shlDestinyCalculator, SWT.NONE);
        comboCharacter.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                selectedChar = (Character) Column.identifyColumn(comboCharacter.getText(), Character.NULL);
                grpItemPicker.setEnabled(selectedChar != Character.NULL);
            }
        });
        fd_grpItemPicker.right = new FormAttachment(100, 100, -114);
        FormData fd_comboCharacter = new FormData();
        fd_comboCharacter.right = new FormAttachment(100, -10);
        fd_comboCharacter.left = new FormAttachment(grpItemPicker, 8);
        fd_comboCharacter.top = new FormAttachment(grpItemPicker, 0, SWT.TOP);
        comboCharacter.setLayoutData(fd_comboCharacter);
        comboCharacter.setItems(new String[] { "Hunter", "Titan", "Warlock" });
        comboCharacter.setText("Character");

        Label vLine_5 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        fd_grpItemPicker.bottom = new FormAttachment(100, -10);

        Group grpTotalStats = new Group(grpItemPicker, SWT.NONE);
        grpTotalStats.setText("Mods");
        grpTotalStats.setLayout(new GridLayout(9, false));
        GridData gd_grpTotalStats = new GridData(SWT.FILL, SWT.FILL, false, true, 5, 3);
        gd_grpTotalStats.heightHint = 180;
        gd_grpTotalStats.widthHint = 250;
        grpTotalStats.setLayoutData(gd_grpTotalStats);

        Label lblTotalStatTxt = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblTotalStatTxt.setText("Mobility");

        Label lblMob_1 = new Label(grpTotalStats, SWT.NONE);
        lblMob_1.setToolTipText("Mobility");
        lblMob_1.setImage(GUI.loadImage(display, "mobility.png"));
        lblMob_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStatTxt_ = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt_.setText(":");
        lblTotalStatTxt_.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStat = new Label(grpTotalStats, SWT.NONE);
        lblTotalStat.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
        lblTotalStat.setText("000");
        lblTotalStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Button btnAddMinorMod = new Button(grpTotalStats, SWT.NONE);
        btnAddMinorMod.setToolTipText("Add minor mobility mod.");
        btnAddMinorMod.setText("+5");
        btnAddMinorMod.setSize(new Point(100, 100));
        btnAddMinorMod.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblMinorModsCount = new Label(grpTotalStats, SWT.NONE);
        lblMinorModsCount.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblMinorModsCount.setText("0");
        lblMinorModsCount.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnAddMod = new Button(grpTotalStats, SWT.NONE);
        btnAddMod.setToolTipText("Add mobility mod.");
        btnAddMod.setText("+10");
        btnAddMod.setSize(new Point(100, 100));
        btnAddMod.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblBigModsCount = new Label(grpTotalStats, SWT.NONE);
        lblBigModsCount.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblBigModsCount.setText("0");
        lblBigModsCount.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnClearMods = new Button(grpTotalStats, SWT.NONE);
        btnClearMods.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
        btnClearMods.setToolTipText("Remove mobility mods.");
        btnClearMods.setText("x");
        btnClearMods.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblTotalStatTxt_1 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt_1.setText("Resilience");
        lblTotalStatTxt_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblRes_1 = new Label(grpTotalStats, SWT.NONE);
        lblRes_1.setToolTipText("Resilience");
        lblRes_1.setImage(GUI.loadImage(display, "resiliance.png"));
        lblRes_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStatTxt__1 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt__1.setText(":");
        lblTotalStatTxt__1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStat_1 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStat_1.setText("000");
        lblTotalStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Button btnAddMinorMod_1 = new Button(grpTotalStats, SWT.NONE);
        btnAddMinorMod_1.setToolTipText("Add minor resilience mod.");
        btnAddMinorMod_1.setText("+5");
        btnAddMinorMod_1.setSize(new Point(100, 100));
        btnAddMinorMod_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblMinorModsCount_1 = new Label(grpTotalStats, SWT.NONE);
        lblMinorModsCount_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblMinorModsCount_1.setText("0");
        lblMinorModsCount_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnAddMod_1 = new Button(grpTotalStats, SWT.NONE);
        btnAddMod_1.setToolTipText("Add resilience mod.");
        btnAddMod_1.setText("+10");
        btnAddMod_1.setSize(new Point(100, 100));
        btnAddMod_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblBigModsCount_1 = new Label(grpTotalStats, SWT.NONE);
        lblBigModsCount_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblBigModsCount_1.setText("0");
        lblBigModsCount_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnClearMods_1 = new Button(grpTotalStats, SWT.NONE);
        btnClearMods_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
        btnClearMods_1.setToolTipText("Remove resilience mods.");
        btnClearMods_1.setText("x");
        btnClearMods_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblTotalStatTxt_2 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt_2.setText("Recovery");
        lblTotalStatTxt_2.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblRec_1 = new Label(grpTotalStats, SWT.NONE);
        lblRec_1.setToolTipText("Recovery");
        lblRec_1.setImage(GUI.loadImage(display, "recovery.png"));
        lblRec_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStatTxt__2 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt__2.setText(":");
        lblTotalStatTxt__2.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStat_2 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStat_2.setText("000");
        lblTotalStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Button btnAddMinorMod_2 = new Button(grpTotalStats, SWT.NONE);
        btnAddMinorMod_2.setToolTipText("Add minor recovery mod.");
        btnAddMinorMod_2.setText("+5");
        btnAddMinorMod_2.setSize(new Point(100, 100));
        btnAddMinorMod_2.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblMinorModsCount_2 = new Label(grpTotalStats, SWT.NONE);
        lblMinorModsCount_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblMinorModsCount_2.setText("0");
        lblMinorModsCount_2.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnAddMod_2 = new Button(grpTotalStats, SWT.NONE);
        btnAddMod_2.setToolTipText("Add recovery mod.");
        btnAddMod_2.setText("+10");
        btnAddMod_2.setSize(new Point(100, 100));
        btnAddMod_2.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblBigModsCount_2 = new Label(grpTotalStats, SWT.NONE);
        lblBigModsCount_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblBigModsCount_2.setText("0");
        lblBigModsCount_2.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnClearMods_1_1 = new Button(grpTotalStats, SWT.NONE);
        btnClearMods_1_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
        btnClearMods_1_1.setToolTipText("Remove recovery mods.");
        btnClearMods_1_1.setText("x");
        btnClearMods_1_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblTotalStatTxt_3 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt_3.setText("Discipline");
        lblTotalStatTxt_3.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblDis_1 = new Label(grpTotalStats, SWT.NONE);
        lblDis_1.setToolTipText("Discipline");
        lblDis_1.setImage(GUI.loadImage(display, "discipline.png"));
        lblDis_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStatTxt__3 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt__3.setText(":");
        lblTotalStatTxt__3.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStat_3 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStat_3.setText("000");
        lblTotalStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Button btnAddMinorMod_3 = new Button(grpTotalStats, SWT.NONE);
        btnAddMinorMod_3.setToolTipText("Add minor discipline mod.");
        btnAddMinorMod_3.setText("+5");
        btnAddMinorMod_3.setSize(new Point(100, 100));
        btnAddMinorMod_3.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblMinorModsCount_3 = new Label(grpTotalStats, SWT.NONE);
        lblMinorModsCount_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblMinorModsCount_3.setText("0");
        lblMinorModsCount_3.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnAddMod_3 = new Button(grpTotalStats, SWT.NONE);
        btnAddMod_3.setToolTipText("Add discipline mod.");
        btnAddMod_3.setText("+10");
        btnAddMod_3.setSize(new Point(100, 100));
        btnAddMod_3.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblBigModsCount_3 = new Label(grpTotalStats, SWT.NONE);
        lblBigModsCount_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblBigModsCount_3.setText("0");
        lblBigModsCount_3.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnClearMods_1_2 = new Button(grpTotalStats, SWT.NONE);
        btnClearMods_1_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
        btnClearMods_1_2.setToolTipText("Remove discipline mods.");
        btnClearMods_1_2.setText("x");
        btnClearMods_1_2.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblTotalStatTxt_3_1 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt_3_1.setText("Intellect");
        lblTotalStatTxt_3_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblInt_1 = new Label(grpTotalStats, SWT.NONE);
        lblInt_1.setToolTipText("Intellect");
        lblInt_1.setImage(GUI.loadImage(display, "intellect.png"));
        lblInt_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStatTxt__3_1 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt__3_1.setText(":");
        lblTotalStatTxt__3_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStat_4 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStat_4.setText("000");
        lblTotalStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Button btnAddMinorMod_4 = new Button(grpTotalStats, SWT.NONE);
        btnAddMinorMod_4.setToolTipText("Add minor intellect mod.");
        btnAddMinorMod_4.setText("+5");
        btnAddMinorMod_4.setSize(new Point(100, 100));
        btnAddMinorMod_4.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblMinorModsCount_4 = new Label(grpTotalStats, SWT.NONE);
        lblMinorModsCount_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblMinorModsCount_4.setText("0");
        lblMinorModsCount_4.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnAddMod_4 = new Button(grpTotalStats, SWT.NONE);
        btnAddMod_4.setToolTipText("Add intellect mod.");
        btnAddMod_4.setText("+10");
        btnAddMod_4.setSize(new Point(100, 100));
        btnAddMod_4.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblBigModsCount_4 = new Label(grpTotalStats, SWT.NONE);
        lblBigModsCount_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblBigModsCount_4.setText("0");
        lblBigModsCount_4.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnClearMods_1_3 = new Button(grpTotalStats, SWT.NONE);
        btnClearMods_1_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
        btnClearMods_1_3.setToolTipText("Remove intellect mods.");
        btnClearMods_1_3.setText("x");
        btnClearMods_1_3.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblTotalStatTxt_3_2 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt_3_2.setText("Strength");
        lblTotalStatTxt_3_2.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblStr_1 = new Label(grpTotalStats, SWT.NONE);
        lblStr_1.setToolTipText("Strength");
        lblStr_1.setImage(GUI.loadImage(display, "strength.png"));
        lblStr_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStatTxt__5 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatTxt__5.setText(":");
        lblTotalStatTxt__5.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Label lblTotalStat_5 = new Label(grpTotalStats, SWT.NONE);
        lblTotalStat_5.setText("000");
        lblTotalStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Button btnAddMinorMod_5 = new Button(grpTotalStats, SWT.NONE);
        btnAddMinorMod_5.setToolTipText("Add minor strength mod.");
        btnAddMinorMod_5.setText("+5");
        btnAddMinorMod_5.setSize(new Point(100, 100));
        btnAddMinorMod_5.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblMinorModsCount_5 = new Label(grpTotalStats, SWT.NONE);
        lblMinorModsCount_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblMinorModsCount_5.setText("0");
        lblMinorModsCount_5.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnAddMod_5 = new Button(grpTotalStats, SWT.NONE);
        btnAddMod_5.setToolTipText("Add strength mod.");
        btnAddMod_5.setText("+10");
        btnAddMod_5.setSize(new Point(100, 100));
        btnAddMod_5.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblBigModsCount_5 = new Label(grpTotalStats, SWT.NONE);
        lblBigModsCount_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GRAY));
        lblBigModsCount_5.setText("0");
        lblBigModsCount_5.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));

        Button btnClearMods_1_4 = new Button(grpTotalStats, SWT.NONE);
        btnClearMods_1_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
        btnClearMods_1_4.setToolTipText("Remove strength mods.");
        btnClearMods_1_4.setText("x");
        btnClearMods_1_4.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label lblTotalStatNULL = new Label(grpTotalStats, SWT.NONE);
        lblTotalStatNULL.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        new Label(grpTotalStats, SWT.NONE);
        new Label(grpTotalStats, SWT.NONE);
        new Label(grpTotalStats, SWT.NONE);
        new Label(grpTotalStats, SWT.NONE);
        new Label(grpTotalStats, SWT.NONE);
        new Label(grpTotalStats, SWT.NONE);
        new Label(grpTotalStats, SWT.NONE);
        new Label(grpTotalStats, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblTotalStats = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStats.setText("00");
        lblTotalStats.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStats_1 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStats_1.setText("00");
        lblTotalStats_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStats_2 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStats_2.setText("00");
        lblTotalStats_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStats_3 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStats_3.setText("00");
        lblTotalStats_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStats_4 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStats_4.setText("00");
        lblTotalStats_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStats_5 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStats_5.setText("00");
        lblTotalStats_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblTotalStats_6 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStats_6.setText("000");
        lblTotalStats_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Button btnReset_1 = new Button(grpItemPicker, SWT.NONE);
        btnReset_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
        btnReset_1.setText("Reset");
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Button btnAbout = new Button(shlDestinyCalculator, SWT.NONE);
        btnAbout.setText("About");
        FormData fd_btnAbout = new FormData();
        fd_btnAbout.bottom = new FormAttachment(100, -10);
        fd_btnAbout.left = new FormAttachment(grpItemPicker, 6);
        fd_btnAbout.right = new FormAttachment(comboCharacter, 0, SWT.RIGHT);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        btnAbout.setLayoutData(fd_btnAbout);

        /* CUSTOM CODE: START */
        GUI.scaleSQRWindowDisplay(display, shlDestinyCalculator);
        GUI.shellCenter(display, shlDestinyCalculator);

        Button[] helmetBtns = { btnHelmetClear, chkBtnHelmetMW };
        Label[] helmetLabels = { lblHelmetName, lblHelmetTier, lblHelmetStat, lblHelmetStat_1, lblHelmetStat_2,
                lblHelmetStat_3, lblHelmetStat_4, lblHelmetStat_5, lblHelmetStat_6, lblHelmetStatMW, lblHelmetStatMW_1,
                lblHelmetStatMW_2, lblHelmetStatMW_3, lblHelmetStatMW_4, lblHelmetStatMW_5, lblHelmetStatMW_6,
                lblHelmetMW, lblHelmetMWTier };
        helmet = new ItemPickerRow(Type.HELMET, helmetBtns, helmetLabels);

        Button[] gauntletsBtns = { btnGauntletsClear, chkBtnGauntletsMW };
        Label[] gauntletsLabels = { lblGauntletsName, lblGauntletsTier, lblGauntletsStat, lblGauntletsStat_1,
                lblGauntletsStat_2, lblGauntletsStat_3, lblGauntletsStat_4, lblGauntletsStat_5, lblGauntletsStat_6,
                lblGauntletsStatMW, lblGauntletsStatMW_1, lblGauntletsStatMW_2, lblGauntletsStatMW_3,
                lblGauntletsStatMW_4, lblGauntletsStatMW_5, lblGauntletsStatMW_6, lblGauntletsMW, lblGauntletsMWTier };
        gauntlets = new ItemPickerRow(Type.GAUNTLETS, gauntletsBtns, gauntletsLabels);

        Button[] chestBtns = { btnChestClear, chkBtnChestMW };
        Label[] chestLabels = { lblChestName, lblChestTier, lblChestStat, lblChestStat_1, lblChestStat_2,
                lblChestStat_3, lblChestStat_4, lblChestStat_5, lblChestStat_6, lblChestStatMW, lblChestStatMW_1,
                lblChestStatMW_2, lblChestStatMW_3, lblChestStatMW_4, lblChestStatMW_5, lblChestStatMW_6, lblChestMW,
                lblChestMWTier };
        chest = new ItemPickerRow(Type.HELMET, chestBtns, chestLabels);

        Button[] legBtns = { btnLegClear, chkBtnLegMW };
        Label[] legLabels = { lblLegName, lblLegTier, lblLegStat, lblLegStat_1, lblLegStat_2, lblLegStat_3,
                lblLegStat_4, lblLegStat_5, lblLegStat_6, lblLegStatMW, lblLegStatMW_1, lblLegStatMW_2, lblLegStatMW_3,
                lblLegStatMW_4, lblLegStatMW_5, lblLegStatMW_6, lblLegMW, lblLegMWTier };
        leg = new ItemPickerRow(Type.HELMET, legBtns, legLabels);

        /* CUSTOM CODE: END */

        shlDestinyCalculator.open();
        shlDestinyCalculator.layout();
        while (!shlDestinyCalculator.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

    }

}
