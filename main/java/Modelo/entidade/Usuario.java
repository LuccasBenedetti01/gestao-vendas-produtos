package Modelo.entidade;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;
    private Boolean estado; 
    private LocalDateTime dataCriacao;
    private LcoaldateTime ultimoLogin; 
}
