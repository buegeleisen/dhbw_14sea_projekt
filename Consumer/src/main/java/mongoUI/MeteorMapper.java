package mongoUI;

import com.google.gson.Gson;
import objects.KafkaMessage;
import objects.LiveItem;
import objects.Point;
import objects.Product;

/**
 * Created by mrpon on 17.10.2016.
 */
public class MeteorMapper {
    private MeteorMongoConnector meteorMongoConnector;
    private Gson gson = new Gson();

    public MeteorMapper(){
        //init Connector with standard ip and port
        meteorMongoConnector = new MeteorMongoConnector();

    }

    public void map(KafkaMessage message) {
        if (!message.getValue().toString().equals("true") && !message.getValue().toString().equals("false")) {
            String itemName = message.getItemName();

            //Insert a simple xy point into DB
            Point point = new Point(Double.parseDouble(message.getTimestamp().toString()), Double.parseDouble(message.getValue()));
            String json = gson.toJson(point);

            if (itemName.equals("MILLING_SPEED")) {
                meteorMongoConnector.insertJSON(json, "millingspeeddata");
            } else if (itemName.equals("MILLING_HEAT")) {
                meteorMongoConnector.insertJSON(json, "millingheatdata");
            } else if (itemName.equals("DRILLING_SPEED")) {
                meteorMongoConnector.insertJSON(json, "drillingspeeddata");
            } else if (itemName.equals("DRILLING_HEAT")) {
                meteorMongoConnector.insertJSON(json, "drillingheatdata");
            }
        }
    }
    public void sendStatus(KafkaMessage message){
        if(message.getValue().toString().equals("true")){
            String itemName=message.getItemName();
            LiveItem liveItem=new LiveItem(itemName);
            String json=gson.toJson(liveItem);
            meteorMongoConnector.insertJSON(json, "machinestatus");
        }
    }
    public void sendProduct(Product product){
        String json=gson.toJson(product);
        meteorMongoConnector.insertJSON(json, "products");
    }
}
