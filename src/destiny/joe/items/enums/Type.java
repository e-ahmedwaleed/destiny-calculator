package destiny.joe.items.enums;

public enum Type implements Column {
    NULL("-"), HELMET("Helmet"), GAUNTLETS("Gauntlets"), CHEST_ARMOR("Chest Armor"), LEG("Leg Armor");

    static final String[] IGNORED = { "Hunter Cloak", "Titan Mark", "Warlock Bond" };

    private final String string;

    Type(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public Column[] getValues() {
        return Type.values();
    }

    public Column getNull() {
        return NULL;
    }

}
