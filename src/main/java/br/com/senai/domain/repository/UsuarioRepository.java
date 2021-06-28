package br.com.senai.domain.repository;

import br.com.senai.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

}
