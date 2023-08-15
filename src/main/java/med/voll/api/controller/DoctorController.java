package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DoctorRegisterData data, UriComponentsBuilder uriBuilder){
        var doctor = new Doctor(data);
        repository.save(new Doctor(data));

        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetailsData(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListingData>> list(@PageableDefault(size=10, sort = {"crm"}) Pageable pagination){
        var page =  repository.findAllByActiveTrue(pagination).map(DoctorListingData::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdatingData data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInfoDoctor(data);

        return  ResponseEntity.ok(new DoctorDetailsData(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DoctorDetailsData(doctor));
    }

}
