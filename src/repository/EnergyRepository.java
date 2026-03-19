package repository;
import model.EnergyRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnergyRepository {

    private List<EnergyRecord> records = new ArrayList<>();

    public void save(EnergyRecord record) {
        records.add(record);
    }

    public List<EnergyRecord> findAll() {
        return records;
    }

    public EnergyRecord findById(int id) {
        for (EnergyRecord record : records) {
            if (record.getId() == id) {
                return record;
            }
        }
        return null;
    }

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
