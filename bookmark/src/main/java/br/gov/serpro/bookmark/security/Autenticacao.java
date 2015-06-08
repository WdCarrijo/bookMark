package br.gov.serpro.bookmark.security;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@SessionScoped
public class Autenticacao implements Authenticator {
	private static final long serialVersionUID = 1L;

	@Inject
	Credentials credentials;
	@Inject
	ResourceBundle bundle;

	private boolean autenticado;

	@Override
	public void authenticate() throws Exception {
		if (credentials.getUsername().equalsIgnoreCase("gerente")
				&& credentials.getPassword().equalsIgnoreCase("segredo")) {
			autenticado = true;
		} else if (credentials.getUsername().equalsIgnoreCase("secretaria")
				&& credentials.getPassword().equalsIgnoreCase("segredo")) {
			autenticado = true;
		}

		if (!autenticado)
			throw new AuthenticationException(
					bundle.getString("mensagem.usuario.login"));
	}

	@Override
	public void unauthenticate() throws Exception {
		autenticado = false;
		credentials.clear();
	}

	@Override
	public User getUser() {
		if (autenticado) {
			return new User() {
				private static final long serialVersionUID = 1L;

				@Override
				public void setAttribute(Object key, Object value) {
				}

				@Override
				public String getId() {
					return credentials.getUsername();
				}

				@Override
				public Object getAttribute(Object key) {
					return null;
				}
			};
		} else {
			return null;
		}
	}
}
