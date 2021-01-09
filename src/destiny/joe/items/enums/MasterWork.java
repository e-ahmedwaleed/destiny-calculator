package destiny.joe.items.enums;

public enum MasterWork implements Column {
    NULL("-", "-"), ARC("Arc Energy Capacity", "Arc"), SOLAR("Solar Energy Capacity", "Solar"),
    VOID("Void Energy Capacity", "Void");

    public final String type;
    private final String string;

    MasterWork(String string, String type) {
        this.type = type;
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
