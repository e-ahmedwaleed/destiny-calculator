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

    public String open(boolean isSave) {

        FileDialog dialog;

        if (isSave)
            dialog = new FileDialog(getParent(), SWT.SAVE);
        else
            dialog = new FileDialog(getParent(), SWT.OPEN);

        dialog.setFilterNames(new String[] { "Serialized Files (.xml)", "All Files (*.*)" });
        dialog.setFilterExtensions(new String[] { "*.xml", "*.*" });

        dialog.setFilterPath(GUI.getAbsolutePath("destiny-calculator_sets/"));

        String path = dialog.open();

        if (path != null)
            return path.contains(".xml") ? path : path + ".xml";

        return null;

    }

}
