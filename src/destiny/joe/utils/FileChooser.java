package destiny.joe.utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

// http://www.java2s.com/Code/Java/SWT-JFace-Eclipse/FileDialogpromptforafilenametosave.htm
public class FileChooser extends Dialog {

    public FileChooser(Shell parent, int style) {
        super(parent, style);
    }

    /**
     * @param isSave
     * @param filters [0] Filter Name, [1] Filter Extension, [2] Filter Path.
     */
    public String open(boolean isSave, String[] filters) {

        FileDialog dialog;

        if (isSave)
            dialog = new FileDialog(getParent(), SWT.SAVE);
        else
            dialog = new FileDialog(getParent(), SWT.OPEN);

        dialog.setFilterNames(new String[] { filters[0] + " (" + filters[1] + ")", "All Files (*.*)" });
        dialog.setFilterExtensions(new String[] { "*" + filters[1], "*.*" });

        dialog.setFilterPath(GUI.getAbsolutePath(filters[2]));

        String path = dialog.open();

        if (path != null)
            return path.contains(filters[1]) ? path : path + filters[1];

        return null;

    }

}
