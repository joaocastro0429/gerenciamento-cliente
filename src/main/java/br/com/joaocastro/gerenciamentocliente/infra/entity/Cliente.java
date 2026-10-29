package br.com.joaocastro.gerenciamentocliente.infra.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Client")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "phone")
    private   String phone;

    @Column(name = "email")
    private   String email;

    @Column(name = "address")
    private   String address;
}
