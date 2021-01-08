package destiny.joe;

import java.util.Arrays;

import destiny.joe.items.Item;
import destiny.joe.items.ItemsFactory;
import destiny.joe.utils.FileReader;

public class Main {

    public static void main(String[] args) {
        try {
            Item[] items = ItemsFactory.parseItems(new FileReader("destiny.csv", ",").read());
            System.out.println(Arrays.deepToString(items));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
