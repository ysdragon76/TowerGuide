package com.oawg.io.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yilongsun on 6/19/18.
 */
@Embeddable
@Access(AccessType.FIELD)
public class EntryKey implements Serializable {

    public EntryKey() {
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

    public EntryKey(Double longitude, Double latitude) {
        Longitude = longitude;
        Latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntryKey)) return false;

        EntryKey entryKey = (EntryKey) o;

        if (!getLongitude().equals(entryKey.getLongitude())) return false;
        return getLatitude().equals(entryKey.getLatitude());
    }

    @Override
    public int hashCode() {
        int result = getLongitude().hashCode();
        result = 31 * result + getLatitude().hashCode();
        return result;
    }

    @Column(name = "Longitude", nullable = false)
    private Double Longitude;

    @Column(name = "private Double Latitude;", nullable = false)
    private Double Latitude;
}
