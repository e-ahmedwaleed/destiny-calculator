package destiny.joe;

import java.util.List;
import java.util.Map;

import destiny.joe.items.Character;
import destiny.joe.items.Item;
import destiny.joe.items.ItemsFactory;
import destiny.joe.items.Type;
import destiny.joe.utils.FileReader;

public class Main {

    public static void main(String[] args) {
        try {
            Map<Character, Map<Type, List<Item>>> items = ItemsFactory
                    .parseItems(new FileReader("destiny.csv", ",").read());
            System.out.println(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
