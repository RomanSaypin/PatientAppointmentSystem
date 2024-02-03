package ru.roman_sayapin.patient_appointment_system.service.serviceImpl;

import ru.roman_sayapin.patient_appointment_system.DataBase.entity.DoctorsEntity;
import ru.roman_sayapin.patient_appointment_system.repositiries.DoctorsRepositories;
import ru.roman_sayapin.patient_appointment_system.service.DoctorsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DoctorsServiceImpl implements DoctorsService {

   private final  DoctorsRepositories doctorsRepositories;

    public DoctorsServiceImpl(DoctorsRepositories doctorsRepositories) {
        this.doctorsRepositories = doctorsRepositories;
    }

    @Override
    public Optional<DoctorsEntity> getPatientId(Long id) {
        return doctorsRepositories.findById(id);
    }

    @Override
    public Optional<DoctorsEntity> getPatientUUID(UUID id) {
        return doctorsRepositories.findByUuid(id);
    }

    @Override
    public List<DoctorsEntity> getAllPatient() {
        return doctorsRepositories.findAll();
    }
}
