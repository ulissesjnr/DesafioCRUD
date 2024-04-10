package com.ulisses.entity;

import javax.persistence.*;

import com.ulisses.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 8)
    private String enderecoCEP;

    @Column(length = 250)
    private String enderecoLogradouro;

    @Column(length = 100)
    private String enderecoBairro;

    @Column(length = 100)
    private String enderecoCidade;

    @Column(length = 2)
    private String enderecoUF;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_telefones", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "telefone", nullable = false)
    private List<String> telefones;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_emails", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "email", nullable = false)
    private List<String> emails;

    public UserDTO toDTO() {
        return UserDTO.builder()
            .id(id)
            .name(name)
            .cpf(cpf)
            .enderecoCEP(enderecoCEP)
            .enderecoLogradouro(enderecoLogradouro)
            .enderecoBairro(enderecoBairro)
            .enderecoCidade(enderecoCidade)
            .enderecoUF(enderecoUF)
            .telefones(telefones)
            .emails(emails)
            .build();
    }
}
