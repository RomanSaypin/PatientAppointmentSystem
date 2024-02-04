package ru.roman_sayapin.patient_appointment_system.service.serviceImpl;

import ru.roman_sayapin.patient_appointment_system.DataBase.entity.DoctorsEntity;
import ru.roman_sayapin.patient_appointment_system.repositiries.DoctorsRepositoriesID;
import ru.roman_sayapin.patient_appointment_system.service.DoctorsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DoctorsServiceImpl implements DoctorsService {

   private final DoctorsRepositoriesID doctorsRepositories;
   private final DoctorsRepositoriesUUID doctorsRepositoriesUUID;

    public DoctorsServiceImpl(DoctorsRepositoriesID doctorsRepositories,
                              DoctorsRepositoriesUUID doctorsRepositoriesUUID) {
        this.doctorsRepositories = doctorsRepositories;
        this.doctorsRepositoriesUUID = doctorsRepositoriesUUID;
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
