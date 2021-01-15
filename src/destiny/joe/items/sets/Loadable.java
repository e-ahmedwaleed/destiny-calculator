package destiny.joe.items.sets;

import java.util.Observable;

public abstract class Loadable extends Observable {

    public abstract void load();

    void madeProgress() {
        setChanged();
        notifyObservers();
    }

}
