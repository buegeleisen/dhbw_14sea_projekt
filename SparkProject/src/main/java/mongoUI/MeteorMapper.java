package mongoUI;

import com.google.gson.Gson;


/**
 * Created by mrpon on 17.10.2016.
 */
public class MeteorMapper {
    private MeteorMongoConnector meteorMongoConnector;

    public MeteorMapper(){
        //init Connector with standard ip and port
        meteorMongoConnector = new MeteorMongoConnector();

    }

    public void sendInteger(int i){
        String json=Integer.toString(i);
        meteorMongoConnector.insertJSON(json, "spark");
    }


}
