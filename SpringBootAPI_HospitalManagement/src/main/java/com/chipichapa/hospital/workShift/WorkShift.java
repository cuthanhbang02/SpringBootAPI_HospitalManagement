package com.chipichapa.hospital.workShift;

import com.chipichapa.hospital.staff.Doctor;
import com.chipichapa.hospital.staff.Staff;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "work_shift")
public class WorkShift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column
    private String room;

    @OneToOne(mappedBy = "workShifts")
    private Staff staff;

    public WorkShift(){}

    public WorkShift(long id, LocalDateTime startTime, LocalDateTime endTime, String room, Staff staff) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.staff = staff;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
