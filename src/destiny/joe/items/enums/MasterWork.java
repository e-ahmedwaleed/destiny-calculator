package destiny.joe.items.enums;

public enum MasterWork implements Column {
    NULL("-"), ARC("Arc Energy Capacity"), SOLAR("Solar Energy Capacity"), VOID("Void Energy Capacity");

    private final String string;

    MasterWork(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public Column[] getValues() {
        return MasterWork.values();
    }

    public Column getNull() {
        return NULL;
    }

}
