package com.bai.models;

import java.util.List;

public class MovieDetails {
    String longDescription;
    List<String> actors;
    String emissionDay;
    String emissionMonth;
    String emissionYear;
    String hour;
    String minute;
    String station;
    String stationLogo;
    String duration;
    String director;
    boolean broadcast;

    public boolean isBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getEmissionDay() {
        return emissionDay;
    }

    public void setEmissionDay(String emissionDay) {
        this.emissionDay = emissionDay;
    }

    public String getEmissionMonth() {
        return emissionMonth;
    }

    public void setEmissionMonth(String emissionMonth) {
        this.emissionMonth = emissionMonth;
    }

    public String getEmissionYear() {
        return emissionYear;
    }

    public void setEmissionYear(String emissionYear) {
        this.emissionYear = emissionYear;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getStationLogo() {
        return stationLogo;
    }

    public void setStationLogo(String stationLogo) {
        this.stationLogo = stationLogo;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
