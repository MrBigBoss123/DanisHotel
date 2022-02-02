package com.example.danisapp;

import com.example.danisapp.data.Guest;
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

    @RestController
    public class RoomController {
        public ArrayList<Guest> ravensGuests = new ArrayList<>();

        public RoomController() {
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

        @GetMapping("/RegisterGuest/{firstName}/{lastName}/{country}/{state}/{city}/{address}/{email}/{phoneNumber}")
        public void registerGuest(
                @PathVariable String firstName,
                @PathVariable String lastName,
                @PathVariable String country,
                @PathVariable String state,
                @PathVariable String city,
                @PathVariable String address,
                @PathVariable String email,
                @PathVariable String phoneNumber) {
            Guest guest1 = new Guest();
            guest1.setFirstName(firstName);
            guest1.setCountry(country);
            guest1.setState(state);
            guest1.setCity(city);
            guest1.setAddress(address);
            guest1.setEmailAddress(email);
            guest1.setPhoneNumber(phoneNumber);

            ravensGuests.add(guest1);
            System.out.println("Hey " + firstName + " " + lastName);
        }

        @GetMapping("/guests")
        public String guests() {
            return ravensGuests.toString();
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
            //ravensRooms.add(roomA2);
            return ravensRooms.toString();
        }

    }
}
