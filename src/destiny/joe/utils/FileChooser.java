package destiny.joe.utils;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

// https://www.geeksforgeeks.org/java-swing-jfilechooser/
public class FileChooser {

    private final String title;

    public FileChooser(String title) {
        this.title = title;
    }

    public String open() {

        // create an object of JFileChooser class
        JFileChooser j = new JFileChooser(new File(GUI.getAbsolutePath("destiny-calculator_sets/"))) {
            private static final long serialVersionUID = 1L;

            // https://stackoverflow.com/questions/6994772/how-to-change-default-java-icon-in-jfilechooser
            @Override
            protected JDialog createDialog(Component parent) throws HeadlessException {
                JDialog dialog = super.createDialog(parent);
                dialog.setIconImage(GUI.loadImage("load.png"));
                return dialog;
            }
        };

        // Restrict the user to select files of all types
        j.setAcceptAllFileFilterUsed(false);

        // set a title for the dialog
        j.setDialogTitle(title);

        // only allow files of .txt extension
        FileNameExtensionFilter restrict = new FileNameExtensionFilter(".xml", "xml");
        j.addChoosableFileFilter(restrict);

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION) {
            // set the label to the path of the selected file
            return j.getSelectedFile().getAbsolutePath();
        }
        // if the user cancelled the operation
        else
            return null;
    }

}
