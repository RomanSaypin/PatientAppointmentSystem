package ru.roman_sayapin.patient_appointment_system.DataBase.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "time_slot", schema = "public", catalog = "DataBase")
public class TimeSlotEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "doctor_id", nullable = true)
    private Integer doctorId;
    @Basic
    @Column(name = "patient_id", nullable = true)
    private Integer patientId;
    @Basic
    @Column(name = "start_time", nullable = true)
    private Timestamp startTime;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorsEntity doctors;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private PatientsEntity patients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlotEntity that = (TimeSlotEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(doctorId, that.doctorId)
                && Objects.equals(patientId, that.patientId)
                && Objects.equals(startTime, that.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorId, patientId, startTime);
    }

    public DoctorsEntity getDoctors() {
        return doctors;
    }

    public void setDoctorsByDoctorId(DoctorsEntity doctors) {
        this.doctors = doctors;
    }

    public PatientsEntity getPatientsByPatientId() {
        return patients;
    }

    public void setPatientsByPatientId(PatientsEntity patients) {
        this.patients = patients;
    }
}
