package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;
import br.com.rpires.service.ClienteService;
import br.com.rpires.service.IClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        IClienteDao dao = new ClienteDaoMock();
        IClienteService service = new ClienteService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarTest() {
        IClienteDao dao = new ClienteDaoMock();
        IClienteService service = new ClienteService(dao);
        Cliente cliente = service.buscar();
        Assert.assertNotNull(cliente);
    }

    @Test
    public void excluirTest() {
        IClienteDao dao = new ClienteDaoMock();
        IClienteService service = new ClienteService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluido", retorno);
    }

    @Test
    public void atualizarTest() {
        IClienteDao dao = new ClienteDaoMock();
        IClienteService service = new ClienteService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Atualizado", retorno);
    }

    // Inner class para mock do ClienteDao
    private class ClienteDaoMock implements IClienteDao {
        @Override
        public String salvar() {
            return "Sucesso";
        }

        @Override
        public Cliente buscar() {
            Cliente cliente = new Cliente();
            cliente.setNome("Cliente Mock");
            return cliente;
        }

        @Override
        public String excluir() {
            return "Excluido";
        }

        @Override
        public String atualizar() {
            return "Atualizado";
        }
    }

    // Inner class para mock do Cliente
    private class Cliente {
        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

    // Inner interface para o ClienteDao
    private interface IClienteDao {
        String salvar();
        Cliente buscar();
        String excluir();
        String atualizar();
    }

    // Inner class para o ClienteService
    private class ClienteService implements IClienteService {
        private IClienteDao clienteDao;

        public ClienteService(IClienteDao clienteDao) {
            this.clienteDao = clienteDao;
        }

        @Override
        public String salvar() {
            return clienteDao.salvar();
        }

        @Override
        public Cliente buscar() {
            return clienteDao.buscar();
        }

        @Override
        public String excluir() {
            return clienteDao.excluir();
        }

        @Override
        public String atualizar() {
            return clienteDao.atualizar();
        }
    }

    // Inner interface para o ClienteService
    private interface IClienteService {
        String salvar();
        Cliente buscar();
        String excluir();
        String atualizar();
    }
}
