package med.voll.api.domain.adress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String district;
    private String cep;
    private String house_number;
    private String complement;
    private String city;
    private String uf;

    public Address(AddressData datas) {
        this.street = datas.street();
        this.district = datas.district();
        this.cep = datas.cep();
        this.house_number = datas.house_number();
        this.complement = datas.complement();
        this.city = datas.city();
        this.uf = datas.uf();
    }

    public void updateInfoAddress(AddressData data) {
        if (data.street()!=null)
            this.street = data.street();
        if (data.district()!=null)
            this.district = data.district();
        if (data.cep()!=null)
            this.cep = data.cep();
        if (data.house_number()!=null)
            this.house_number = data.house_number();
        if (data.complement()!=null)
            this.complement = data.complement();
        if (data.city()!=null)
            this.city = data.city();
        if (data.uf()!=null)
            this.uf = data.uf();
    }
}
