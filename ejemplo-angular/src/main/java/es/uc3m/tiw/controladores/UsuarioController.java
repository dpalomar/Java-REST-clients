package es.uc3m.tiw.controladores;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.UsuarioRepository;
import es.uc3m.tiw.dominios.Usuario;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	/**
	 * Guarda unos usuarios de prueba en la base de datos h2 
	 */
	@PostConstruct
	public void init(){
		usuarioRepository.save(new Usuario("juan", 18));
		usuarioRepository.save(new Usuario("Ana", 27));
	}
	
	
	@RequestMapping(value="/usuario",method=RequestMethod.GET)
	public  Usuario getUsuario(){
		
		return new Usuario("Juan", 18);
	}
	
	@RequestMapping(value="/usuarios", method=RequestMethod.GET)
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@RequestMapping(value="/usuario", method=RequestMethod.POST)
	public Usuario saveUsuario(@RequestBody @Validated Usuario usuario){
		return usuarioRepository.save(usuario);
	}
}
