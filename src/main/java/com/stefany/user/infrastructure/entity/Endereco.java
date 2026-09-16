package com.stefany.user.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "rua")
    private String rua;
    @Column(name= "estado", length = 2)
    private String estado;
    @Column(name = "complemento", length = 100)
    private String complemento;
    @Column (name = "cidade", length = 100)
    private String cidade;
    @Column (name = "numero")
    private Long numero;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private List<Telefone> telefones ;
}
