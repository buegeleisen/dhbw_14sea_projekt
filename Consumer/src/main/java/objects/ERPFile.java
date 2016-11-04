package objects;

import java.math.BigInteger;

/**
 * Created by mrpon on 12.10.2016.
 */
public class ERPFile {
    private double em1;
    private double em2;
    private double a1;
    private double a2;
    private double b1;
    private double b2;
    private String overallStatus;
    private BigInteger ts_start;
    private BigInteger ts_stop;

    public ERPFile(double em1, double em2, double a1, double a2, double b1, double b2, String overallStatus, BigInteger ts_start, BigInteger ts_stop){
        this.em1=em1;
        this.em2=em2;
        this.a1=a1;
        this.a2=a2;
        this.b1=b1;
        this.b2=b2;
        this.overallStatus=overallStatus;
        this.ts_start=ts_start;
        this.ts_stop=ts_stop;
    }
    public double getEm1() {
        return em1;
    }

    public void setEm1(double em1) {
        this.em1 = em1;
    }

    public double getEm2() {
        return em2;
    }

    public void setEm2(double em2) {
        this.em2 = em2;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getB1() {
        return b1;
    }

    public void setB1(double b1) {
        this.b1 = b1;
    }

    public double getB2() {
        return b2;
    }

    public void setB2(double b2) {
        this.b2 = b2;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus;
    }

    public BigInteger getTs_start() {
        return ts_start;
    }

    public void setTs_start(BigInteger ts_start) {
        this.ts_start = ts_start;
    }

    public BigInteger getTs_stop() {
        return ts_stop;
    }

    public void setTs_stop(BigInteger ts_stop) {
        this.ts_stop = ts_stop;
    }
}
