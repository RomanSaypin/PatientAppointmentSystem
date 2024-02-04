package ru.roman_sayapin.patient_appointment_system.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.DoctorsEntity;

import java.util.Optional;
import java.util.UUID;

public interface DoctorsRepositoriesUUID extends JpaRepository<DoctorsEntity, UUID> {
    @Override
    Optional<DoctorsEntity> findByUuid(UUID uuid);
}
