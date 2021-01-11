package destiny.joe.items.enums;

public interface Column extends ItemProperty {

    Column getNull();

    String getString();

    Column[] getValues();

    public static Column identifyColumn(String s, Column enumType) {
        for (Column c : enumType.getValues()) {
            if ((c.getString().compareTo(s.trim()) == 0)
                    || (enumType instanceof MasterWork && ((MasterWork) c).type.compareTo(s.trim()) == 0))
                return c;
        }
        if (!isIgnored(s, enumType) && !(enumType instanceof Character))
            System.out.println("Unkown " + enumType.getClass().getName() + "! (" + s + ")");
        return enumType.getNull();
    }

    /// TODO: Mutable fields should not be "public static".
    static final String[] IGNORED = { "Type", "Tier", "Any" };

    static boolean isIgnored(String s, Column enumType) {
        if (enumType instanceof Type) {
            for (String ignored : Type.IGNORED)
                if (s.equals(ignored))
                    return true;
        } else
            for (String ignored : IGNORED)
                if (s.equals(ignored))
                    return true;
        return false;
    }

}
