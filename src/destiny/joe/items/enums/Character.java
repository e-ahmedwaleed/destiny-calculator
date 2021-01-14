package destiny.joe.items.enums;

public enum Character implements ItemProperty.Categorial, ItemProperty.HasIgnored {
    NULL("-"), HUNTER("Hunter"), TITAN("Titan"), WARLOCK("Warlock");

    private static final String[] IGNORED = { "Character", "" };

    private final String string;

    Character(String string) {
        this.string = string;
    }

    @Override
    public String getString() {
        return string;
    }

    @Override
    public Categorial[] getValues() {
        return Character.values();
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
