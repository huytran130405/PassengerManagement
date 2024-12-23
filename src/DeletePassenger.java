import java.io.*;
import java.util.*;

public class DeletePassenger {
    private PassengerManagement passengerManagement;

    // Constructor nhận đối tượng PassengerManagement
    public DeletePassenger(PassengerManagement passengerManagement) {
        this.passengerManagement = passengerManagement;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        // Nhập ID hành khách cần xóa
        System.out.print("Enter ID to delete: ");
        String id = scanner.nextLine();

        // Tìm hành khách theo ID
        Passenger passenger = passengerManagement.findPassenger(id);

        if (passenger == null) {
            // Nếu không tìm thấy, thông báo cho người dùng
            System.out.println("Passenger with the given ID does not exist.");
            return;
        }

        // Xóa hành khách khỏi danh sách
        passengerManagement.deletePassenger(id);
        System.out.println("Passenger deleted successfully!");
    }


}

