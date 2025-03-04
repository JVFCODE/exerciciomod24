package br.com.rpires.service;

import br.com.rpires.dao.IContratoDao;

/**
 * @author rodrigo.pires
 */
public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar(int id) {
        return contratoDao.buscar(id);
    }

    @Override
    public String excluir(int id) {
        contratoDao.excluir(id);
        return "Contrato excluído com sucesso";
    }

    @Override
    public String atualizar(int id, String novoValor) {
        contratoDao.atualizar(id, novoValor);
        return "Contrato atualizado com sucesso";
    }
}
