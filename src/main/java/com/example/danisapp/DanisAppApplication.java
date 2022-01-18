package com.example.danisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@SpringBootApplication
public class DanisAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanisAppApplication.class, args);
	}
	@RestController
	@RequestMapping("/getCurrentTime/{name}")
	public class RoomController{
		@GetMapping
		public String rooms (@PathVariable String name){
			return "Hey " + name + "! The current time is: " + LocalDateTime.now().toString();
		}
	}
}
