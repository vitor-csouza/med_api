package med.voll.api.domain.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.adress.Address;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String doctor_name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address adress;

    private Boolean active;

    public Doctor(DoctorRegisterData datas) {
        this.active = true;
        this.doctor_name = datas.doctor_name();
        this.email = datas.email();
        this.phone = datas.phone();
        this.crm = datas.crm();
        this.specialty = datas.specialty();
        this.adress = new Address(datas.adress());
    }

    public void updateInfoDoctor(DoctorUpdatingData data) {
        if (data.doctor_name()!=null)
            this.doctor_name = data.doctor_name();
        if (data.phone()!=null)
            this.phone = data.phone();
        if (data.address()!=null)
            this.adress.updateInfoAddress(data.address());
    }

    public void delete() {
        this.active = false;
    }
}
