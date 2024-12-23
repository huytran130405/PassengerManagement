import java.util.Scanner;

public class SearchPassenger {
    private PassengerManagement passengerManagement;

    public SearchPassenger(PassengerManagement passengerManagement) {
        this.passengerManagement = passengerManagement;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID to find: ");
        String id = scanner.nextLine();

        Passenger passenger = passengerManagement.findPassenger(id);

        if (passenger != null) {
            System.out.println("Passenger found: ");
            System.out.println("ID: " + passenger.getId());
            System.out.println("Name: " + passenger.getName());
            System.out.println("Age: " + passenger.getAge());
            System.out.println("Gender: " + passenger.getGender());
            System.out.println("Phone: " + passenger.getPhoneNumber());
        } else {
            System.out.println("Passenger not found.");
        }
    }
}
