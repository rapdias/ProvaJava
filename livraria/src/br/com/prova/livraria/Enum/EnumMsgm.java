package br.com.prova.livraria.Enum;

public enum EnumMsgm {
        
	ERRO_AUTOR_CAD("Erro ao Cadastrar Autor!"),
    ERRO_AUTOR_DUPLICIDADE("Já existe esse Autor cadastrado!"),
    CAD_AUTOR_OK("Autor cadastrado com sucesso!"),
    ERRO_LIVRO_CAD("Erro ao Cadastrar Livro!"),
    ERRO_LIVRO_DUPLICIDADE("Já existe esse Livro cadastrado!"),
    CAD_LIVRO_DEL("Livro excluído com sucesso!"),
    CAD_LIVRO_ATUALIZADO("Livro atualizados com sucesso!"),
    ERRO_LIVRO_ATUALIZAR("Erro ao atualizar Livro!"),
	CAD_LIVRO_OK("Livro cadastrado com sucesso!");

        private String msgm;
        
        EnumMsgm(String msgm){
            this.msgm = msgm;
        }
        public String getMsgm(){
        	return this.msgm;
        }
}
