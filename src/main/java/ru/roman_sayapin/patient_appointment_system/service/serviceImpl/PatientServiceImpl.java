package ru.roman_sayapin.patient_appointment_system.service.serviceImpl;

import ru.roman_sayapin.patient_appointment_system.DataBase.entity.PatientsEntity;
import ru.roman_sayapin.patient_appointment_system.repositiries.PatientsRepositories;
import ru.roman_sayapin.patient_appointment_system.service.PatientsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PatientServiceImpl implements PatientsService {

    private final PatientsRepositories patientsRepositories;

    public PatientServiceImpl(PatientsRepositories patientsRepositories) {
        this.patientsRepositories = patientsRepositories;
    }

    @Override
    public Optional<PatientsEntity> getPatientId(Long id) {
        return patientsRepositories.findById(id);
    }

    @Override
    public Optional<PatientsEntity> getPatientUUID(UUID id) {
        return patientsRepositories.findByUuid(id);
    }

    @Override
    public List<PatientsEntity> getAllPatient() {
        return patientsRepositories.findAll();
    }
}
