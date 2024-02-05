package ru.roman_sayapin.patient_appointment_system.DataBase.entity;

public enum Specialization {
    THERAPIST("Терапевт"), SURGEON("Хирург"), OPTOMETRIST("Окулист");
    private final String specialization;
    Specialization(String specialization) {
        this.specialization = specialization;
    }
    @Override
    public String toString() {
        return specialization;
    }
}
