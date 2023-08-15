package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.adress.AddressData;

public record DoctorUpdatingData(
        @NotNull
        Long id,
        String doctor_name,
        String phone,
        AddressData address) {

}
