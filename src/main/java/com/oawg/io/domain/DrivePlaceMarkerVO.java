package com.oawg.io.domain;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "drive_master")
public class DrivePlaceMarkerVO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Timestamp Timestamp;
    private Double Longitude;
    private Double Latitude;
    private String Operatorname;
    private String NetworkTech;
    private String NetworkMode;
    private Integer Level;
    private Integer Qual;
    private String SNR;
    private Integer LTERSSI;
    private Integer ARFCN;
    private Integer DL_bitrate;
    private Integer UL_bitrate;
    private String PINGAVG;
    private String PINGMIN;
    private String PINGMAX;
    private String PINGSTDEV;
    private String PINGLOSS;
    private String TESTDOWNLINK;
    private String TESTUPLINK;
    private String TESTDOWNLINKMAX;
    private String TESTUPLINKMAX;
    private String Test_Status;
    private String EVENT;
    private String locSt;
    private String locCnty;

    public DrivePlaceMarkerVO() { }

    public DrivePlaceMarkerVO(Double longitude, Double latitude, String operatorname, String networkTech, String networkMode, Integer level, Integer qual, String SNR, Integer LTERSSI, Integer ARFCN, Integer DL_bitrate, Integer UL_bitrate, String PINGAVG, String PINGMIN, String PINGMAX, String PINGSTDEV, String PINGLOSS, String TESTDOWNLINK, String TESTUPLINK, String TESTDOWNLINKMAX, String TESTUPLINKMAX, String test_Status, String EVENT, String locSt, String locCnty) {
        Longitude = longitude;
        Latitude = latitude;
        Operatorname = operatorname;
        NetworkTech = networkTech;
        NetworkMode = networkMode;
        Level = level;
        Qual = qual;
        this.SNR = SNR;
        this.LTERSSI = LTERSSI;
        this.ARFCN = ARFCN;
        this.DL_bitrate = DL_bitrate;
        this.UL_bitrate = UL_bitrate;
        this.PINGAVG = PINGAVG;
        this.PINGMIN = PINGMIN;
        this.PINGMAX = PINGMAX;
        this.PINGSTDEV = PINGSTDEV;
        this.PINGLOSS = PINGLOSS;
        this.TESTDOWNLINK = TESTDOWNLINK;
        this.TESTUPLINK = TESTUPLINK;
        this.TESTDOWNLINKMAX = TESTDOWNLINKMAX;
        this.TESTUPLINKMAX = TESTUPLINKMAX;
        Test_Status = test_Status;
        this.EVENT = EVENT;
        this.locSt = locSt;
        this.locCnty = locCnty;
    }

    public java.sql.Timestamp getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        Timestamp = timestamp;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public String getOperatorname() {
        return Operatorname;
    }

    public void setOperatorname(String operatorname) {
        Operatorname = operatorname;
    }

    public String getNetworkTech() {
        return NetworkTech;
    }

    public void setNetworkTech(String networkTech) {
        NetworkTech = networkTech;
    }

    public String getNetworkMode() {
        return NetworkMode;
    }

    public void setNetworkMode(String networkMode) {
        NetworkMode = networkMode;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public Integer getQual() {
        return Qual;
    }

    public void setQual(Integer qual) {
        Qual = qual;
    }

    public String getSNR() {
        return SNR;
    }

    public void setSNR(String SNR) {
        this.SNR = SNR;
    }

    public Integer getLTERSSI() {
        return LTERSSI;
    }

    public void setLTERSSI(Integer LTERSSI) {
        this.LTERSSI = LTERSSI;
    }

    public Integer getARFCN() {
        return ARFCN;
    }

    public void setARFCN(Integer ARFCN) {
        this.ARFCN = ARFCN;
    }

    public Integer getDL_bitrate() {
        return DL_bitrate;
    }

    public void setDL_bitrate(Integer DL_bitrate) {
        this.DL_bitrate = DL_bitrate;
    }

    public Integer getUL_bitrate() {
        return UL_bitrate;
    }

    public void setUL_bitrate(Integer UL_bitrate) {
        this.UL_bitrate = UL_bitrate;
    }

    public String getPINGAVG() {
        return PINGAVG;
    }

    public void setPINGAVG(String PINGAVG) {
        this.PINGAVG = PINGAVG;
    }

    public String getPINGMIN() {
        return PINGMIN;
    }

    public void setPINGMIN(String PINGMIN) {
        this.PINGMIN = PINGMIN;
    }

    public String getPINGMAX() {
        return PINGMAX;
    }

    public void setPINGMAX(String PINGMAX) {
        this.PINGMAX = PINGMAX;
    }

    public String getPINGSTDEV() {
        return PINGSTDEV;
    }

    public void setPINGSTDEV(String PINGSTDEV) {
        this.PINGSTDEV = PINGSTDEV;
    }

    public String getPINGLOSS() {
        return PINGLOSS;
    }

    public void setPINGLOSS(String PINGLOSS) {
        this.PINGLOSS = PINGLOSS;
    }

    public String getTESTDOWNLINK() {
        return TESTDOWNLINK;
    }

    public void setTESTDOWNLINK(String TESTDOWNLINK) {
        this.TESTDOWNLINK = TESTDOWNLINK;
    }

    public String getTESTUPLINK() {
        return TESTUPLINK;
    }

    public void setTESTUPLINK(String TESTUPLINK) {
        this.TESTUPLINK = TESTUPLINK;
    }

    public String getTESTDOWNLINKMAX() {
        return TESTDOWNLINKMAX;
    }

    public void setTESTDOWNLINKMAX(String TESTDOWNLINKMAX) {
        this.TESTDOWNLINKMAX = TESTDOWNLINKMAX;
    }

    public String getTESTUPLINKMAX() {
        return TESTUPLINKMAX;
    }

    public void setTESTUPLINKMAX(String TESTUPLINKMAX) {
        this.TESTUPLINKMAX = TESTUPLINKMAX;
    }

    public String getTest_Status() {
        return Test_Status;
    }

    public void setTest_Status(String test_Status) {
        Test_Status = test_Status;
    }

    public String getEVENT() {
        return EVENT;
    }

    public void setEVENT(String EVENT) {
        this.EVENT = EVENT;
    }

    public String getLocSt() {
        return locSt;
    }

    public void setLocSt(String locSt) {
        this.locSt = locSt;
    }

    public String getLocCnty() {
        return locCnty;
    }

    public void setLocCnty(String locCnty) {
        this.locCnty = locCnty;
    }

    @Override
    public String toString() {
        return "DrivePlaceMarkerVO{" +
                "Timestamp=" + Timestamp +
                ", Longitude=" + Longitude +
                ", Latitude=" + Latitude +
                ", Operatorname='" + Operatorname + '\'' +
                ", NetworkTech='" + NetworkTech + '\'' +
                ", NetworkMode='" + NetworkMode + '\'' +
                ", Level=" + Level +
                ", Qual=" + Qual +
                ", SNR='" + SNR + '\'' +
                ", LTERSSI=" + LTERSSI +
                ", ARFCN=" + ARFCN +
                ", DL_bitrate=" + DL_bitrate +
                ", UL_bitrate=" + UL_bitrate +
                ", PINGAVG='" + PINGAVG + '\'' +
                ", PINGMIN='" + PINGMIN + '\'' +
                ", PINGMAX='" + PINGMAX + '\'' +
                ", PINGSTDEV='" + PINGSTDEV + '\'' +
                ", PINGLOSS='" + PINGLOSS + '\'' +
                ", TESTDOWNLINK='" + TESTDOWNLINK + '\'' +
                ", TESTUPLINK='" + TESTUPLINK + '\'' +
                ", TESTDOWNLINKMAX='" + TESTDOWNLINKMAX + '\'' +
                ", TESTUPLINKMAX='" + TESTUPLINKMAX + '\'' +
                ", Test_Status='" + Test_Status + '\'' +
                ", EVENT='" + EVENT + '\'' +
                ", locSt='" + locSt + '\'' +
                ", locCnty='" + locCnty + '\'' +
                '}';
    }
}
