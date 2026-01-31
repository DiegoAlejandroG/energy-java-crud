package service;
import java.util.List;
import model.EnergyRecord;
import java.util.ArrayList;
import java.util.Iterator;


public class EnergyService {
    // In-memory storage for energy records
    private List<EnergyRecord> records;
    
    // Constructor
    public EnergyService() {
        this.records = new ArrayList<>();
    }

    // Initializing ID counter
    private int nextId = 1;
    // Method to add a new energy record
    public void addRecord(EnergyRecord record) {
        record.setId(nextId++);
        records.add(record);
    }

    //
    /* public void addEnergyRecord(int id, model.Region regionName, Country countryName, EnergySource sourceName, int year, double production) {
        EnergyRecord record = new EnergyRecord(id, regionName, countryName, sourceName, year, production);
        records.add(record);
    } */
   
    // Method to retrieve(return) all energy records
    public List<EnergyRecord> getAllRecords() {
        return records;
    }

    // Method to calculate total energy production for a specific year
    public double getTotalProductionByYear(int year) {
        double total = 0;
        for (EnergyRecord record : records) {
            if (record.getYear() == year) {
                total += record.getProduction();
            }
        }
        return total;
    }
    // Method to update production value by record ID
    public boolean updateProductionById(int id, double newProduction) {
    for (EnergyRecord record : records) {
        if (record.getId() == id) {
            record.setProduction(newProduction);
            return true;
        }
    }
    return false;
    }
    // Method to update year by record ID
    public boolean updateYearById(int id, int newYear) {
    for (EnergyRecord record : records) {
        if (record.getId() == id) {
            record.setYear(newYear);
            return true;
        }
    }
    return false;
    }
    // Method to delete a record by ID
    public boolean deleteById(int id) {
    Iterator<EnergyRecord> iterator = records.iterator();

    while (iterator.hasNext()) {
        EnergyRecord record = iterator.next();

        if (record.getId() == id) {
            iterator.remove();
            return true;
        }
    }

    return false;
    }


    
}
