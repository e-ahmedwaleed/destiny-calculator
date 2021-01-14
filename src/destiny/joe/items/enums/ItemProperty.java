package destiny.joe.items.enums;

public interface ItemProperty {

    public interface HasIgnored extends ItemProperty {
        String[] getIgnoredValues();
    }

    public interface MultiWords extends ItemProperty {
        String getFirstString();
    }

    public interface Categorial extends ItemProperty {

        Categorial getNull();

        String getString();

        Categorial[] getValues();

        static Categorial identify(String s, Categorial enumType) {
            for (Categorial c : enumType.getValues()) {
                if ((c.getString().compareTo(s.trim()) == 0) || (enumType instanceof MultiWords
                        && ((MultiWords) c).getFirstString().compareTo(s.trim()) == 0))
                    return c;
            }
            if (!isIgnored(s, enumType))
                System.out.println("Unkown " + enumType.getClass().getName() + "! (" + s + ")");
            return enumType.getNull();
        }

        static boolean isIgnored(String s, Categorial enumType) {
            if (enumType instanceof HasIgnored)
                for (String ignored : ((HasIgnored) enumType).getIgnoredValues())
                    if (s.equals(ignored))
                        return true;
            return false;
        }

    }

}
