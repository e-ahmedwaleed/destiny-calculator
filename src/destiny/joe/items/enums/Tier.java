package destiny.joe.items.enums;

public enum Tier implements ItemProperty.Categorial, ItemProperty.HasIgnored {
    NULL("-"), RARE("Rare"), LEGENDARY("Legendary"), EXOTIC("Exotic");

    private static final String[] IGNORED = { "Tier", "Any" };

    private final String string;

    Tier(String string) {
        this.string = string;
    }

    @Override
    public String getString() {
        return string;
    }

    @Override
    public Categorial[] getValues() {
        return Tier.values();
    }

    @Override
    public Categorial getNull() {
        return NULL;
    }

    @Override
    public String[] getIgnoredValues() {
        return IGNORED;
    }

}
