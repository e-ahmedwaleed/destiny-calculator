package destiny.joe.items;

public enum Type implements Column {
    NULL(""), HELMET("Helmet"), GAUNTLETS("Gauntlets"), CHEST_ARMOR("Chest Armor"), LEG("Leg Armor");

    private final String string;

    Type(String string) {
        this.string = string;
    }

    public static Column identifyColumn(String s) {
        for (Type c : Type.values()) {
            if (c.string.compareTo(s.trim()) == 0)
                return c;
        }
        System.out.println("Unkown type! " + s);
        return NULL;
    }
}
