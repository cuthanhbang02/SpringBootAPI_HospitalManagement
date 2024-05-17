package com.chipichapa.hospital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Staff {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private String dob;

    @Column(name = "start_day")
    private String startDay;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "staffs")
    @JsonIgnore
    private Set<WorkShift> workShifts = new HashSet<>();

    public Staff() {};
    public Staff(Long id, String name, String gender, String dob, String startDay, Set<WorkShift> workShifts) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.startDay = startDay;
        this.workShifts = workShifts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public Set<WorkShift> getWorkShift() {
        return workShifts;
    }

    public void setWorkShift(Set<WorkShift> workShifts) {
        this.workShifts = workShifts;
    }

    public void addWorkShift(WorkShift workShift) {
        this.workShifts.add(workShift);
        workShift.getStaff().add(this);
    }

    public void removeWorkShift(Long workShiftId) {
        WorkShift workShift = this.workShifts.stream().filter(t -> t.getId() == workShiftId).findFirst().orElse(null);
        if (workShift != null) {
            this.workShifts.remove(workShift);
            workShift.getStaff().remove(this);
        }
    }
}
