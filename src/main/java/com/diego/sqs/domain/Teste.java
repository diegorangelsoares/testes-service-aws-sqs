package com.diego.sqs.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "tb_teste")
public class Teste extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_teste", updatable = false, nullable = false)
    private Long id;

    @Column(name = "ds_texto")
    public String texto;

    @Column(name = "ds_cpf")
    public String cpf;

}
