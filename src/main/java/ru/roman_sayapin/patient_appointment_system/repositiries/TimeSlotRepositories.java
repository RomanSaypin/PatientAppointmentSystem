package ru.roman_sayapin.patient_appointment_system.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.TimeSlotEntity;

import java.util.List;
import java.util.Optional;

public interface TimeSlotRepositories extends JpaRepository<TimeSlotEntity, Long> {

    @Override
    List<TimeSlotEntity> findAll();

    @Override
    Optional<TimeSlotEntity> findById(Long id);
}
