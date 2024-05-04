package com.chipichapa.hospital.workShift;

import com.chipichapa.hospital.staff.model.Staff;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

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

    @ManyToMany(mappedBy = "workShifts")
    private Set<Staff> staffs;

    public WorkShift(){}

    public WorkShift(long id, LocalDateTime startTime, LocalDateTime endTime, String room, Set<Staff> staffs) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.staffs = staffs;
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

    public Set<Staff> getStaff() {
        return staffs;
    }

    public void setStaff(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
