package com.example.project01.RoomModel;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private String username;
    private double pricePerNight;
}
