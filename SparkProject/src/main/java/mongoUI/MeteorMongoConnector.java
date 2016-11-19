package mongoUI;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by mrpon on 17.10.2016.
 */
public class MeteorMongoConnector {
    private static final String standardMeteorIp = "localhost";
    private static final Integer standardMeteorPort = 3001;
    private MongoDatabase database;
    private MongoClient mongoClient;

    // Connection
    public MeteorMongoConnector(){
        mongoClient = new MongoClient(standardMeteorIp , standardMeteorPort);
        database =mongoClient.getDatabase("meteor");
    }

    public MeteorMongoConnector(String ip, String port){
        mongoClient = new MongoClient(ip , Integer.parseInt(port));
    }

    public MeteorMongoConnector(String ip, Integer port){
        mongoClient = new MongoClient(ip , port);
    }


    public void insertJSON(String JsonString, String databaseString, String collectionString){
       database = mongoClient.getDatabase(databaseString);
        Document document = Document.parse(JsonString);
        MongoCollection<Document> mongoCollection = database.getCollection(collectionString);
        mongoCollection.insertOne(document);
    }

    public void insertJSON(String JsonString, String collection){
        Document document = Document.parse(JsonString);
        MongoCollection<Document> mongoCollection = database.getCollection(collection);
        mongoCollection.insertOne(document);
    }




    public static String getStandardMeteorIp() {
        return standardMeteorIp;
    }

    public static Integer getStandardMeteorPort() {
        return standardMeteorPort;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
}
