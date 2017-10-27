package kangoo.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import kangoo.model.manager.ManagerUsuarios;
import kangoo.view.util.JSFUtil;

@ManagedBean
@SessionScoped
public class ControllerUsuario {
	private String idRol;
	private String password;
	@EJB
	private ManagerUsuarios managerUsuarios;

	public String actionLogin() {
		try {
			boolean respuesta = managerUsuarios.comprobarUsuario(idRol, password);
			JSFUtil.crearMensajeInfo("Login correcto"); // verificamos si el
														// acceso es con admin:
			if (idRol.equals("admin")) {
				return "admin/index";
			}
			if(idRol.equals("secre")){
				return "secretaria/indexSecre";
			}else
				
			return "index";
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
		return "";
	}

	public String getIdRol() {
		return idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}