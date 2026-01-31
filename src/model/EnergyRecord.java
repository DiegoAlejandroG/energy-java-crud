package model;

public class EnergyRecord {
    private int id;
    private Region region;
    private Country country;
    private EnergySource energySource;
    private int year;
    private double production;

    public EnergyRecord(Region regionName, Country country, EnergySource energySource, int year, double production) {
        // Initialize all fields
        this.region = regionName;
        this.country = country;
        this.energySource = energySource;
        this.year = year;
        this.production = production;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Region getRegion() {
        return region;
    }

    public Country getCountry() {
        return country;
    }

    public EnergySource getEnergySource() {
        return energySource;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
    public void setProduction(double production) {
        this.production = production;
    }

    public double getProduction() {
        return production;
    }
}
