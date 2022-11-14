package com.fcenesiz.weather;

public class WeatherModel {

    private String id;
    private String name;
    private String state;
    private String minTemp;
    private String maxTemp;

    public WeatherModel(String id, String name, String state, String minTemp, String maxTemp) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", minTemp='" + minTemp + '\'' +
                ", maxTemp='" + maxTemp + '\'' +
                '}';
    }
}
