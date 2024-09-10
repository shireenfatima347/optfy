import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Train {
    private String trainNumber;
    private String source;
    private String destination;
    private int availableSeats;

    public Train(String trainNumber, String source, String destination, int availableSeats) {
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getTrainNumber() {
        return trainNumber;1
        
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void decrementAvailableSeats() {
        availableSeats--;
    }
}

class Passenger {
    private String name;
    private String age;
    private String gender;

    public Passenger(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

class Reservation {
    
    private Passenger passenger;
    private Train train;
    private String reservationStatus;

    public Reservation(Passenger passenger, Train train, String reservationStatus) {
        this.passenger = passenger;
        this.train = train;
        this.reservationStatus = reservationStatus;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }
}

public class RailwayReservationSystem {
    private List<Train> trains;
    private List<Reservation> reservations;
    private Scanner scanner;
    
    public RailwayReservationSystem() {
        this.trains = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Add train");
            System.out.println("2. View train schedule");
            System.out.println("3. Make reservation");
            System.out.println("4. View reservations");
            System.out.println("5. Cancel reservation");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    viewTrainSchedule();
                    break;
                case 2:
                    addTrain();
                    break;
                case 3:
                    makeReservation();
                    break;
                case 4:
                    viewReservations();
                    break;
                case 5:
                    cancelReservation();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void addTrain() {
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter available seats: ");
        int availableSeats = Integer.parseInt(scanner.nextLine());

        Train train = new Train(trainNumber, source, destination, availableSeats);
        trains.add(train);
        System.out.println("Train added successfully!");
    }
    private void viewTrainSchedule()
    {   
        System.out.println("__________________________________________________________________________________________________");
        System.err.println("|                 |                         |                          |                         |");
        System.out.println("| Train Number    |Source                   | Destination              | Avaailiable Seats       |");
        System.out.println("|_________________|_________________________|__________________________|_________________________|");
        System.out.println("| 122221          | Mumbai Central          | Ahmedabad                | 500                     |");
        System.out.println("| 122222          | Kolkata Sealdah         | Pune                     | 500                     |");
        System.out.println("| 122223          | Secunderabad            | Vishakhapatnam           | 500                     |");
        System.out.println("| 122224          | Madurai                 | Chennai Central          | 500                     |");
        System.out.println("| 122225          | Jammu Tawi              | New Delhi                | 500                     |");
        System.out.println("| 122226          | Howrah                  | Ranchi                   | 500                     |");
        System.out.println("|_________________|_________________________|__________________________|_________________________|");
      
    }
    private void makeReservation() {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter passenger age: ");
        String age = scanner.nextLine();
        System.out.print("Enter passenger gender: ");
        String gender = scanner.nextLine();

        Passenger passenger = new Passenger(name, age, gender);

        System.out.println("Available trains:");
        for (Train train : trains) {
            System.out.println(train.getTrainNumber() + " - " + train.getSource() + " to " + train.getDestination());
        }

        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();

        Train train = getTrainByNumber(trainNumber);
        if (train == null) {
            System.out.println("Train not found.");
            return;
        }

        if (train.getAvailableSeats() <= 0) {
            System.out.println("No available seats.");
            return;
        }

        Reservation reservation = new Reservation(passenger, train, "Confirmed");
        reservations.add(reservation);
        train.decrementAvailableSeats();
        System.out.println("Reservation made successfully!");
    }

    private void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println("Passenger: " + reservation.getPassenger().getName());
                System.out.println("Train: " + reservation.getTrain().getTrainNumber());
                System.out.println("Status: " + reservation.getReservationStatus());
                System.out.println("------------------------");
            }
        }
    }
    
    private void cancelReservation() {
        System.out.print("Enter reservation ID: ");
        int reservationID = Integer.parseInt(scanner.nextLine());
    
        Reservation reservation = getReservationById(reservationID);
        if (reservation == null) {
            System.out.println("Reservation not found.");
            return;
        }
    2

        reservations.remove(reservation);
        Train train = reservation.getTrain();
        train.decrementAvailableSeats();
        System.out.println("Reservation cancelled successfully!");
    }
    
    private Train getTrainByNumber(String trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber().equals(trainNumber)) {
                return train;
            }
        }
        return null;
    }
    
    private Reservation getReservationById(int reservationID) {
        for (Reservation reservation : reservations) {
            if (reservations.indexOf(reservation) == reservationID) {
                return reservation;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RailwayReservationSystem railwayReservationSystem = new RailwayReservationSystem();
        while (true) {
            System.out.println("BUS RESERVATION SYSTEM");
            System.out.println("1.Login");
            System.out.println("2.Exit");
            System.out.print("Enter your choice: ");
            int choice=s.nextInt();
            switch (choice) {
                case 1:
                System.out.println("LOGIN");
                System.out.print("Enter Password");
                int password = s.nextInt();
                if (password==123)
                {
                    railwayReservationSystem.run();
                }
                else
                {
                    System.out.println("Incorrect Password , please enter correct password!");
                }
                break;
                case 2:
                System.exit(0);
                System.out.println("_____________________________________________");
                break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                
            }
}
    }
}



    