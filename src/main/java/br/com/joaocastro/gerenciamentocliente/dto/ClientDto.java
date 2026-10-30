package br.com.joaocastro.gerenciamentocliente.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientDto {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String name;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Por favor, insira um email válido")
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    private String phone;

    @NotBlank(message = "O endereço é obrigatório")
    private String address;

}
