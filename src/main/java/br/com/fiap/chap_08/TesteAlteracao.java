package br.com.fiap.chap_08;
  
  import br.com.fiap.bean.Colaborador;
  import br.com.fiap.chap_08.DAO.ColaboradorDAO;

public class TesteAlteracao {
  
    public static void main(String[] args) {
  
      ColaboradorDAO dao = new ColaboradorDAO();

      //Recupera o colaborador com código 1
      Colaborador colaborador = dao.buscarPorId(28);
      //Imprime os valores do colaborador
      System.out.println(colaborador.getCodigo() + " "
          + colaborador.getNome() + " " + colaborador.getEmail() + " "
          + colaborador.getSalario() + " "
          + colaborador.getDataContratacao().getTime());

      //Altera os valores de alguns atributos do colaborador
      colaborador.setSalario(1500);
      colaborador.setEmail("teste@fiap.com.br");
      //Atualiza no banco de dados
      dao.atualizar(colaborador);
    }
  
  }