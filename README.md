TRAVEL CONNECT:
Detailed code Logic And Appraoches;
This code models a simple ride-sharing system with key functionalities for managing users, drivers, passengers, rides, and ride requests. Here's a detailed breakdown of the logic and approaches used:
1. Class Hierarchy and Relationships:
   
•	Class Hierarchy:
User (Abstract Parent Class)
Admin (Child Class)
Passenger (Child Class)
Driver (Child Class)
•	Relationships:
A Ride has a start location, end location, departure time, available seats, cost, an associated driver, and a list of passengers.
A Driver can have multiple rides.
A Passenger is associated with a ride through a ride request.
User can be an Admin, Passenger, or Driver, each with different capabilities.


3. Class Definitions and Responsibilities
•User Class: An abstract class defining common properties and methods for users, such as user ID, name, email, and password. Subclasses add specific properties and methods for different types of users.
•Admin Class: A subclass of User that allows managing rides and users. Methods include adding and removing rides and managing user accounts.
•Driver Class: A subclass of User that defines a driver with additional properties like license number. Methods specific to drivers, such as creating and managing rides, are included.
•Passenger Class: A subclass of User that defines a passenger with additional properties like preferences. Methods specific to passengers, such as booking and canceling rides, are included.
•Ride Class: Manages ride details including ride ID, start location, end location, departure time, available seats, cost, driver, and passengers. Methods to create a ride, view ride details, add and remove passengers are included.
•RideRequest Class: Represents a request for a ride by a passenger. Includes properties such as request ID, status (pending, accepted, rejected), ride, and passenger. Methods to request and cancel a ride are included.

4. User Interaction Logic:
•	Admin Actions: Admins can add and remove rides and manage user accounts through a command-line interface (CLI). They interact with the system to oversee and manage ride and user data.
•	Driver Actions: Drivers can create and manage rides. They can also view their rides and manage passenger lists.
•	Passenger Actions: Passengers can book rides, cancel bookings, and view their booked rides through a CLI. The system checks for available seats and manages passenger reservations.
