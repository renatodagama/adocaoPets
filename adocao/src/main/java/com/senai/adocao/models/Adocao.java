package com.senai.adocao.models;

import jakarta.persistence.*;
import java.time.LocalDate;

// Uncomment the following line if Lombok is set up in your project
/**
 * Representa uma adoção de um pet por um adotante.
 * 
 * <p>
 * Esta entidade mapeia o relacionamento entre um {@link Pet} e um {@link Adotante},
 * registrando a data da adoção e observações adicionais.
 * </p>
 * 
 * <ul>
 *   <li>Relacionamento 1:1 com {@link Pet} (cada adoção está associada a um único pet).</li>
 *   <li>Relacionamento N:1 com {@link Adotante} (um adotante pode realizar várias adoções).</li>
 * </ul>
 * 
 * @author SeuNome
 */
@Entity
@Table(name = "adocoes")
// @Data // Uncomment if Lombok is set up and working
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento 1:1 com Pet [cite: 117]
    @OneToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private Pet pet; 

    // Relacionamento N:1 com Adotante [cite: 116]
    @ManyToOne
    @JoinColumn(name = "adotante_id", referencedColumnName = "id", nullable = false)
    private Adotante adotante; 

    private LocalDate dataAdocao;
    private String observacoes;
}