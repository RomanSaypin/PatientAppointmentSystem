package ru.roman_sayapin.patient_appointment_system.service;

import org.springframework.stereotype.Service;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.DoctorsEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public interface DoctorsService {

    Optional<DoctorsEntity> getPatientId(Long id);

    Optional<DoctorsEntity> getPatientUUID(UUID id);

    List<DoctorsEntity> getAllPatient();
}
