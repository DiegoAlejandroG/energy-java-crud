package model;

public class Country {
    private String name;
    private Region region;

    public Country(String name, Region region) {
        this.name = name;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public Region getRegion() {
        return region;
    }
}
