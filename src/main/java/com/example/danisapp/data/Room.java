package com.example.danisapp.data;

public class Room {
    private Long roomId;
    private String roomName;
    private String roomNumber;
    private String bedInfo;
    private String bathroomInfo;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    public String getBathroomInfo() {
        return bathroomInfo;
    }

    public void setBathroomInfo(String BathroomInfo) {
        this.bathroomInfo = BathroomInfo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", bedInfo='" + bedInfo + '\'' +
                ", bathroomInfo='" + bathroomInfo + '\'' +
                '}';
    }
}
