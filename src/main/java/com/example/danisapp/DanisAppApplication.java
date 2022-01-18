package com.example.danisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
public class DanisAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanisAppApplication.class, args);
	}
	@RestController
	@RequestMapping("/getCurrentTime")
	public class RoomController{
		@GetMapping
		public String rooms (){
			return "Hey Dani! The current time is: " + LocalDateTime.now().toString();
		}
	}
}
