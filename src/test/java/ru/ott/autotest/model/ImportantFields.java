package ru.ott.autotest.model;

public class ImportantFields {

    private String id;
    private String name;
    private String country;
    private String city_id;
    private String type;
    private String iata;
    private String city_name;
    private String city;


    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' +
                ", city_id='" + city_id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", iata='" + iata + '\'' +
                ", city_name='" + city_name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getType() {
        return type;
    }
    public String getCity_id() {
        return city_id;
    }
    public String getIata() {
        return iata;
    }
    public String getCity_name() {
        return  city_name;
    }
    public String getCity() {
        return  city;
    }


}
