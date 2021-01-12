package destiny.joe.items.enums;

public enum Type implements ItemProperty.Column, ItemProperty.MultiWords, ItemProperty.HasIgnored {
    NULL("-"), HELMET("Helmet"), GAUNTLETS("Gauntlets"), CHEST_ARMOR("Chest Armor"), LEG_ARMOR("Leg Armor");

    private static final String[] IGNORED = { "Hunter Cloak", "Titan Mark", "Warlock Bond", "Item", "Any" };

    private final String string;

    Type(String string) {
        this.string = string;
    }

    @Override
    public String getString() {
        return string;
    }

    @Override
    public Column[] getValues() {
        return Type.values();
    }

    @Override
    public Column getNull() {
        return NULL;
    }

    @Override
    public String getFirstString() {
        return getString().split(" ")[0];
    }

    @Override
    public String[] getIgnoredValues() {
        return IGNORED;
    }

}
