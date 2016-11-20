package es.uc3m.tiw.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.dominios.Usuario;
/**
 * Esta clase es un ejempo de cliente REST Java.
 * Hace llamadas a un servicio REST remoto simulado por la clase {@link UsuarioController}
 * Hace uso de la clase de Spring {@link RestTemplate}
 * @author David
 * 
 * @see RestTemplate
 *
 */
@Controller
public class PaginaUsuarioController {

	@Autowired
	RestTemplate restTemplate;
	
	/**
	 * Mapeo por defecto a la página index.html
	 * @return la página index.html
	 */
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	
	@GetMapping("consulta-usuario")
	public String unUsuario(Model modelo){
		Usuario usuario = restTemplate.getForObject("http://localhost:8080/usuario", Usuario.class);
		modelo.addAttribute(usuario);
		return "usuario-unico";
	}

	@RequestMapping(value="pagina-todos",method=RequestMethod.GET)
	public String todosLosUsuarios(Model modelo){
	 ResponseEntity<Usuario[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/usuarios", Usuario[].class);
	 Usuario[] usuarios = responseEntity.getBody();
		modelo.addAttribute("usuarios",usuarios);
		return "todos-usuarios";
	}
	
	
	/**
	 * Parte del ciclo del formulario, si se accede por GET se muestra el formulario.
	 * @param modelo
	 * @return el formulario
	 */
	@GetMapping("pagina-usuario")
	public String mostrarElFormularioDelUsuario(Model modelo){
		modelo.addAttribute(new Usuario());
		return "pagina-usuario";
	}
	
	/**
	 * Parte del ciclo del formulario si se accede por post, recoge los datos del formulario
	 * e invoca al servicio REST remoto y devuelve el resultado a la página usuario-guardado.html
	 * @param modelo
	 * @param usuario
	 * @return la pagina de resultados
	 */
	@PostMapping("pagina-usuario")
	public String guardarUnUsuario(Model modelo, @ModelAttribute Usuario usuario){
		System.out.println(usuario);
		Usuario usuarioGuardado = restTemplate.postForObject("http://localhost:8080/usuario", usuario, Usuario.class);
		modelo.addAttribute(usuarioGuardado);
		return "usuario-guardado";
		
	}
	

	
}























