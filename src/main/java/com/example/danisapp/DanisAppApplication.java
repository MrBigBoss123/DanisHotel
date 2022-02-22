package com.example.danisapp;

import com.example.danisapp.data.Guest;
import com.example.danisapp.data.RoomRepository;
import com.example.danisapp.validators.GuestValidator;
import com.example.danisapp.validators.Status;
import com.example.danisapp.data.Room;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
public class DanisAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DanisAppApplication.class, args);
    }


    @RestController
    public class RoomController {
        public ArrayList<Guest> ravensGuests = new ArrayList<>();
        private final RoomRepository roomRepository;

        public RoomController(RoomRepository roomRepository) {
            this.roomRepository = roomRepository;
        }

        @PostMapping(value = "/RegisterGuest",
                consumes = "application/json",
                produces = "application/json"
        )
        public Status registerGuest(
                @RequestBody Guest guest) {
            if (!GuestValidator.isEmailValid(guest.getEmailAddress())) {
                System.out.println("Invalid email");
                return new Status(1, "Invalid Email");
            }
            if (!GuestValidator.isPhoneNumberValid(guest.getPhoneNumber())) {
                System.out.println("Invalid Phone Number");
                return new Status(2, "Invalid Phone Number");
            }
            ravensGuests.add(guest);
            System.out.println("Registered: " + guest.toString());
            return new Status(0, "");
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
            Iterable<Room> rooms = this.roomRepository.findAll();
            rooms.forEach(System.out::println);
            return rooms.toString();
        }

        @PostMapping(value = "/RegisterRoom",
                consumes = "application/json",
                produces = "application/json"
        )
        public Status registerRoom(
                @RequestBody Room room) {
            this.roomRepository.save(room);
            System.out.println("Registered: " + room.toString());
            return new Status(0, "");
        }

    }
}
