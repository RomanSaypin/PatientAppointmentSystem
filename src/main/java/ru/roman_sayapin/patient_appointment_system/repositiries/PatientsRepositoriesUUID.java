package ru.roman_sayapin.patient_appointment_system.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.PatientsEntity;

import java.util.Optional;
import java.util.UUID;

interface PatientsRepositoriesUUID extends JpaRepository<PatientsEntity, UUID> {
    @Override
    Optional<PatientsEntity> findByUuid(UUID uuid);
}
