package destiny.joe.gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import destiny.joe.items.sets.Loadable;
import destiny.joe.utils.GUI;

import org.eclipse.swt.widgets.ProgressBar;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;

public class Loading extends Dialog implements Observer {

    private Shell shlPleaseWait;
    private ProgressBar progressBar;

    /**
     * Create the dialog.
     * 
     * @param parent
     * @param style
     */
    public Loading(Shell parent, int style) {
        super(parent, style);
    }

    /**
     * Open the dialog.
     * 
     * @return the result
     */
    public void open(Loadable process) {
        createContents();

        Display display = getParent().getDisplay();

        /* CUSTOM CODE: START */
        GUI.scaleWindowDisplay(display, shlPleaseWait);
        GUI.shellCenter(display, shlPleaseWait);
        /* CUSTOM CODE: END */

        shlPleaseWait.open();
        shlPleaseWait.layout();

        /* CUSTOM CODE: START */
        process.addObserver(this);
        process.load();
        /* CUSTOM CODE: END */

        while (!shlPleaseWait.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the dialog.
     */
    private void createContents() {
        shlPleaseWait = new Shell(getParent(), getStyle());
        shlPleaseWait.setMinimumSize(new Point(290, 50));
        shlPleaseWait.setSize(290, 50);
        shlPleaseWait.setText("Please wait ...");
        shlPleaseWait.setLayout(new GridLayout(1, false));

        progressBar = new ProgressBar(shlPleaseWait, SWT.NONE);
        progressBar.setMinimum(0);
        progressBar.setMaximum(10);
        progressBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        Label lblStat = new Label(shlPleaseWait, SWT.NONE);
        lblStat.setText("Loading ...");
    }

    @Override
    public void update(Observable o, Object arg) {
        progressBar.setSelection(progressBar.getSelection() + 1);
        if (progressBar.getSelection() >= 10)
            shlPleaseWait.dispose();
    }
}
