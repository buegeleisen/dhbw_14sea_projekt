package mongoUI;

import com.google.gson.Gson;
import objects.KafkaMessage;
import objects.Point;

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

    public void map(KafkaMessage message){
        if(!message.getValue().equals("true") || !message.getValue().equals("false")){
            String itemName = message.getItemName();

            //Insert a simple xy point into DB
            Point point = new Point(Double.parseDouble(message.getTimestamp().toString()), Double.parseDouble(message.getValue()));
            String json = gson.toJson(point);

            if(itemName.equals("MILLING_SPEED")){
                meteorMongoConnector.insertJSON(json, "millingspeeddata");
            }else if(itemName.equals("MILLING_HEAT")){
                meteorMongoConnector.insertJSON(json, "millingheatdata");
            }else if(itemName.equals("DRILLING_SPEED")){
                meteorMongoConnector.insertJSON(json, "drillingspeeddata");
            }else if(itemName.equals("DRILLING_HEAT")){
                meteorMongoConnector.insertJSON(json, "drillingheatdata");
            }
        }
    }
}
