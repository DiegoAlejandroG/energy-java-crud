package service;

import java.util.List;
import model.Country;
import model.EnergyRecord;
import model.EnergySource;
import repository.EnergyRepository;


public class EnergyService {
    
    // In-memory storage for energy records
    private EnergyRepository repository = new EnergyRepository();
    private int nextId = 1;
    
    // Constructor
    public EnergyService() {
        this.repository = new EnergyRepository();
    }

    // Method to add/create a new energy record
    public boolean addRecord(model.Region region, Country country, EnergySource source, int year, double production) {

    if (region == null || country == null || source == null) {
        System.out.println("Invalid data: null values not allowed.");
        return false;
    }

    if (year < 1900 || year > 2100) {
        System.out.println("Invalid year.");
        return false;
    }

    if (production < 0) {
        System.out.println("Production cannot be negative.");
        return false;
    }

    EnergyRecord record = new EnergyRecord(nextId++, region, country, source, year, production);
    repository.save(record);
    return true;
}
   
    // Method to retrieve(return/list) all energy records
    public List<EnergyRecord> getAllRecords() {
        return repository.findAll();
    }
    // Method to find a record by ID
    public EnergyRecord findById(int id) {
        return repository.findById(id);
    }

    // Method to calculate total energy production for a specific year
    public double getTotalProductionByYear(int year) {
        double total = 0;
        for (EnergyRecord record : repository.findAll()) {
            if (record.getYear() == year) {
                total += record.getProduction();
            }
        }
        return total;
    }
    // Method to update production value by record ID
    public boolean updateProductionById(int id, double newProduction) {

    if (newProduction < 0) {
        System.out.println("Production cannot be negative.");
        return false;
    }

    EnergyRecord record = repository.findById(id);

    if (record != null) {
        record.setProduction(newProduction);
        return true;
    }

    return false;
}
    // Method to update year by record ID
    public boolean updateYearById(int id, int newYear) {
    if (newYear < 1900 || newYear > 2100) {
        System.out.println("Invalid year.");
        return false;
    }
    EnergyRecord record = repository.findById(id);

    if (record != null) {
        record.setYear(newYear);
        return true;
    }

    return false;
}
    // Method to delete a record by ID
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    


    
}
