package ru.roman_sayapin.patient_appointment_system.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.TimeSlotEntity;
import ru.roman_sayapin.patient_appointment_system.repositiries.TimeSlotRepositories;
import ru.roman_sayapin.patient_appointment_system.service.TimeSlotService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepositories timeSlotRepositories;

    public TimeSlotServiceImpl(TimeSlotRepositories timeSlotRepositories) {
        this.timeSlotRepositories = timeSlotRepositories;
    }

    @Override
    public List<TimeSlotEntity> getAllSlot() {
        return timeSlotRepositories.findAll();
    }

    @Override
    public List<TimeSlotEntity> getAllSlotByDoctorId(Long doctorID) {
        return timeSlotRepositories.findAllByDoctorId(doctorID);
    }

    @Override
    public List<TimeSlotEntity> getAllSlotByPatientId(Long patientID) {
        return timeSlotRepositories.findAllByPatientId(patientID);
    }

    @Override
    public List<TimeSlotEntity> getAllSlotByDoctorIdANDPatientId(Long doctorID, Long patientID) {
        return timeSlotRepositories.findAllByDoctorIdAndPatientId(doctorID, patientID);
    }
    @Transactional
    @Override
    public void save(TimeSlotEntity entity) {
        timeSlotRepositories.save(entity);
    }

    @Override
    public Optional<TimeSlotEntity> getSlotID(Long id) {
        return timeSlotRepositories.findById(id);
    }

    @Override
    public List<TimeSlotEntity> getAllByDoctorIdAndTime(Long id, LocalDate date) {
        return timeSlotRepositories.findAllByDoctorIdAndStartTime(id, date);
    }
}
