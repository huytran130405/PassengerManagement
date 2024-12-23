import java.io.*;
import java.util.List;

public class DisplayPassenger {
    private PassengerManagement passengerManagement;

    // Constructor nhận đối tượng PassengerManagement
    public DisplayPassenger(PassengerManagement passengerManagement) {
        this.passengerManagement = passengerManagement;
    }

    public void execute() {
        // Lấy danh sách hành khách từ PassengerManagement
        List<Passenger> passengers = passengerManagement.getPassengers();

        if (passengers.isEmpty()) {
            System.out.println("No passengers found.");
            return;
    }

        // Hiển thị danh sách hành khách
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println("ID: " + passenger.getId() + ", Name: " + passenger.getName() +
                    ", Age: " + passenger.getAge() + ", Gender: " + passenger.getGender() +
                    ", Phone: " + passenger.getPhoneNumber());
        }
    }
}

