package com.ulisses.dto;

import com.ulisses.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "only letters, spaces and numbers are allowed")
    @Size(min = 3, max = 100, message = "name should have between 3 and 100 characters")
    private String name;
    @Size(min = 11, max= 11, message = "cpf should have 11 digits")
    private String cpf;
    @Size(min = 8, max = 8, message = "cep should have 8 digits")
    private String enderecoCEP;
    @NotBlank(message = "enderecoLogradouro can`t be blank")
    private String enderecoLogradouro;
    @NotBlank(message = "enderecoBairro can`t be blank")
    private String enderecoBairro;
    @NotBlank(message = "enderecoCidade can`t be blank")
    private String enderecoCidade;
    @NotBlank(message = "enderecoUF can`t be blank")
    @Size(min=2, max =2, message = "invalid UF")
    private String enderecoUF;
    private List<String> telefones;
    private List<String> emails;

    public User toEntity() {
        return User.builder()
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
