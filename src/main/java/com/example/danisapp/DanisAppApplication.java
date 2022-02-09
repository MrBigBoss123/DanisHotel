package com.example.danisapp;

import com.example.danisapp.data.Guest;
import com.example.danisapp.data.GuestValidator;
import com.example.danisapp.data.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class DanisAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DanisAppApplication.class, args);
    }

    class Status {
        int code;
        String message;

        public Status(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    @RestController
    public class RoomController {
        public ArrayList<Guest> ravensGuests = new ArrayList<>();

        public RoomController() {
            // Set up default guests...
            Guest guest1 = new Guest();
            guest1.setCountry("USA");
            guest1.setState("California");
            guest1.setAddress("1234SesameStreet");
            guest1.setFirstName("Cookie");
            guest1.setLastName("Monster");
            guest1.setEmailAddress("Cookie.Monster123@gmail.com");
            guest1.setPhoneNumber("(408)-123-4567");
            guest1.setGuestId(12345);

            Guest guest2 = new Guest();
            guest2.setCountry("Canada");
            guest2.setState("BC");
            guest2.setCity("CloudyVale");
            guest2.setAddress("54321CanadaAve");
            guest2.setFirstName("Hockey");
            guest2.setLastName("Player");
            guest2.setEmailAddress("Hockey.lover<3@gmail.com");
            guest2.setPhoneNumber("(514)-123-4567");
            guest2.setGuestId(12346);

            ravensGuests.add(guest1);
            ravensGuests.add(guest2);
        }

        @GetMapping("/GetCurrentTime/{name}")
        public String rooms(@PathVariable String name) {
            return "Hey " + name + "! The current time is: " + LocalDateTime.now().toString();
        }

        @PostMapping(value = "/RegisterGuest",
                consumes = "application/json",
                produces = "application/json"
        )
        public Status registerGuest(
                @RequestBody Guest guest) {
            if (GuestValidator.isEmailValid(guest.getEmailAddress())) {
                ravensGuests.add(guest);
                System.out.println("Registered: " + guest.toString());
                return new Status(0, "");
            } else {
                System.out.println("Invalid email");
                return new Status(1, "Invalid Email");

            }

        }

        @GetMapping("/guests")
        public String guests() {
            String outputString = "<h1> You have " + ravensGuests.size() + " guests!</h1>";
            for (Guest guest : ravensGuests) {
                outputString = outputString + guest.toString() + "<br>";
            }
            return outputString;
        }

        @GetMapping("/rooms")
        public String rooms() {
            Room roomA1 = new Room();
            roomA1.setRoomNumber("A1");
            roomA1.setRoomName("pentHouse");
            roomA1.setRoomId(1028956734L);
            roomA1.setBedInfo("2K3Q2T11C");
            roomA1.setBathroomInfo("2b3s1t");
            ArrayList<Room> ravensRooms = new ArrayList<>();
            ravensRooms.add(roomA1);
            return ravensRooms.toString();
        }

    }
}
