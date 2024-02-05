package ru.roman_sayapin.patient_appointment_system.service;

import ru.roman_sayapin.patient_appointment_system.DataBase.entity.PatientsEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PatientsService {

    Optional<PatientsEntity> getPatientId(Long id);

    Optional<PatientsEntity> getPatientUUID(UUID id);

    List<PatientsEntity> getAllPatient();
}
