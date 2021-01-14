package destiny.joe.items.enums;

public enum Type implements ItemProperty.Categorial, ItemProperty.MultiWords, ItemProperty.HasIgnored {
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
    public Categorial[] getValues() {
        return Type.values();
    }

    @Override
    public Categorial getNull() {
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
