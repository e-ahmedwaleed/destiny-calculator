package destiny.joe.items;

public enum Character implements Column {
    NULL, HUNTER, TITAN, WARLOCK;

    public static Column identifyColumn(String s) {
        for (Column c : Character.values()) {
            if (c.toString().compareToIgnoreCase(s.trim()) == 0)
                return c;
        }
        System.out.println("Unkown character!");
        return NULL;
    }
}
