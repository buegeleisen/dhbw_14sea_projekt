package objects;

import com.google.gson.Gson;

import java.math.BigInteger;
import java.util.Vector;


/**
 * Created by migue on 04.11.2016.
 */
public class testObjects {
    Gson gson = new Gson();
    Object object = new Object();
    String string = gson.toJson(object);
    public static void main(String[] args){
        Gson gson = new Gson();
        String testObject1=gson.toJson(createProduct1());
        System.out.println(testObject1);
        String testObject2=gson.toJson(createProduct2());
        System.out.println(testObject2);
        String testObject3=gson.toJson(createProduct3());
        System.out.println(testObject3);
        String testObject4=gson.toJson(createProduct4());
        System.out.println(testObject4);
}
    private static Product createProduct1(){
        BigInteger big=new BigInteger("1475660133002");
        KafkaMessage kafkaMessage1=new KafkaMessage("true","GOOD","L1", big);
        KafkaMessage kafkaMessage2=new KafkaMessage("true","GOOD","L1", big);
        KafkaMessage kafkaMessage3=new KafkaMessage("true","GOOD","L1", big);
        KafkaMessage kafkaMessage4=new KafkaMessage("true","GOOD","L1", big);
        Vector<KafkaMessage> messages=new Vector<KafkaMessage>();
        messages.addElement(kafkaMessage1);
        messages.addElement(kafkaMessage2);
        messages.addElement(kafkaMessage3);
        messages.addElement(kafkaMessage4);
        Activemqmessage activemqMessage=new Activemqmessage(1234,9876,"O1234","123456");
        BigInteger big2=new BigInteger("1476801860834");
        BigInteger big3=new BigInteger("1476801879834");
        ERPFile erpFile=new ERPFile(1819.1362344671954,583.5953675180889,78.51223018253364,32.97513667666413,19244.137007777015,142824.44277387593,"OK",big2,big3);
        Product test=new Product(erpFile,messages,activemqMessage);
        return test;
    }
    private static Product createProduct2(){
        BigInteger big=new BigInteger("1475660133882");
        KafkaMessage kafkaMessage1=new KafkaMessage("true","GOOD","L2", big);
        KafkaMessage kafkaMessage2=new KafkaMessage("true","GOOD","L3", big);
        KafkaMessage kafkaMessage3=new KafkaMessage("123","GOOD","DRILLING_HEAT", big);
        KafkaMessage kafkaMessage4=new KafkaMessage("true","GOOD","L4", big);
        Vector<KafkaMessage> messages=new Vector<KafkaMessage>();
        messages.addElement(kafkaMessage1);
        messages.addElement(kafkaMessage2);
        messages.addElement(kafkaMessage3);
        messages.addElement(kafkaMessage4);
        Activemqmessage activemqMessage=new Activemqmessage(1267,4326,"O1454","123796");
        BigInteger big2=new BigInteger("1476801860999");
        BigInteger big3=new BigInteger("1476801883683");
        ERPFile erpFile=new ERPFile(1837.1362344671954,594.5953675180889,87.51223018253364,35.97513667666413,19644.137007777015,142924.44277387593,"OK",big2,big3);
        Product test=new Product(erpFile,messages,activemqMessage);
        return test;
    }
    private static Product createProduct3(){
        BigInteger big=new BigInteger("14756601348782");
        KafkaMessage kafkaMessage1=new KafkaMessage("true","GOOD","L1", big);
        KafkaMessage kafkaMessage2=new KafkaMessage("false","GOOD","L3", big);
        KafkaMessage kafkaMessage3=new KafkaMessage("123","GOOD","MILLING_HEAT", big);
        KafkaMessage kafkaMessage4=new KafkaMessage("true","GOOD","L5", big);
        Vector<KafkaMessage> messages=new Vector<KafkaMessage>();
        messages.addElement(kafkaMessage1);
        messages.addElement(kafkaMessage2);
        messages.addElement(kafkaMessage3);
        messages.addElement(kafkaMessage4);
        Activemqmessage activemqMessage=new Activemqmessage(1333,4326,"O7154","143896");
        BigInteger big2=new BigInteger("1476801345799");
        BigInteger big3=new BigInteger("1476801887433");
        ERPFile erpFile=new ERPFile(1897.1362344671954,694.5953675180889,97.51223018253364,45.97513667666413,19864.137007777015,147924.44277387593,"OK",big2,big3);
        Product test=new Product(erpFile,messages,activemqMessage);
        return test;
    }
    private static Product createProduct4(){
        BigInteger big=new BigInteger("147566013387452");
        KafkaMessage kafkaMessage1=new KafkaMessage("true","GOOD","L4", big);
        KafkaMessage kafkaMessage2=new KafkaMessage("false","GOOD","L5", big);
        KafkaMessage kafkaMessage3=new KafkaMessage("true","GOOD","L5", big);
        KafkaMessage kafkaMessage4=new KafkaMessage("false","GOOD","L1", big);
        Vector<KafkaMessage> messages=new Vector<KafkaMessage>();
        messages.addElement(kafkaMessage1);
        messages.addElement(kafkaMessage2);
        messages.addElement(kafkaMessage3);
        messages.addElement(kafkaMessage4);
        Activemqmessage activemqMessage=new Activemqmessage(1783,4326,"O7384","154896");
        BigInteger big2=new BigInteger("1476878345799");
        BigInteger big3=new BigInteger("1476878887433");
        ERPFile erpFile=new ERPFile(1997.1362344671954,894.5953675180889,98.51223018253364,75.97513667666413,19974.137007777015,148544.44277387593,"OK",big2,big3);
        Product test=new Product(erpFile,messages,activemqMessage);
        return test;
    }
}
