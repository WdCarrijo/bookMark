package br.gov.serpro.bookmark.security;

import javax.enterprise.context.SessionScoped;

import br.gov.frameworkdemoiselle.security.Authorizer;

@SessionScoped
public class Autorizacao implements Authorizer{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean hasRole(String role) throws Exception { //tem papel
		return true;
	}

	@Override
	public boolean hasPermission(String resource, String operation) //tem permissao
			throws Exception {	
		return true;
	}

}
