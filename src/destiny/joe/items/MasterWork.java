package destiny.joe.items;

public enum MasterWork implements Column {
    MW_0(0), MW_1(1), MW_2(2), MW_3(3), MW_4(4), MW_5(5), MW_6(6), MW_7(7), MW_8(8), MW_9(9), MW_10(10);

    private final int value;

    private MasterWork(int value) {
        this.value = value;
    }

    public int teir() {
        return value;
    }

    public static Column identifyColumn(String s) {
        for (MasterWork c : MasterWork.values()) {
            if (c.value == Integer.parseInt(s.trim()))
                return c;
        }
        System.out.println("Unkown master work!");
        return MW_0;
    }
}
