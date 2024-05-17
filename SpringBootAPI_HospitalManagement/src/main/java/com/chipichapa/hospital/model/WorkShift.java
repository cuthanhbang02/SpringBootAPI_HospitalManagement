package com.chipichapa.hospital.model;

import com.chipichapa.hospital.model.Staff;
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
    private String startTime;

    @Column
    private String endTime;

    @Column
    private String room;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "staff_work_shift", joinColumns = @JoinColumn(name = "work_shift_id"), inverseJoinColumns = @JoinColumn(name = "staff_id"))

    private Set<Staff> staffs;

    public WorkShift(){}

    public WorkShift(long id, String startTime, String endTime, String room, Set<Staff> staffs) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    public void addStaff(Staff staff) {
        this.staffs.add(staff);
        staff.getWorkShift().add(this);
    }

    public void removeStaff(Long staffId) {
        Staff staff = this.staffs.stream().filter(t -> t.getId() == staffId).findFirst().orElse(null);
        if (staff != null) {
            this.staffs.remove(staff);
            staff.getWorkShift().remove(this);
        }
    }
}
