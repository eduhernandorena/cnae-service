package br.org.fiergs.cnaeservice.controllers;

import br.org.fiergs.cnaeservice.entities.Cnae;
import br.org.fiergs.cnaeservice.services.CnaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/cnae", produces = MediaType.APPLICATION_JSON_VALUE)
public class CnaeController {

    @Autowired
    private CnaeService cnaeService;

    @GetMapping
    public List<Cnae> list(){
        return cnaeService.findAll();
    }

    @GetMapping("/description/{description}")
    public List<Cnae> listByDescription(@PathVariable("description") String description){
        return cnaeService.findByDescription(description);
    }

    @GetMapping("/code/{code}")
    public Cnae findByCode(@PathVariable("code") String code) {
        return cnaeService.findByCode(code);
    }

    @GetMapping("/industry/{industry}")
    public List<Cnae> listByIndustry(@PathVariable("industry") String industry){
        return cnaeService.findByIndustry(industry);
    }

    @GetMapping("/contr/{contr}")
    public List<Cnae> listByContr(@PathVariable("contr") String contr){
        return cnaeService.findByContr(contr);
    }

    @PostMapping
    public Cnae save(@RequestBody @Valid Cnae cnae){
        return cnaeService.save(cnae);
    }

    @PutMapping
    public Cnae update(@RequestBody @Valid Cnae cnae){
        return cnaeService.update(cnae);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cnaeService.delete(id);
    }

}
