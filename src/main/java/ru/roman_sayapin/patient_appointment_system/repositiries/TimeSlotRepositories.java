package ru.roman_sayapin.patient_appointment_system.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.TimeSlotEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimeSlotRepositories extends JpaRepository<TimeSlotEntity, Long> {

    @Override
    List<TimeSlotEntity> findAll();
    List<TimeSlotEntity> findAllByDoctorId(Long idDoctor);
    List<TimeSlotEntity> findAllByPatientId(Long idPatient);
    List<TimeSlotEntity> findAllByDoctorIdAndPatientId(Long idDoctor, Long idPatient);
    @Override
    Optional<TimeSlotEntity> findById(Long id);
    List<TimeSlotEntity> findAllByDoctorIdAndStartTime(Long id, LocalDate date);



}
