package br.com.fiap.chap_08.mode;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmpresaDBManager {

    public static Connection obterConexao() {
        Connection conexao = null;
        try {
          //Registra o driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

//            Abre uma conexao
            conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                    "RM551960", "290300");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }

}