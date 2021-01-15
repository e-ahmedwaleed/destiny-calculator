package destiny.joe.gui.helper;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.Label;

import destiny.joe.items.ItemTierStat;
import destiny.joe.items.enums.Character;
import destiny.joe.items.enums.Stat;

public class CooldownsTable extends Observable implements Observer {

    private Character selectedChar;

    private final Label lblAbility;

    /**
     * [0]: Ability. [1]: Grenade. [2]: Super. [3]: Melee.
     */
    private final Label[] cds;

    public CooldownsTable(Observable chooser, Observable[] mods, Label[] cds, Label lblAbility) {
        this.cds = cds;
        this.lblAbility = lblAbility;

        chooser.addObserver(this);
        for (Observable o : mods)
            o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        if (arg instanceof Character) {
            selectedChar = (Character) arg;
            switch (selectedChar) {
            case HUNTER:
                lblAbility.setToolTipText("Decreases by Mobility.");
                break;
            case TITAN:
                lblAbility.setToolTipText("Decreases by Resilience.");
                break;
            case WARLOCK:
                lblAbility.setToolTipText("Decreases by Recovery.");
                break;
            default:
                clearChanged();
                lblAbility.setToolTipText("");
                break;
            }
        } else {
            int tier = (int) arg;
            ModsRow mod = (ModsRow) o;
            updateCooldowns(mod.getDataKey(), tier);
        }
        notifyObservers();
    }

    private void updateCooldowns(Stat stat, int tier) {

        int index = -1;
        switch (stat) {
        case MOBILITY:
            if (selectedChar == Character.HUNTER)
                index = 0;
            break;
        case RESILIENCE:
            if (selectedChar == Character.TITAN)
                index = 0;
            break;
        case RECOVERY:
            if (selectedChar == Character.WARLOCK)
                index = 0;
            break;
        case DISCIPLINE:
            index = 1;
            break;
        case INTELLECT:
            index = 2;
            break;
        case STRENGTH:
            index = 3;
            break;
        default:
            break;
        }

        if (index >= 0) {
            String s = getTierCooldown(stat, tier);

            cds[index].setText(s);
            if (tier < 10)
                cds[index].setToolTipText("Next tier " + getTierCooldown(stat, tier + 1));
            else
                cds[index].setToolTipText("Max tier.");
        }
    }

    private String getTierCooldown(Stat stat, int tier) {
        String s = "-:--";

        int cooldown = ItemTierStat.getCooldownTiers(stat.ordinal() - 1, tier);
        if (cooldown > 0)
            s = cooldown / 100 + ":" + String.format("%02d", cooldown % 100);
        return s;
    }

}
