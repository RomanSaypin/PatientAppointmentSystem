package ru.roman_sayapin.patient_appointment_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.PatientsEntity;
import ru.roman_sayapin.patient_appointment_system.DataBase.entity.TimeSlotEntity;
import ru.roman_sayapin.patient_appointment_system.service.PatientsService;
import ru.roman_sayapin.patient_appointment_system.service.TimeSlotService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/timeslots")
public class TimeSlotController {

    private final TimeSlotService timeSlotService;
    private final PatientsService patientsService;

    public TimeSlotController(TimeSlotService timeSlotService, PatientsService patientsService) {
        this.timeSlotService = timeSlotService;
        this.patientsService = patientsService;
    }
    // Обработка GET-запроса для получения доступных слотов в определенную дату для указанного врача
    @GetMapping
    public ResponseEntity<List<TimeSlotEntity>> getAvailableSlots(
            @RequestParam("doctorId") Long doctorId,
            @RequestParam("date") String date) {

        if (timeSlotService.getAllByDoctorIdAndTime(doctorId, LocalDate.parse(date)).isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(timeSlotService.getAllByDoctorIdAndTime(doctorId, LocalDate.parse(date)));
    }
    // Обработка POST-запроса для бронирования слота указанного id определенным пациентом
    @PostMapping("/{id}/book")
    public ResponseEntity<String> bookTimeSlot(@PathVariable("id") Long id,
                                               @RequestBody PatientsEntity patient) {

        if (timeSlotService.getSlotID(id) == null) {
            return ResponseEntity.notFound().build();
        }

        if (timeSlotService.getAllSlotByPatientId(patient.getId()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Time slot already booked");
        }
        TimeSlotEntity timeSlotEntity = timeSlotService.getSlotID(id).get();
        timeSlotEntity.setPatientId(patient.getId());
        timeSlotService.save(timeSlotEntity);
        return ResponseEntity.ok("Time slot booked successfully");
    }

    // Обработка GET-запроса для получения списка слотов, забронированных указанным пациентом
    @GetMapping("/patients/{patientId}")
    public ResponseEntity<List<TimeSlotEntity>> getPatientTimeSlots(@PathVariable("patientId") Long patientId) {
        List<TimeSlotEntity> patientTimeSlots = timeSlotService.getAllSlotByPatientId(patientId);

        if (patientTimeSlots.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patientTimeSlots);
        }
    }
}
