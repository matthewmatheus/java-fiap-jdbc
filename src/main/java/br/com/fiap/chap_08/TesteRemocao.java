package br.com.fiap.chap_08;


import br.com.fiap.chap_08.DAO.ColaboradorDAO;

public class TesteRemocao {
  
    public static void main(String[] args) {

      ColaboradorDAO dao = new ColaboradorDAO();

      //Remove o colaborador com código 1
      dao.remover(23);
      System.out.println("Done!");
    }
    }