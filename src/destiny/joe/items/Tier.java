package destiny.joe.items;

public enum Tier implements Column {
    NULL, RARE, LEGENDARY, EXOTIC;

    public static Column identifyColumn(String s) {
        for (Column c : Tier.values()) {
            if (c.toString().compareToIgnoreCase(s.trim()) == 0)
                return c;
        }
        System.out.println("Unkown tier!");
        return NULL;
    }
}
