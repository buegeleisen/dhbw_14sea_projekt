package objects;

import java.util.Vector;

/**
 * Created by migue on 15.11.2016.
 */
public class ModifiedMessage {
    private Vector<String> drillingHeat;
    private Vector<String> drillingSpeed;
    private Vector<String> millingHeat;
    private Vector<String> millingSpeed;

    public ModifiedMessage(Vector<String> millingHeat, Vector<String> millingSpeed, Vector<String> drillingHeat, Vector<String> drillingSpeed){
        this.millingHeat=millingHeat;
        this.millingSpeed=millingSpeed;
        this.drillingHeat=drillingHeat;
        this.drillingSpeed=drillingSpeed;
    }
}
