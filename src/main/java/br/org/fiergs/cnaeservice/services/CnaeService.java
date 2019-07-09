package br.org.fiergs.cnaeservice.services;

import br.org.fiergs.cnaeservice.entities.Cnae;
import br.org.fiergs.cnaeservice.repositories.CnaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CnaeService {
    @Autowired
    private CnaeRepository cnaeRepository;

    public List<Cnae> findAll() {
        return cnaeRepository.findAll();
    }

    public List<Cnae> findByDescription(String description) {
        Optional<List<Cnae>> optCnae = cnaeRepository.findByDescriptionContainingIgnoreCase(description);
        return optCnae.orElseGet(ArrayList::new);
    }

    public List<Cnae> findByIndustry(String industry) {
        Optional<List<Cnae>> optCnae = cnaeRepository.findByIndustryContainingIgnoreCase(industry);
        return optCnae.orElseGet(ArrayList::new);
    }

    public List<Cnae> findByContr(String contr) {
        Optional<List<Cnae>> optCnae = cnaeRepository.findByContr(contr);
        return optCnae.orElseGet(ArrayList::new);
    }

    public Cnae findByCode(String code) {
        Optional<Cnae> optCnae = cnaeRepository.findByCode(code);
        return optCnae.orElseGet(null);
    }

    public Cnae save(Cnae cnae) {
        Optional<Cnae> optCnae = cnaeRepository.findByCodeOrDescription(cnae.getCode(), cnae.getDescription());
        if (optCnae.isEmpty()) {
            return cnaeRepository.save(cnae);
        } else {
            throw new RuntimeException("Cnae já cadastrado!");
        }

    }

    public Cnae update(Cnae cnae) {
        Optional<Cnae> optCnae = cnaeRepository.findOneByDescriptionIgnoreCaseOrCodeAndIdNot(cnae.getDescription(), cnae.getCode(), cnae.getId());
        if (optCnae.isEmpty()) {
            return cnaeRepository.save(cnae);
        } else {
            throw new RuntimeException("Cnae já cadastrado!");
        }
    }

    public void delete(Long id) {
        cnaeRepository.deleteById(id);
    }

}
