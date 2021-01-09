package destiny.joe.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Monitor;

public class MainWindow {
    private static Button btnMods;

    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Display display = Display.getDefault();
        Shell shlDestinyCalculator = new Shell();
        shlDestinyCalculator.setMinimumSize(new Point(640, 480));
        shlDestinyCalculator.setImage(null);
        shlDestinyCalculator.setSize(640, 480);
        shlDestinyCalculator.setText("Destiny Calculator");
        shlDestinyCalculator.setLayout(new FormLayout());

        Group grpItemPicker = new Group(shlDestinyCalculator, SWT.NONE);
        FormData fd_grpItemPicker = new FormData();
        fd_grpItemPicker.top = new FormAttachment(0, 10);
        fd_grpItemPicker.left = new FormAttachment(0, 10);
        grpItemPicker.setLayoutData(fd_grpItemPicker);
        grpItemPicker.setText("Item Picker");
        grpItemPicker.setLayout(new GridLayout(13, false));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblMob = new Label(grpItemPicker, SWT.NONE);
        lblMob.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblMob.setText("Mob");

        Label lblRes = new Label(grpItemPicker, SWT.NONE);
        lblRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblRes.setText("Res");

        Label lblRec = new Label(grpItemPicker, SWT.NONE);
        lblRec.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblRec.setText("Rec");

        Label lblDis = new Label(grpItemPicker, SWT.NONE);
        lblDis.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblDis.setText("Dis");

        Label lblInt = new Label(grpItemPicker, SWT.NONE);
        lblInt.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblInt.setText("Int");

        Label lblStr = new Label(grpItemPicker, SWT.NONE);
        lblStr.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStr.setText("Strs");

        Label lblTot = new Label(grpItemPicker, SWT.NONE);
        lblTot.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTot.setText("Tot");
        new Label(grpItemPicker, SWT.NONE);

        Label lblTier = new Label(grpItemPicker, SWT.NONE);
        lblTier.setText("Tier ");

        Label vLine_0 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_0.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 13, 1));

        Label lblHelmet = new Label(grpItemPicker, SWT.NONE);
        lblHelmet.setText("Helmet");
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetName = new Label(grpItemPicker, SWT.NONE);
        lblHelmetName.setText("Item Name");

        Button btnHelmet = new Button(grpItemPicker, SWT.NONE);
        btnHelmet.setText("C");
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
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Button chkBtnHelmetMW = new Button(grpItemPicker, SWT.CHECK);
        new Label(grpItemPicker, SWT.NONE);

        Label vLine_1 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 13, 1));

        Label lblGauntlets = new Label(grpItemPicker, SWT.NONE);
        lblGauntlets.setText("Gauntlets");
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsName = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsName.setText("Item Name");

        Button btnGauntlets = new Button(grpItemPicker, SWT.NONE);
        btnGauntlets.setText("C");
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
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Button chkBtnGauntletsMW = new Button(grpItemPicker, SWT.CHECK);
        new Label(grpItemPicker, SWT.NONE);

        Label vLine_2 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 13, 1));

        Label lblChest = new Label(grpItemPicker, SWT.NONE);
        lblChest.setText("Chest");
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestName = new Label(grpItemPicker, SWT.NONE);
        lblChestName.setText("Item Name");

        Button btnChest = new Button(grpItemPicker, SWT.NONE);
        btnChest.setText("C");
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
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Button chkBtnChestMW = new Button(grpItemPicker, SWT.CHECK);
        new Label(grpItemPicker, SWT.NONE);

        Label vLine_3 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 13, 1));

        Label lblLeg = new Label(grpItemPicker, SWT.NONE);
        lblLeg.setText("Leg");
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegName = new Label(grpItemPicker, SWT.NONE);
        lblLegName.setText("Item Name");

        Button btnLeg = new Button(grpItemPicker, SWT.NONE);
        btnLeg.setText("C");
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
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Button chkBtnLegMW = new Button(grpItemPicker, SWT.CHECK);
        new Label(grpItemPicker, SWT.NONE);

        Label vLine_4 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        GridData gd_vLine_4 = new GridData(SWT.FILL, SWT.FILL, false, false, 13, 1);
        gd_vLine_4.widthHint = 486;
        vLine_4.setLayoutData(gd_vLine_4);

        Label lblExtra = new Label(grpItemPicker, SWT.NONE);
        lblExtra.setText("Extra");
        new Label(grpItemPicker, SWT.NONE);

        Label lblExtraName = new Label(grpItemPicker, SWT.NONE);
        lblExtraName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
        lblExtraName.setText("Helm of the Emperor's Champion");
        new Label(grpItemPicker, SWT.NONE);

        Label lblExtraStat = new Label(grpItemPicker, SWT.NONE);
        lblExtraStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStat.setText("0");

        Label lblExtraStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStat_1.setText("0");

        Label lblExtraStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStat_2.setText("0");

        Label lblExtraStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStat_3.setText("0");

        Label lblExtraStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStat_4.setText("0");

        Label lblExtraStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStat_5.setText("0");

        Label lblExtraStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStat_6.setText("0");
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblExtraStatMW = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW.setEnabled(false);
        lblExtraStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW.setText("2");

        Label lblExtraStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_1.setEnabled(false);
        lblExtraStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_1.setText("2");

        Label lblExtraStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_2.setEnabled(false);
        lblExtraStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_2.setText("2");

        Label lblExtraStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_3.setEnabled(false);
        lblExtraStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_3.setText("2");

        Label lblExtraStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_4.setEnabled(false);
        lblExtraStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_4.setText("2");

        Label lblExtraStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_5.setEnabled(false);
        lblExtraStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_5.setText("2");

        Label lblExtraStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_6.setEnabled(false);
        lblExtraStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_6.setText("10");

        Button chkBtnExtraMW = new Button(grpItemPicker, SWT.CHECK);
        new Label(grpItemPicker, SWT.NONE);

        Combo combo = new Combo(shlDestinyCalculator, SWT.NONE);
        fd_grpItemPicker.right = new FormAttachment(combo, -6);
        FormData fd_combo = new FormData();
        fd_combo.right = new FormAttachment(0, 614);
        fd_combo.top = new FormAttachment(0, 10);
        fd_combo.left = new FormAttachment(0, 516);
        combo.setLayoutData(fd_combo);
        combo.setItems(new String[] { "Hunter", "Titan", "Warlock" });
        combo.setText("Class");

        Label lblStatus = new Label(shlDestinyCalculator, SWT.NONE);
        fd_grpItemPicker.bottom = new FormAttachment(lblStatus, -6);

        Label vLine_5 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 13, 1));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        
        Label lblMob_1 = new Label(grpItemPicker, SWT.NONE);
        lblMob_1.setText("Mob");
        
        Label lblRes_1 = new Label(grpItemPicker, SWT.NONE);
        lblRes_1.setText("Res");
        
        Label lblRec_1 = new Label(grpItemPicker, SWT.NONE);
        lblRec_1.setText("Rec");
        
        Label lblDis_1 = new Label(grpItemPicker, SWT.NONE);
        lblDis_1.setText("Dis");
        
        Label lblInt_1 = new Label(grpItemPicker, SWT.NONE);
        lblInt_1.setText("Int");
        
        Label lblStr_2 = new Label(grpItemPicker, SWT.NONE);
        lblStr_2.setText("Str");
        
        Label lblTot_1 = new Label(grpItemPicker, SWT.NONE);
        lblTot_1.setText("Tot");
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        
        btnMods = new Button(grpItemPicker, SWT.NONE);
        btnMods.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 2));
        btnMods.setText("Add Mods");
        
        Label lblTotalStats = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblTotalStats.setText("Total Stats");
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
        
        Label lblTiers = new Label(grpItemPicker, SWT.NONE);
        lblTiers.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, true, 1, 1));
        lblTiers.setText("Tiers");
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
        FormData fd_lblStatus = new FormData();
        fd_lblStatus.right = new FormAttachment(0, 510);
        fd_lblStatus.top = new FormAttachment(0, 416);
        fd_lblStatus.left = new FormAttachment(0, 10);
        lblStatus.setLayoutData(fd_lblStatus);
        lblStatus.setText("Loading ...");

        Button btnCalculate = new Button(shlDestinyCalculator, SWT.NONE);
        FormData fd_btnCalculate = new FormData();
        fd_btnCalculate.right = new FormAttachment(0, 614);
        fd_btnCalculate.top = new FormAttachment(0, 406);
        fd_btnCalculate.left = new FormAttachment(0, 516);
        btnCalculate.setLayoutData(fd_btnCalculate);
        btnCalculate.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            }
        });
        btnCalculate.setText("Calculate");

        Button btnReset = new Button(shlDestinyCalculator, SWT.NONE);
        FormData fd_btnReset = new FormData();
        fd_btnReset.right = new FormAttachment(0, 614);
        fd_btnReset.top = new FormAttachment(0, 375);
        fd_btnReset.left = new FormAttachment(0, 516);
        btnReset.setLayoutData(fd_btnReset);
        btnReset.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            }
        });
        btnReset.setText("Reset");

        shellCenter(display, shlDestinyCalculator);

        shlDestinyCalculator.open();
        shlDestinyCalculator.layout();
        while (!shlDestinyCalculator.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

    }

    // http://www.java2s.com/Tutorial/Java/0280__SWT/Centerashellontheprimarymonitor.htm
    private static void shellCenter(Display display, Shell shell) {
        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();

        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;

        shell.setLocation(x, y);
    }
}
