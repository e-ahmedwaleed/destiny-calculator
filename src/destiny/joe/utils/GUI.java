package destiny.joe.utils;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import destiny.joe.gui.MainWindow;

public class GUI {

    public static Image loadImage(Display display, String file) {

        String jarDir = MainWindow.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);

        if (jarDir.contains("destiny-calculator.jar"))
            jarDir = jarDir.replace("destiny-calculator.jar", "destiny-calculator_media/");

        return new Image(display, jarDir + file);
    }

    // http://www.java2s.com/Tutorial/Java/0280__SWT/Centerashellontheprimarymonitor.htm
    public static void shellCenter(Display display, Shell shell) {
        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();

        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;

        shell.setLocation(x, y);
    }

}
