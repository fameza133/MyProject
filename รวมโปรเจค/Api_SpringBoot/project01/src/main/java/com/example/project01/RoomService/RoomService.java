package com.example.project01.RoomService;

import com.example.project01.RoomModel.Room;

import com.example.project01.RoomRepository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room updateRoom(Room room1) {
        return  roomRepository.save(room1);
    }

    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }
}
