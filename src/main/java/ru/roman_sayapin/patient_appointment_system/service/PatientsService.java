package ru.roman_sayapin.patient_appointment_system.service;

import org.springframework.stereotype.Service;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.PatientsEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface PatientsService {

    Optional<PatientsEntity> getPatientId(Long id);

    Optional<PatientsEntity> getPatientUUID(UUID id);

    List<PatientsEntity> getAllPatient();
}
