package destiny.joe.items;

public enum Type implements Column {
    NULL, HELMET, ARM, CHEST, LEG;

    public static Column identifyColumn(String s) {
        for (Column c : Type.values()) {
            if (c.toString().compareToIgnoreCase(s.trim()) == 0)
                return c;
        }
        System.out.println("Unkown type!");
        return NULL;
    }
}
