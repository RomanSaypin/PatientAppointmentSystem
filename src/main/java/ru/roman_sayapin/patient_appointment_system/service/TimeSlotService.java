package ru.roman_sayapin.patient_appointment_system.service;

import ru.roman_sayapin.patient_appointment_system.DataBase.entity.TimeSlotEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TimeSlotService {
    List<TimeSlotEntity> getAllSlot();
    List<TimeSlotEntity> getAllSlotByDoctorId(Long doctorID);
    List<TimeSlotEntity> getAllSlotByPatientId(Long patientID);
    List<TimeSlotEntity> getAllSlotByDoctorIdANDPatientId(Long doctorID, Long patientID);
    void save(TimeSlotEntity entity);
    Optional<TimeSlotEntity> getSlotID(Long id);
    List<TimeSlotEntity> getAllByDoctorIdAndTime(Long id, LocalDate date);


}
