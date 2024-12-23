import java.io.*;
import java.util.*;

public class PassengerManagement {
    private List<Passenger> passengers = new ArrayList<>();
    private final String filePath = "src/passenger.csv";

    public PassengerManagement() {
        loadPassengers();
    }

    // Hàm tải dữ liệu hành khách từ file CSV
    private void loadPassengers() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    Passenger passenger = new Passenger(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    passengers.add(passenger);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm lưu dữ liệu hành khách vào file CSV
    public void savePassengers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Passenger passenger : passengers) {
                bw.write(String.join(",", passenger.getId(), passenger.getName(), String.valueOf(passenger.getAge()), passenger.getGender(), passenger.getPhoneNumber()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm thêm hành khách
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        savePassengers();
    }

    // Hàm xóa hành khách
    public void deletePassenger(String id) {
        passengers.removeIf(passenger -> passenger.getId().equals(id));
        savePassengers();
    }

    // Hàm tìm hành khách
    public Passenger findPassenger(String id) {
        for (Passenger passenger : passengers) {
            if (passenger.getId().equals(id)) {
                return passenger;
            }
        }
        return null;
    }

    // Hàm hiển thị thông tin hành khách
    public void displayPassengers() {
        for (Passenger passenger : passengers) {
            System.out.println("ID: " + passenger.getId() + ", Name: " + passenger.getName() + ", Age: " + passenger.getAge() + ", Gender: " + passenger.getGender() + ", Phone: " + passenger.getPhoneNumber());
        }
    }

    // Hàm cập nhật thông tin hành khách
    public void updatePassenger(Passenger updatedPassenger) {
        for (Passenger passenger : passengers) {
            if (passenger.getId().equals(updatedPassenger.getId())) {
                passenger.setName(updatedPassenger.getName());
                passenger.setAge(updatedPassenger.getAge());
                passenger.setGender(updatedPassenger.getGender());
                passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
                savePassengers();
                break;
            }
        }
    }

    // Hàm chạy hệ thống quản lý hành khách
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Passenger Management System");
            System.out.println("1. Add Passenger");
            System.out.println("2. Delete Passenger");
            System.out.println("3. Find Passenger");
            System.out.println("4. Display Passengers");
            System.out.println("5. Update Passenger");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    new AddPassenger(this).execute();
                    break;
                case 2:
                    new DeletePassenger(this).execute();
                    break;
                case 3:
                    new SearchPassenger(this).execute();
                    break;
                case 4:
                    new DisplayPassenger(this).execute();
                    break;
                case 5:
                    new UpdatePassenger(this).execute();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Getters và Setters cho danh sách hành khách
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
