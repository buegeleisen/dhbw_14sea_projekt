package objects;/** * Created by Uno on 20.10.2016. */public class Activemqmessage {    private int customerno;    private int materialno;    private String orderno;    private String timestamp;    public Activemqmessage(int customerno, int materialno, String orderno, String timestamp) {        this.customerno = customerno;        this.materialno = materialno;        this.orderno = orderno;        this.timestamp = timestamp;    }    public int getCustomerno() {        return customerno;    }    public void setCustomerno(int customerno) {        this.customerno = customerno;    }    public int getMaterialno() {        return materialno;    }    public void setMaterialno(int materialno) {        this.materialno = materialno;    }    public String getOrderno() {        return orderno;    }    public void setOrderno(String orderno) {        this.orderno = orderno;    }    public String getTimestamp() {        return timestamp;    }    public void setTimestamp(String timestamp) {        this.timestamp = timestamp;    }}