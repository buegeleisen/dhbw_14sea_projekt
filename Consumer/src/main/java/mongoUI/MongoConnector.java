package mongoUI;

/**
 * Created by mrpon on 17.10.2016.
 */
public class MongoConnector {
    private static final String mongoString = "localhost:3001";
    private String connectionString;

    // Connection
    public MongoConnector(){
        connectionString = mongoString;
    }

    public MongoConnector(String connectionString){
        this.connectionString = connectionString;
    }

    public MongoConnector(String ip, String port){
        this.connectionString = ip + ":" + port;
    }

    

}
