package br.com.fiap.chap_08;

import java.sql.*;

public class TestStatments {

    public static void main(String[] args) {
        try {
            //Registra o Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Abre uma conexão
            Connection conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM551960", "290300");

            System.out.println("Conectado!");


        //Cria o CallableStatement

            CallableStatement cs = conexao.prepareCall("{call SP_Contar_Colaboradores(?,?)}");

            //Define o tipo do parâmetro de saída (primeiro ?)
            cs.registerOutParameter(1, java.sql.Types.INTEGER);

            //Define o valor do parâmetro de entrada (segundo ?)
            cs.setDouble(2, 1500);

            //Executa a procedure
            cs.executeUpdate();

            //Recupera o valor do parâmetro de saída
            int total = cs.getInt(1);
            System.out.println("Total de colaboradores com salário maior que 1500: " + total);


            conexao.close();

            //Tratamento de erro
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar no Banco de Dados");/**/
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("O Driver JDBC não foi encontrado!");
            e.printStackTrace();
        }
    }
}