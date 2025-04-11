package br.com.rpires.dao;

import br.com.rpires.domain.Contrato;

public interface IContratoService {

    String salvar();

    Contrato buscar();

    String excluir();

    String atualizar();
}
