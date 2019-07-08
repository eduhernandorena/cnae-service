package br.org.fiergs.cnaeservice.repositories;

import br.org.fiergs.cnaeservice.entities.Cnae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CnaeRepository extends JpaRepository<Cnae, Long> {

    Optional<Cnae> findByCode(String code);

    Optional<Cnae> findByCodeOrDescription(String code, String description);

    Optional<List<Cnae>> findByContr(String contr);

    Optional<List<Cnae>> findByIndustryContainingIgnoreCase(String industry);

    Optional<List<Cnae>> findByDescriptionContainingIgnoreCase(String description);

    @Query("select o from Cnae o where (upper(description) like %?1% or code = ?2) and id <> ?3")
    Optional<Cnae> findOneByDescriptionContainingIgnoreCaseOrCodeAndIdNot(String description, String code, Long id);

}
