package med.voll.api.domain.doctor;

public record DoctorListingData(Long id, String doctor_name, String email, String crm, Specialty specialty) {

    public DoctorListingData(Doctor doctor){
        this(doctor.getId(), doctor.getDoctor_name(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
