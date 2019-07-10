package br.org.fiergs.cnaeservice.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "CAD_CNAE")
@SequenceGenerator(name = "seqCad_Cnae", sequenceName = "SEQCAD_CNAE", allocationSize = 1)
public class Cnae {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_Cnae")
    private Long id;

    @NotEmpty(message = "Código é obrigatório!")
    private String code;

    @NotEmpty(message = "Descrição é obrigatória!")
    private String description;

    private String contr;

    private String industry;

    @ManyToOne
    private Cnae superior;

    private boolean ipi = false;

    private boolean icms = false;

    private boolean status = true;
}
