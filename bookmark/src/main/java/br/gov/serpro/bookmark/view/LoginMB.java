package br.gov.serpro.bookmark.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.gov.serpro.bookmark.security.Credentials;

@ViewController
@NextView("./index.jsf")
public class LoginMB extends AbstractPageBean {
	private static final long serialVersionUID = 1L;

	private String usuario = new String();
	private String senha = new String();

	@Inject
	Credentials credentials;
	@Inject
	SecurityContext securityContext;
	@Inject
	MessageContext menssageContext;

	public String doLogin() {
		try {
			credentials.setUsername(this.getUsuario());
			credentials.setPassword(this.senha);
			securityContext.login();
			return getNextView();
		} catch (Exception e) {
			menssageContext.add(e.getMessage());
			return "";
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void doLogout() {
		securityContext.logout();
	}
}
