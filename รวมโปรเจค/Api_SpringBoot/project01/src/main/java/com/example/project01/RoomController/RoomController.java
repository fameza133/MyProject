package com.example.project01.RoomController;

import com.example.project01.RoomModel.Room;

import com.example.project01.RoomService.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/room")
    public Room createRoom (@RequestBody Room room){
        return  roomService.createRoom(room);
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id){
        Room room = roomService.getRoomById(id);
        if (room == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(room);
    }

    @PutMapping("/room/{id}")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room ,@PathVariable Long id){
        Room room1 = roomService.getRoomById(id);
        if (room == null){
            return ResponseEntity.notFound().build();
        }
        room1.setRoomNumber(room.getRoomNumber());
        room1.setUsername(room.getUsername());
        room1.setPricePerNight(room.getPricePerNight());
        Room updateRoom = roomService.updateRoom(room1);
        return ResponseEntity.ok(updateRoom);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRoom(){
        return roomService.getAllRoom();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id){
        Room room = roomService.getRoomById(id);
        if ( room == null)
            return  ResponseEntity.notFound().build();
            roomService.deleteRoom(room);
            return ResponseEntity.ok().build();

    }

}
