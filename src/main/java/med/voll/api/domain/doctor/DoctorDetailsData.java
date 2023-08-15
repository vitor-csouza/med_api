package med.voll.api.domain.doctor;

import med.voll.api.domain.adress.Address;

public record DoctorDetailsData(Long id, String doctor_name, String email, String crm, String phone, Specialty specialty, Address address) {

    public DoctorDetailsData(Doctor doctor){
        this(doctor.getId(), doctor.getDoctor_name(), doctor.getEmail(), doctor.getCrm(),doctor.getPhone(), doctor.getSpecialty(), doctor.getAdress());
    }
}
