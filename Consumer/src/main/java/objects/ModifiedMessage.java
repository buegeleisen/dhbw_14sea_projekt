package objects;

import java.util.Vector;

/**
 * Created by migue on 15.11.2016.
 */
public class ModifiedMessage {
    private Vector<Double> drillingHeat;
    private Vector<Double> drillingSpeed;
    private Vector<Double> millingHeat;
    private Vector<Double> millingSpeed;

    public ModifiedMessage(Vector<Double> millingHeat, Vector<Double> millingSpeed, Vector<Double> drillingHeat, Vector<Double> drillingSpeed){
        this.millingHeat=millingHeat;
        this.millingSpeed=millingSpeed;
        this.drillingHeat=drillingHeat;
        this.drillingSpeed=drillingSpeed;
    }
}
