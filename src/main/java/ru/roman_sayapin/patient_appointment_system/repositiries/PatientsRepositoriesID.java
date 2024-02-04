package ru.roman_sayapin.patient_appointment_system.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.PatientsEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientsRepositoriesID extends JpaRepository<PatientsEntity, Long> {
    @Override
    Optional<PatientsEntity> findById(Long id);
    @Override
    List<PatientsEntity> findAll();
}
