package ru.roman_sayapin.patient_appointment_system.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.DoctorsEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorsRepositoriesID extends JpaRepository<DoctorsEntity, Long> {
    @Override
    List<DoctorsEntity> findAll();

    @Override
    Optional<DoctorsEntity> findById(Long id);

    Optional<DoctorsEntity> findByUuid(UUID id);

}
