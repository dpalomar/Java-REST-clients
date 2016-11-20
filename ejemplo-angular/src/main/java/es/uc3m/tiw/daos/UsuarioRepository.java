package es.uc3m.tiw.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
