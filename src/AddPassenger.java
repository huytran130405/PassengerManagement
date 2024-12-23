import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class AddPassenger {
    private PassengerManagement passengerManagement;

    // Constructor nhận PassengerManagement để thao tác trực tiếp với danh sách hành khách
    public AddPassenger(PassengerManagement passengerManagement) {
        this.passengerManagement = passengerManagement;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Passenger newPassenger = new Passenger(id, name, age, gender, phoneNumber);

        // Thêm hành khách vào danh sách và lưu vào file
        passengerManagement.addPassenger(newPassenger);

        System.out.println("Passenger added successfully!");
    }
}

