import java.util.ArrayList;
import java.util.List;

// User class
class User {
    protected int userId;
    protected String name;
    protected String email;
    protected String password;

    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void register() {
        System.out.println(name + " registered with email: " + email);
    }

    public void login() {
        System.out.println(name + " logged in with email: " + email);
    }

    public void editProfile(String newName, String newEmail, String newPassword) {
        this.name = newName;
        this.email = newEmail;
        this.password = newPassword;
        System.out.println("Profile updated for user ID " + userId);
    }
}

// Driver class
class Driver extends User {
    private String licenseNumber;

    public Driver(int userId, String name, String email, String password, String licenseNumber) {
        super(userId, name, email, password);
        this.licenseNumber = licenseNumber;
    }

    @Override
    public void register() {
        System.out.println("Driver " + name + " registered with email: " + email + " and license number: " + licenseNumber);
    }

    @Override
    public void login() {
        System.out.println("Driver " + name + " logged in with email: " + email);
    }
}

// Passenger class
class Passenger extends User {
    private String preferences;

    public Passenger(int userId, String name, String email, String password, String preferences) {
        super(userId, name, email, password);
        this.preferences = preferences;
    }

    @Override
    public void register() {
        System.out.println("Passenger " + name + " registered with email: " + email + " and preferences: " + preferences);
    }

    @Override
    public void login() {
        System.out.println("Passenger " + name + " logged in with email: " + email);
    }
}

// Ride class
class Ride {
    private int rideId;
    private String startLocation;
    private String endLocation;
    private String departureTime; // Using String for simplicity
    public int availableSeats;
    private double cost;
    private Driver driver;
    private List<Passenger> passengers;

    public Ride(int rideId, String startLocation, String endLocation, String departureTime, int availableSeats, double cost, Driver driver) {
        this.rideId = rideId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
        this.cost = cost;
        this.driver = driver;
        this.passengers = new ArrayList<>();
    }

    public void createRide() {
        System.out.println("Ride created from " + startLocation + " to " + endLocation + " at " + departureTime);
    }

    public void viewRide() {
        System.out.println("Ride ID: " + rideId);
        System.out.println("From: " + startLocation);
        System.out.println("To: " + endLocation);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Cost: $" + cost);
        System.out.println("Driver: " + driver.name);
        System.out.print("Passengers: ");
        for (Passenger p : passengers) {
            System.out.print(p.name + " ");
        }
        System.out.println();
    }

    public void cancelRide() {
        System.out.println("Ride ID " + rideId + " has been cancelled.");
    }

    public void addPassenger(Passenger passenger) {
        if (availableSeats > 0) {
            passengers.add(passenger);
            availableSeats--;
            System.out.println("Passenger " + passenger.name + " added to the ride.");
        } else {
            System.out.println("No available seats for passenger " + passenger.name);
        }
    }

    public void removePassenger(Passenger passenger) {
        if (passengers.remove(passenger)) {
            availableSeats++;
            System.out.println("Passenger " + passenger.name + " removed from the ride.");
        } else {
            System.out.println("Passenger " + passenger.name + " not found in the ride.");
        }
    }
}

// RideRequest class
class RideRequest {
    private int requestId;
    private String status; // "Pending", "Accepted", "Rejected"
    private Ride ride;
    private Passenger passenger;

    public RideRequest(int requestId, String status, Ride ride, Passenger passenger) {
        this.requestId = requestId;
        this.status = status;
        this.ride = ride;
        this.passenger = passenger;
    }

    public void requestRide() {
        if (ride.availableSeats > 0) {
            status = "Accepted";
            ride.addPassenger(passenger);
            System.out.println("Ride request accepted for passenger " + passenger.name);
        } else {
            status = "Rejected";
            System.out.println("Ride request rejected for passenger " + passenger.name);
        }
    }

    public void cancelRequest() {
        if (status.equals("Accepted")) {
            ride.removePassenger(passenger);
        }
        status = "Cancelled";
        System.out.println("Ride request cancelled for passenger " + passenger.name);
    }

    public void viewRequestStatus() {
        System.out.println("Ride request ID: " + requestId + " Status: " + status);
    }
}

public class TravelConnect {
    public static void main(String[] args) {
        // Sample usage of the classes
        Driver driver = new Driver(1, "Ali", "ali@gmail.com", "764123", "L123456");
        Passenger passenger1 = new Passenger(2, "Moiz", "moiz@gemail.com", "84170", "Non-smoker");
        Passenger passenger2 = new Passenger(3, "Alisha", "alisha34@gmail.com", "427194", "Window seat");

        driver.register();
        passenger1.register();
        passenger2.register();

        driver.login();
        passenger1.login();
        passenger2.login();

        Ride ride = new Ride(1, "Location A", "Location B", "2024-05-20 10:00", 3, 15.0, driver);
        ride.createRide();
        ride.viewRide();

        RideRequest request1 = new RideRequest(1, "Pending", ride, passenger1);
        RideRequest request2 = new RideRequest(2, "Pending", ride, passenger2);

        request1.requestRide();
        request2.requestRide();

        ride.viewRide();

        request1.viewRequestStatus();
        request2.viewRequestStatus();

        request1.cancelRequest();
        ride.viewRide();}
    }


