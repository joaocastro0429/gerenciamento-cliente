package br.com.joaocastro.gerenciamentocliente.infra.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private  String name;

    @Column(name = "phone", nullable = false)
    private   String phone;

    @Column(name = "email", nullable = false)
    private   String email;

    @Column(name = "address")
    private   String address;
}
