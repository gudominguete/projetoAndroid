package app.util;

public enum Mensagem {

	ERRO_PADRAO,
	SUCESSO_PADRAO,
	ERRO_VALIDACAO_PADRAO,
	USUARIO_CRIADO_SUCESSO,
	LOGIN_INCORRETO,
	LOGIN_OU_EMAIL_NAO_DISPONIVEL,
	PERFIL_EXTERNO_NAO_EXISTENTE;
	
	public String getTexto(Object ... args) {
		return MensagemHandler.get(name(), args);
	}

}
