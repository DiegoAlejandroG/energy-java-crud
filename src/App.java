import java.util.Scanner;
import service.EnergyService;
import model.EnergySource;
import model.Country;
import model.EnergyRecord;
import model.Region;

public class App {
    public static void main(String[] args) {

        // Initialize services
        EnergyService energyService = new EnergyService();
        Scanner scanner = new Scanner(System.in);

        // Boolean and loop for menu
        boolean running = true;

        while (running) {
            System.out.println("Energy Management System");
            System.out.println("1. Add Energy Record");
            System.out.println("2. View All Records");
            System.out.println("3. Calculate Total Production by Year");
            System.out.println("4. Update Record");
            System.out.println("5. Delete Record");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            // choice input from the user by the scanner
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Energy Record
                    System.out.print("Enter Region Name: ");
                    String regionName = scanner.next();

                    System.out.print("Enter Country Name: ");
                    String countryName = scanner.next();

                    System.out.print("Enter Energy Source Name: ");
                    String sourceName = scanner.next();

                    System.out.print("Enter the Year: ");
                    int year = scanner.nextInt();

                    System.out.print("Enter Production value: ");
                    double production = scanner.nextDouble();

                    boolean created = energyService.addRecord(
                            new Region(regionName),
                            new Country(countryName, null),
                            new EnergySource(sourceName, "Renewable"),
                            year,
                            production);

                    if (created) {
                        System.out.println("Energy Record Added Successfully!");
                    } else {
                        System.out.println("Error: Invalid data. Record not created.");
                    }

                    break;

                case 2:
                    // View All Records
                    if (energyService.getAllRecords().isEmpty()) {
                        System.out.println("No records available.");
                        break;
                    }
                    System.out.println("All Energy Records:");
                    for (model.EnergyRecord rec : energyService.getAllRecords()) {
                        System.out.println("Region: " + rec.getRegion().getName() +
                                "| ID: " + rec.getId() +
                                "| Country: " + rec.getCountry().getName() +
                                "| Source: " + rec.getEnergySource().getName() +
                                "| Type: " + rec.getEnergySource().getType() +
                                "| Year: " + rec.getYear() +
                                "| Production: " + rec.getProduction());
                    }
                    break;

                case 3:
                    // Calculate Total Production by Year
                    if (energyService.getAllRecords().isEmpty()) {
                        System.out.println("No records available to calculate.");
                        break;
                    }
                    System.out.print("Enter Year to Calculate Total Production: ");
                    int calcYear = scanner.nextInt();
                    double totalProduction = energyService.getTotalProductionByYear(calcYear);
                    System.out.println("Total Production in " + calcYear + ": " + totalProduction);
                    break;

                case 4:
                    // Update Record
                    System.out.print("Enter Record ID: ");
                    int idToEdit = scanner.nextInt();

                    System.out.println("What do you want to update?");
                    System.out.println("1. Production");
                    System.out.println("2. Year");
                    System.out.print("Choose option: ");
                    int updateOption = scanner.nextInt();

                    boolean updated = false;

                    switch (updateOption) {
                        case 1:
                            System.out.print("Enter new production value: ");
                            double newProduction = scanner.nextDouble();
                            updated = energyService.updateProductionById(idToEdit, newProduction);
                            break;

                        case 2:
                            System.out.print("Enter new year: ");
                            int newYear = scanner.nextInt();
                            updated = energyService.updateYearById(idToEdit, newYear);
                            break;

                        default:
                            System.out.println("Invalid update option.");
                            break;
                    }

                    if (updated) {
                        System.out.println("Record updated successfully.");
                    } else {
                        System.out.println("Error: Record not found or invalid data.");
                    }
                    break;

                case 5:
                    // Delete Record
                    System.out.print("Enter Record ID to Delete: ");
                    int idToDelete = scanner.nextInt();
                    boolean deleted = energyService.deleteById(idToDelete);
                    if (deleted) {
                        System.out.println("Record deleted successfully.");
                    } else {
                        System.out.println("Record not found.");
                    }
                    break;

                case 6:
                    // Exit
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");

            }

        }
        scanner.close();
    }

}
