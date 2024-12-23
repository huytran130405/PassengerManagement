import java.util.*;

public class UpdatePassenger {

    private PassengerManagement passengerManagement;

    public UpdatePassenger(PassengerManagement passengerManagement) {
        this.passengerManagement = passengerManagement;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID to update: ");
        String id = scanner.nextLine().trim(); // Loại bỏ khoảng trắng thừa

        // Tìm hành khách cần cập nhật
        Passenger passengerToUpdate = passengerManagement.findPassenger(id);
        if (passengerToUpdate != null) {
            System.out.println("Passenger found: ");
            System.out.println("Current Information:");
            System.out.println("Name: " + passengerToUpdate.getName());
            System.out.println("Age: " + passengerToUpdate.getAge());
            System.out.println("Gender: " + passengerToUpdate.getGender());
            System.out.println("Phone: " + passengerToUpdate.getPhoneNumber());

            // Nhập thông tin mới
            System.out.print("Enter new Name (leave blank to keep current): ");
            String newName = scanner.nextLine().trim();
            System.out.print("Enter new Age (leave blank to keep current): ");
            String newAgeInput = scanner.nextLine().trim();
            System.out.print("Enter new Gender (leave blank to keep current): ");
            String newGender = scanner.nextLine().trim();
            System.out.print("Enter new Phone Number (leave blank to keep current): ");
            String newPhoneNumber = scanner.nextLine().trim();

            // Cập nhật thông tin nếu cần
            if (!newName.isEmpty()) {
                passengerToUpdate.setName(newName);
            }
            if (!newAgeInput.isEmpty()) {
                try {
                    int newAge = Integer.parseInt(newAgeInput);
                    passengerToUpdate.setAge(newAge);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age input. Keeping current age.");
                }
            }
            if (!newGender.isEmpty()) {
                passengerToUpdate.setGender(newGender);
            }
            if (!newPhoneNumber.isEmpty()) {
                passengerToUpdate.setPhoneNumber(newPhoneNumber);
            }

            // Lưu thay đổi vào danh sách
            passengerManagement.updatePassenger(passengerToUpdate);
            System.out.println("Passenger updated successfully.");
        } else {
            System.out.println("Passenger not found.");
        }
    }
}

