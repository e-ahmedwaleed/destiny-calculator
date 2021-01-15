package destiny.joe.items;

import destiny.joe.utils.FileReader;

public class ItemTierStat {

    private ItemTierStat() {
    }

    private static int[][] tierRatios;
    private static int[][] cooldownTiers;

    static {
        cooldownTiers = readIntArray(new FileReader("destiny-calculator_data/cooldowns.csv", ",").read());
        tierRatios = readIntArray(new FileReader("destiny-calculator_data/tier-ratios.csv", ",").read());
    }

    public static int getTierRatios(int i, int j) {
        return tierRatios[i][j];
    }

    public static int getCooldownTiers(int i, int j) {
        return cooldownTiers[i][j];
    }

    private static int[][] readIntArray(String[][] stringArr) {
        int[][] intArr = new int[stringArr.length][stringArr[0].length];

        for (int i = 0; i < intArr.length; i++)
            for (int j = 0; j < intArr[0].length; j++)
                intArr[i][j] = Integer.parseInt(stringArr[i][j]);

        return intArr;
    }

}
