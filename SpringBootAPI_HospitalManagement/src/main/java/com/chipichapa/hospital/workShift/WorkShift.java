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


}
