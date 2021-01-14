package destiny.joe.items.enums;

public enum MasterWork implements ItemProperty.Categorial, ItemProperty.MultiWords, ItemProperty.HasIgnored {
    NULL("-"), ARC("Arc Energy Capacity"), SOLAR("Solar Energy Capacity"), VOID("Void Energy Capacity");

    private static final String[] IGNORED = { "Type", "Any" };

    private final String string;

    MasterWork(String string) {
        this.string = string;
    }

    @Override
    public String getString() {
        return string;
    }

    @Override
    public Categorial[] getValues() {
        return MasterWork.values();
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
