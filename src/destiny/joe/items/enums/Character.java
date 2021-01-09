package destiny.joe.items.enums;

public enum Character implements Column {
    NULL("-"), HUNTER("Hunter"), TITAN("Titan"), WARLOCK("Warlock");

    private final String string;

    Character(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public Column[] getValues() {
        return Character.values();
    }

    public Column getNull() {
        return NULL;
    }

}
