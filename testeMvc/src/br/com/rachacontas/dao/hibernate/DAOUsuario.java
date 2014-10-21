package br.com.rachacontas.dao.hibernate;

import br.com.rachacontas.dao.DAOBase;
import br.com.rachacontas.entidades.Usuario;

public interface DAOUsuario extends DAOBase<Usuario> {


	/** Busca usuario pelo login */
	public Usuario getUsuario(String login);

	/** Busca usuario por login e senha */
	public Usuario getUsuario(String login, String senha);

}
