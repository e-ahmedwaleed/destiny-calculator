package destiny.joe.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.ExpandBar;

public class MainWindow {

    /**
     * Launch the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Display display = Display.getDefault();
        // https://www.eclipse.org/forums/index.php/t/146112/
        Shell shlDestinyCalculator = new Shell(SWT.CLOSE | SWT.MIN);
        shlDestinyCalculator.setMinimumSize(new Point(640, 480));
        shlDestinyCalculator.setImage(loadImage("destiny-2.ico"));
        shlDestinyCalculator.setSize(640, 480);
        shlDestinyCalculator.setText("Destiny Calculator");
        shlDestinyCalculator.setLayout(new FormLayout());

        Group grpItemPicker = new Group(shlDestinyCalculator, SWT.NONE);
        FormData fd_grpItemPicker = new FormData();
        fd_grpItemPicker.left = new FormAttachment(0, 10);
        fd_grpItemPicker.top = new FormAttachment(0, 10);
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
        lblMob.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\mobility.png"));
        lblMob.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblMob.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblRes = new Label(grpItemPicker, SWT.NONE);
        lblRes.setToolTipText("Resilience");
        lblRes.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\resiliance.png"));
        lblRes.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblRes.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblRec = new Label(grpItemPicker, SWT.NONE);
        lblRec.setToolTipText("Recovery");
        lblRec.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\recovery.png"));
        lblRec.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblRec.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblDis = new Label(grpItemPicker, SWT.NONE);
        lblDis.setToolTipText("Discipline");
        lblDis.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\discipline.png"));
        lblDis.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblDis.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblInt = new Label(grpItemPicker, SWT.NONE);
        lblInt.setToolTipText("Intellect");
        lblInt.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\intellect.png"));
        lblInt.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblInt.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));

        Label lblStr = new Label(grpItemPicker, SWT.NONE);
        lblStr.setToolTipText("Strength");
        lblStr.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\strength.png"));
        lblStr.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        lblStr.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        
        Label v_bar = new Label(grpItemPicker, SWT.SEPARATOR | SWT.VERTICAL);
        GridData gd_v_bar = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_v_bar.heightHint = 14;
        v_bar.setLayoutData(gd_v_bar);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblTier = new Label(grpItemPicker, SWT.NONE);
        lblTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
        lblTier.setText("Tier ");

        Label vLine_0 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_0.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        Label lblHelmet = new Label(grpItemPicker, SWT.NONE);
        lblHelmet.setText("Helmet");
        new Label(grpItemPicker, SWT.NONE);
                
                        Label lblHelmetName = new Label(grpItemPicker, SWT.NONE);
                        lblHelmetName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
                        lblHelmetName.setText("Item Name");

        Button btnHelmet = new Button(grpItemPicker, SWT.NONE);
        btnHelmet.setToolTipText("Choose item.");
        btnHelmet.setText("C");

        Label lblHelmetStat = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat.setText("0");
        lblHelmetStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_1.setText("0");
        lblHelmetStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_2.setText("0");
        lblHelmetStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_3.setText("0");
        lblHelmetStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_4.setText("0");
        lblHelmetStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblHelmetStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_5.setText("0");
        lblHelmetStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStat_6.setText("0");
        lblHelmetStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetTier = new Label(grpItemPicker, SWT.NONE);
        lblHelmetTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetTier.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
        lblHelmetTier.setText("E");
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetStatMW = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW.setText("2");
        lblHelmetStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW.setEnabled(false);

        Label lblHelmetStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_1.setText("2");
        lblHelmetStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_1.setEnabled(false);

        Label lblHelmetStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_2.setText("2");
        lblHelmetStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_2.setEnabled(false);

        Label lblHelmetStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_3.setText("2");
        lblHelmetStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_3.setEnabled(false);

        Label lblHelmetStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_4.setText("2");
        lblHelmetStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_4.setEnabled(false);

        Label lblHelmetStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_5.setText("2");
        lblHelmetStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_5.setEnabled(false);
        new Label(grpItemPicker, SWT.NONE);

        Label lblHelmetStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetStatMW_6.setText("12");
        lblHelmetStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblHelmetStatMW_6.setEnabled(false);

        Button chkBtnHelmetMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnHelmetMW.setToolTipText("+2 for each stat.");

        Label lblHelmetTier_1 = new Label(grpItemPicker, SWT.NONE);
        lblHelmetTier_1.setToolTipText("Masterwork Tier");
        lblHelmetTier_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblHelmetTier_1.setText("0 / 10");
        lblHelmetTier_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label vLine_1 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        Label lblGauntlets = new Label(grpItemPicker, SWT.NONE);
        lblGauntlets.setText("Gauntlets");
        new Label(grpItemPicker, SWT.NONE);
                
                        Label lblGauntletsName = new Label(grpItemPicker, SWT.NONE);
                        lblGauntletsName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
                        lblGauntletsName.setText("Item Name");

        Button btnGauntlets = new Button(grpItemPicker, SWT.NONE);
        btnGauntlets.setToolTipText("Choose item.");
        btnGauntlets.setText("C");

        Label lblGauntletsStat = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat.setText("0");
        lblGauntletsStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_1.setText("0");
        lblGauntletsStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_2.setText("0");
        lblGauntletsStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_3.setText("0");
        lblGauntletsStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_4.setText("0");
        lblGauntletsStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblGauntletsStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_5.setText("0");
        lblGauntletsStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStat_6.setText("0");
        lblGauntletsStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsTier = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsTier.setText("E");
        lblGauntletsTier.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsStatMW = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW.setText("2");
        lblGauntletsStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW.setEnabled(false);

        Label lblGauntletsStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_1.setText("2");
        lblGauntletsStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_1.setEnabled(false);

        Label lblGauntletsStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_2.setText("2");
        lblGauntletsStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_2.setEnabled(false);

        Label lblGauntletsStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_3.setText("2");
        lblGauntletsStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_3.setEnabled(false);

        Label lblGauntletsStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_4.setText("2");
        lblGauntletsStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_4.setEnabled(false);

        Label lblGauntletsStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_5.setText("2");
        lblGauntletsStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_5.setEnabled(false);
        new Label(grpItemPicker, SWT.NONE);

        Label lblGauntletsStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsStatMW_6.setText("12");
        lblGauntletsStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblGauntletsStatMW_6.setEnabled(false);

        Button chkBtnGauntletsMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnGauntletsMW.setToolTipText("+2 for each stat.");

        Label lblGauntletsTier_1 = new Label(grpItemPicker, SWT.NONE);
        lblGauntletsTier_1.setToolTipText("Masterwork Tier");
        lblGauntletsTier_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblGauntletsTier_1.setText("0 / 10");
        lblGauntletsTier_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label vLine_2 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        Label lblChest = new Label(grpItemPicker, SWT.NONE);
        lblChest.setText("Chest");
        new Label(grpItemPicker, SWT.NONE);
                
                        Label lblChestName = new Label(grpItemPicker, SWT.NONE);
                        lblChestName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
                        lblChestName.setText("Item Name");

        Button btnChest = new Button(grpItemPicker, SWT.NONE);
        btnChest.setToolTipText("Choose item.");
        btnChest.setText("C");

        Label lblChestStat = new Label(grpItemPicker, SWT.NONE);
        lblChestStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat.setText("0");
        lblChestStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_1.setText("0");
        lblChestStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_2.setText("0");
        lblChestStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_3.setText("0");
        lblChestStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_4.setText("0");
        lblChestStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblChestStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_5.setText("0");
        lblChestStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblChestStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStat_6.setText("0");
        lblChestStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestTier = new Label(grpItemPicker, SWT.NONE);
        lblChestTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestTier.setText("E");
        lblChestTier.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestStatMW = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW.setText("2");
        lblChestStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW.setEnabled(false);

        Label lblChestStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_1.setText("2");
        lblChestStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_1.setEnabled(false);

        Label lblChestStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_2.setText("2");
        lblChestStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_2.setEnabled(false);

        Label lblChestStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_3.setText("2");
        lblChestStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_3.setEnabled(false);

        Label lblChestStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_4.setText("2");
        lblChestStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_4.setEnabled(false);

        Label lblChestStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_5.setText("2");
        lblChestStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_5.setEnabled(false);
        new Label(grpItemPicker, SWT.NONE);

        Label lblChestStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblChestStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestStatMW_6.setText("12");
        lblChestStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblChestStatMW_6.setEnabled(false);

        Button chkBtnChestMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnChestMW.setToolTipText("+2 for each stat.");

        Label lblChestTier_1 = new Label(grpItemPicker, SWT.NONE);
        lblChestTier_1.setToolTipText("Masterwork Tier");
        lblChestTier_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblChestTier_1.setText("0 / 10");
        lblChestTier_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label vLine_3 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));

        Label lblLeg = new Label(grpItemPicker, SWT.NONE);
        lblLeg.setText("Leg");
        new Label(grpItemPicker, SWT.NONE);
                
                        Label lblLegName = new Label(grpItemPicker, SWT.NONE);
                        lblLegName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
                        lblLegName.setText("Item Name");

        Button btnLeg = new Button(grpItemPicker, SWT.NONE);
        btnLeg.setToolTipText("Choose item.");
        btnLeg.setText("C");

        Label lblLegStat = new Label(grpItemPicker, SWT.NONE);
        lblLegStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat.setText("0");
        lblLegStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_1.setText("0");
        lblLegStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_2.setText("0");
        lblLegStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_3.setText("0");
        lblLegStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_4.setText("0");
        lblLegStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblLegStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_5.setText("0");
        lblLegStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblLegStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStat_6.setText("0");
        lblLegStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegTier = new Label(grpItemPicker, SWT.NONE);
        lblLegTier.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegTier.setText("E");
        lblLegTier.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegStatMW = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW.setText("2");
        lblLegStatMW.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW.setEnabled(false);

        Label lblLegStatMW_1 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_1.setText("2");
        lblLegStatMW_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_1.setEnabled(false);

        Label lblLegStatMW_2 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_2.setText("2");
        lblLegStatMW_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_2.setEnabled(false);

        Label lblLegStatMW_3 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_3.setText("2");
        lblLegStatMW_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_3.setEnabled(false);

        Label lblLegStatMW_4 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_4.setText("2");
        lblLegStatMW_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_4.setEnabled(false);

        Label lblLegStatMW_5 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_5.setText("2");
        lblLegStatMW_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_5.setEnabled(false);
        new Label(grpItemPicker, SWT.NONE);

        Label lblLegStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblLegStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegStatMW_6.setText("12");
        lblLegStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblLegStatMW_6.setEnabled(false);

        Button chkBtnLegMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnLegMW.setToolTipText("+2 for each stat.");

        Label lblLegTier_1 = new Label(grpItemPicker, SWT.NONE);
        lblLegTier_1.setToolTipText("Masterwork Tier");
        lblLegTier_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblLegTier_1.setText("0 / 10");
        lblLegTier_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));

        Label vLine_4 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        GridData gd_vLine_4 = new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1);
        gd_vLine_4.widthHint = 486;
        vLine_4.setLayoutData(gd_vLine_4);

        Label lblExtra = new Label(grpItemPicker, SWT.NONE);
        lblExtra.setText("Class");
        new Label(grpItemPicker, SWT.NONE);
                
                        Label lblExtraName = new Label(grpItemPicker, SWT.NONE);
                        lblExtraName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
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
        new Label(grpItemPicker, SWT.NONE);

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
        new Label(grpItemPicker, SWT.NONE);

        Label lblExtraStatMW_6 = new Label(grpItemPicker, SWT.NONE);
        lblExtraStatMW_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        lblExtraStatMW_6.setEnabled(false);
        lblExtraStatMW_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblExtraStatMW_6.setText("12");

        Button chkBtnExtraMW = new Button(grpItemPicker, SWT.CHECK);
        chkBtnExtraMW.setToolTipText("+2 for each stat.");
        new Label(grpItemPicker, SWT.NONE);

        Combo comboCharacter = new Combo(shlDestinyCalculator, SWT.NONE);
        fd_grpItemPicker.right = new FormAttachment(100, -114);
        FormData fd_comboCharacter = new FormData();
        fd_comboCharacter.top = new FormAttachment(0, 10);
        fd_comboCharacter.right = new FormAttachment(100, -10);
        fd_comboCharacter.left = new FormAttachment(0, 516);
        comboCharacter.setLayoutData(fd_comboCharacter);
        comboCharacter.setItems(new String[] { "Hunter", "Titan", "Warlock" });
        comboCharacter.setText("Character");

        Label vLine_5 = new Label(grpItemPicker, SWT.SEPARATOR | SWT.HORIZONTAL);
        vLine_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 16, 1));
        
        Group grpModsCount = new Group(grpItemPicker, SWT.NONE);
        grpModsCount.setText("Mods Count");
        grpModsCount.setLayout(new GridLayout(7, false));
        GridData gd_grpModsCount = new GridData(SWT.FILL, SWT.TOP, false, false, 4, 4);
        gd_grpModsCount.widthHint = 160;
        gd_grpModsCount.heightHint = 70;
        grpModsCount.setLayoutData(gd_grpModsCount);
        new Label(grpModsCount, SWT.NONE);
        
        Label lblMob_2 = new Label(grpModsCount, SWT.NONE);
        lblMob_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblMob_2.setToolTipText("Mobility Mods");
        lblMob_2.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\mobility.png"));
        lblMob_2.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblRes_2 = new Label(grpModsCount, SWT.NONE);
        lblRes_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblRes_2.setToolTipText("Resilience Mods");
        lblRes_2.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\resiliance.png"));
        lblRes_2.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblRec_1_1 = new Label(grpModsCount, SWT.NONE);
        lblRec_1_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblRec_1_1.setToolTipText("Recovery Mods");
        lblRec_1_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\recovery.png"));
        lblRec_1_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblDis_1_1 = new Label(grpModsCount, SWT.NONE);
        lblDis_1_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblDis_1_1.setToolTipText("Discipline Mods");
        lblDis_1_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\discipline.png"));
        lblDis_1_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblInt_1_1 = new Label(grpModsCount, SWT.NONE);
        lblInt_1_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblInt_1_1.setToolTipText("Intellect Mods");
        lblInt_1_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\intellect.png"));
        lblInt_1_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblStr_1_1 = new Label(grpModsCount, SWT.NONE);
        lblStr_1_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblStr_1_1.setToolTipText("Strength Mods");
        lblStr_1_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\strength.png"));
        lblStr_1_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblModsP5 = new Label(grpModsCount, SWT.NONE);
        lblModsP5.setText("+05");
        lblModsP5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblModsCount = new Label(grpModsCount, SWT.NONE);
        lblModsCount.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblModsCount.setText("0");
        lblModsCount.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblModsCount_1 = new Label(grpModsCount, SWT.NONE);
        lblModsCount_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblModsCount_1.setText("0");
        lblModsCount_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblModsCount_2 = new Label(grpModsCount, SWT.NONE);
        lblModsCount_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblModsCount_2.setText("0");
        lblModsCount_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblModsCount_3 = new Label(grpModsCount, SWT.NONE);
        lblModsCount_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblModsCount_3.setText("0");
        lblModsCount_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblModsCount_4 = new Label(grpModsCount, SWT.NONE);
        lblModsCount_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblModsCount_4.setText("0");
        lblModsCount_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblModsCount_5 = new Label(grpModsCount, SWT.NONE);
        lblModsCount_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblModsCount_5.setText("0");
        lblModsCount_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblModsP10 = new Label(grpModsCount, SWT.NONE);
        lblModsP10.setText("+10");
        lblModsP10.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblBigModsCount = new Label(grpModsCount, SWT.NONE);
        lblBigModsCount.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblBigModsCount.setText("0");
        lblBigModsCount.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblBigModsCount_1 = new Label(grpModsCount, SWT.NONE);
        lblBigModsCount_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblBigModsCount_1.setText("0");
        lblBigModsCount_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblBigModsCount_2 = new Label(grpModsCount, SWT.NONE);
        lblBigModsCount_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblBigModsCount_2.setText("0");
        lblBigModsCount_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblBigModsCount_3 = new Label(grpModsCount, SWT.NONE);
        lblBigModsCount_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblBigModsCount_3.setText("0");
        lblBigModsCount_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblBigModsCount_4 = new Label(grpModsCount, SWT.NONE);
        lblBigModsCount_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblBigModsCount_4.setText("0");
        lblBigModsCount_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        
        Label lblBigModsCount_5 = new Label(grpModsCount, SWT.NONE);
        lblBigModsCount_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblBigModsCount_5.setText("0");
        lblBigModsCount_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        
        Label lblMob_1 = new Label(grpItemPicker, SWT.NONE);
        lblMob_1.setToolTipText("Mobility");
        lblMob_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\mobility.png"));
        lblMob_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblRes_1 = new Label(grpItemPicker, SWT.NONE);
        lblRes_1.setToolTipText("Resilience");
        lblRes_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\resiliance.png"));
        lblRes_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblRec_1 = new Label(grpItemPicker, SWT.NONE);
        lblRec_1.setToolTipText("Recovery");
        lblRec_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\recovery.png"));
        lblRec_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblDis_1 = new Label(grpItemPicker, SWT.NONE);
        lblDis_1.setToolTipText("Discipline");
        lblDis_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\discipline.png"));
        lblDis_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblInt_1 = new Label(grpItemPicker, SWT.NONE);
        lblInt_1.setToolTipText("Intellect");
        lblInt_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\intellect.png"));
        lblInt_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label lblStr_1 = new Label(grpItemPicker, SWT.NONE);
        lblStr_1.setToolTipText("Strength");
        lblStr_1.setImage(SWTResourceManager.getImage("D:\\eclipse-workspace\\destiny-calculator\\bin\\strength.png"));
        lblStr_1.setFont(SWTResourceManager.getFont("Consolas", 8, SWT.NORMAL));
        
        Label v_bar_1 = new Label(grpItemPicker, SWT.SEPARATOR);
        GridData gd_v_bar_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_v_bar_1.heightHint = 14;
        v_bar_1.setLayoutData(gd_v_bar_1);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        
        Button btnModUp = new Button(grpItemPicker, SWT.NONE);
        btnModUp.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            }
        });
        btnModUp.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        btnModUp.setText("+");
        btnModUp.setSize(new Point(100,100));
        
        Button btnModUp_1 = new Button(grpItemPicker, SWT.NONE);
        btnModUp_1.setText("+");
        btnModUp_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        
        Button btnModUp_2 = new Button(grpItemPicker, SWT.NONE);
        btnModUp_2.setText("+");
        btnModUp_2.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        
        Button btnModUp_3 = new Button(grpItemPicker, SWT.NONE);
        btnModUp_3.setText("+");
        btnModUp_3.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        
        Button btnModUp_4 = new Button(grpItemPicker, SWT.NONE);
        btnModUp_4.setText("+");
        btnModUp_4.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        
        Button btnModUp_5 = new Button(grpItemPicker, SWT.NONE);
        btnModUp_5.setText("+");
        btnModUp_5.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Label lblTotalStats = new Label(grpItemPicker, SWT.NONE);
        lblTotalStats.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblTotalStats.setText("Total Stats");
        new Label(grpItemPicker, SWT.NONE);

        Label lblTotalStat = new Label(grpItemPicker, SWT.NONE);
        lblTotalStat.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStat.setText("0");
        lblTotalStat.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStat_1 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStat_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStat_1.setText("0");
        lblTotalStat_1.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStat_2 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStat_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStat_2.setText("0");
        lblTotalStat_2.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStat_3 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStat_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStat_3.setText("0");
        lblTotalStat_3.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStat_4 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStat_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStat_4.setText("0");
        lblTotalStat_4.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));

        Label lblTotalStat_5 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStat_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStat_5.setText("0");
        lblTotalStat_5.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);

        Label lblTotalStat_6 = new Label(grpItemPicker, SWT.NONE);
        lblTotalStat_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblTotalStat_6.setText("0");
        lblTotalStat_6.setFont(SWTResourceManager.getFont("Consolas", 9, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        
        Button btnModDown = new Button(grpItemPicker, SWT.NONE);
        btnModDown.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        btnModDown.setText("-");
        
        Button btnModDown_1 = new Button(grpItemPicker, SWT.NONE);
        btnModDown_1.setText("-");
        btnModDown_1.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        
        Button btnModDown_2 = new Button(grpItemPicker, SWT.NONE);
        btnModDown_2.setText("-");
        btnModDown_2.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        
        Button btnModDown_3 = new Button(grpItemPicker, SWT.NONE);
        btnModDown_3.setText("-");
        btnModDown_3.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        
        Button btnModDown_4 = new Button(grpItemPicker, SWT.NONE);
        btnModDown_4.setText("-");
        btnModDown_4.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        
        Button btnModDown_5 = new Button(grpItemPicker, SWT.NONE);
        btnModDown_5.setText("-");
        btnModDown_5.setFont(SWTResourceManager.getFont("Consolas", 7, SWT.NORMAL));
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);
        new Label(grpItemPicker, SWT.NONE);

        Button btnReset = new Button(shlDestinyCalculator, SWT.NONE);
        fd_grpItemPicker.bottom = new FormAttachment(btnReset, 0, SWT.BOTTOM);
        FormData fd_btnReset = new FormData();
        fd_btnReset.right = new FormAttachment(0, 614);
        fd_btnReset.top = new FormAttachment(0, 406);
        fd_btnReset.left = new FormAttachment(0, 516);
        btnReset.setLayoutData(fd_btnReset);
        btnReset.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            }
        });
        btnReset.setText("Reset");

        Button btnAbout = new Button(shlDestinyCalculator, SWT.NONE);
        FormData fd_btnAbout = new FormData();
        fd_btnAbout.right = new FormAttachment(0, 614);
        fd_btnAbout.top = new FormAttachment(0, 375);
        fd_btnAbout.left = new FormAttachment(0, 516);
        btnAbout.setLayoutData(fd_btnAbout);
        btnAbout.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            }
        });
        btnAbout.setText("About");

        /* CUSTOM CODE: START */
        shellCenter(display, shlDestinyCalculator);
        /* CUSTOM CODE: END */

        shlDestinyCalculator.open();
        shlDestinyCalculator.layout();
        while (!shlDestinyCalculator.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

    }

    private static Image loadImage(String file) {
        return new Image(Display.getDefault(),
                MainWindow.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6) + file);
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
