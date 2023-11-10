package br.com.fiap.chap_08;

import java.sql.*;

public class TestView {

    public static void main(String[] args) {
        try {
            //Registra o Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Abre uma conexão
            Connection conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM551960", "290300");

            System.out.println("Conectado!");



//            Statement stmt = conexao.createStatement();
//            stmt.executeUpdate("INSERT INTO T_COLABORADOR(CD_COLABORADOR, NOME, EMAIL, SALARIO, DT_CONTRATACAO) VALUES (SEQ_COLABORADOR.NEXTVAL, 'Leandro', 'leandro@gmail.com', 1500, TO_DATE('10/12/2009','dd/mm/yyyy'))");
//
//            stmt.executeUpdate("UPDATE T_COLABORADOR SET SALARIO = 5000 WHERE CD_COLABORADOR = 1");

//
//            stmt.executeUpdate("DELETE FROM TAB_COLABORADOR WHERE CODIGO_COLABORADOR = 1"); ------------> DELETE


//            ResultSet rs = stmt.executeQuery("SELECT * FROM T_COLABORADOR");


            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO T_COLABORADOR(CD_COLABORADOR, NOME, EMAIL, SALARIO, DT_CONTRATACAO) VALUES (SEQ_COLABORADOR.NEXTVAL, ?, ?, ?, ?)");
            stmt.setString(1, "Drone"); //Primero parâmetro (Nome)
            stmt.setString(2, "drone@gmail.com");//Segundo parâmetro (Email)
            stmt.setDouble(3, 5000); //Terceiro parâmetro (Salário)
            //Instancia um objeto do tipo java.sql.Date com a data atual
            java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
            stmt.setDate(4,data);//Quarto parâmetro (data contratação)

            stmt.executeUpdate();


            stmt = conexao.prepareStatement("UPDATE T_COLABORADOR SET SALARIO = ? WHERE CD_COLABORADOR = ?");
            stmt.setDouble(1, 5000);
            stmt.setInt(2, 100);
            stmt.executeUpdate();

            stmt = conexao.prepareStatement("SELECT * FROM T_COLABORADOR WHERE NOME = ?");
            stmt.setString(1, "Thiago");
            ResultSet result = stmt.executeQuery();



            //Percorre todos os registros encontrados
            while (result.next()){
                //Recupera os valores de cada coluna
                int codigo = result.getInt("CODIGO_COLABORADOR");
                String nome = result.getString("NOME");
                String email = result.getString("EMAIL");
                double salario = result.getDouble("SALARIO");
                //Exibe as informações do registro
                System.out.println(codigo + " " + nome + " " + email + " " + salario + " " + data);
            }

//            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM TAB_COLABORADOR WHERE CODIGO_COLABORADOR = ?"); ---------> DELETE

            //Fecha a conexão
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