package br.com.senai.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RoleUsuario {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    private Long usuarios_id;

    @ManyToOne(cascade = CascadeType.ALL)
    private  String role_nome_role;

}
