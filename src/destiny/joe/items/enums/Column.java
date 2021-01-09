package destiny.joe.items.enums;

public interface Column {

    Column getNull();

    String getString();

    Column[] getValues();

    public static Column identifyColumn(String s, Column enumType) {
        for (Column c : enumType.getValues()) {
            if (c.getString().compareTo(s.trim()) == 0)
                return c;
        }
        if (!isIgnored(s, enumType))
            System.out.println("Unkown " + enumType.getClass().getName() + "! (" + s + ")");
        return enumType.getNull();
    }

    static boolean isIgnored(String s, Column enumType) {
        if (enumType instanceof Type)
            for (String ignored : Type.IGNORED)
                if (s.equals(ignored))
                    return true;
        return false;
    }

}