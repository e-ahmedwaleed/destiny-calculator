package destiny.joe.items.enums;

public enum Tier implements Column {
    NULL("-"), RARE("Rare"), LEGENDARY("Legendary"), EXOTIC("Exotic");

    private final String string;

    Tier(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public Column[] getValues() {
        return Tier.values();
    }

    public Column getNull() {
        return NULL;
    }

}
