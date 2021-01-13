package destiny.joe.utils;

import javax.swing.ImageIcon;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;

import destiny.joe.gui.MainWindow;

public class GUI {

    private GUI() {
    }

    public static org.eclipse.swt.graphics.Image loadImage(Display display, String file) {

        String jarPath = getAbsolutePath("destiny-calculator_media/");
        return new Image(display, jarPath + file);
    }

    public static java.awt.Image loadImage(String file) {

        String jarPath = getAbsolutePath("destiny-calculator_media/");
        return new ImageIcon(jarPath + file).getImage();
    }

    public static String getAbsolutePath(String path) {
        String jarPath = MainWindow.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);

        if (jarPath.contains("destiny-calculator.jar"))
            jarPath = jarPath.replace("destiny-calculator.jar", path);
        return jarPath;
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

    private static final Point DEFAULT_DPI = new Point(96, 96);

    /***
     * Scale the shell by dpi/96. It is needed to fit UI to the scaled text.
     * https://stackoverflow.com/questions/19900033/how-to-compute-swt-widget-size-according-to-windows-dpi/43003186
     */
    public static void scaleWindowDisplay(Display display, Shell shell) {
        Point dpi = display.getDPI();
        Point size = shell.getSize();

        int x = (size.x * dpi.x) / DEFAULT_DPI.x;
        int y = (size.y * dpi.y) / DEFAULT_DPI.y;

        shell.setSize(new Point(x, y));
    }

    /***
     * Scale the shell by sqr(dpi/96). It is needed to keep the design structure.
     */
    public static void scaleSQRWindowDisplay(Display display, Shell shell) {
        Point dpi = display.getDPI();
        Point size = shell.getSize();

        int x = (int) (Math.sqrt((double) dpi.x / DEFAULT_DPI.x) * size.x);
        int y = (int) (Math.sqrt((double) dpi.y / DEFAULT_DPI.y) * size.y);

        x = uglyFix(x, dpi.x - DEFAULT_DPI.x);
        y = uglyFix(y, dpi.y - DEFAULT_DPI.y);

        shell.setSize(new Point(x, y));
    }

    private static int uglyFix(int dim, int dpiDiff) {
        return (int) (dim + 8 + (dpiDiff * .8));
    }

    /**
     * Used with scaleWindowDisplay.
     */
    public static void scaleColumnDisplay(Display display, TableColumn col) {
        Point dpi = display.getDPI();
        int width = col.getWidth();

        col.setWidth((width * dpi.x) / DEFAULT_DPI.x);
    }

}
