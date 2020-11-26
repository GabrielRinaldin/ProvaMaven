package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banco.ConexaoHSQLDB;

 
import entidade.Cliente_Juridico;

public class Cliente_JuridicoDao extends ConexaoHSQLDB{

	final String SQL_INSERT_CLIENTE_JURIDICO = "INSERT INTO Cliente_Juridico (NOME, TELEFONE, CPF, EMAIL, CEP) VALUES ( ?, ?, ?, ?, ?, ?)";
	final String SQL_SELECT_CLIENTE_JURIDICO = "SELECT * FROM Cliente_Juridico";
	final String SQL_SELECT_CLIENTE_JURIDICO_ID = "SELECT * FROM Cliente_Juridico WHERE ID_CLI_JURIDICO = ?";
	final String SQL_ALTERA_CLIENTE_JURIDICO = "UPDATE Cliente_Juridico SET  NOME = ?, TELEFONE = ?, CPF = ?, EMAIL = ?, CEP = ?  WHERE ID = ?";
	final String DELETA_CLIENTE_JURIDICO = "DELETE FROM Cliente_Juridico WHERE ID = ?";
	
	public int inserir(Cliente_Juridico clientej){
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_CLIENTE_JURIDICO);) {
			pst.setString(1, clientej.getNome());
			pst.setInt(2, clientej.getTelefone());
			pst.setInt(3, clientej.getCpf());
			pst.setString(4, clientej.getEmail());
			pst.setString(5, clientej.getCep());

			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public List<Cliente_Juridico> listAll(){
		List<Cliente_Juridico> listaCliente_Juridico = new ArrayList<Cliente_Juridico>();
		
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_CLIENTE_JURIDICO);){

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Cliente_Juridico clientej = new Cliente_Juridico();				
				clientej.setId(rs.getInt("ID"));
				clientej.setNome(rs.getString("NOME"));
				clientej.setTelefone(rs.getInt("TELEFONE"));
				clientej.setCpf(rs.getInt("CPF"));
				clientej.setEmail(rs.getString("EMAIL"));
				clientej.setCep(rs.getString("CEP"));
				listaCliente_Juridico.add(clientej);
				System.out.println(clientej);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCliente_Juridico;
	}
	
	
	public Cliente_Juridico findByID (int id) {
		Cliente_Juridico clientej = null;
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_CLIENTE_JURIDICO_ID)){

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				clientej = new Cliente_Juridico();
				clientej.setId(rs.getInt("ID"));
				clientej.setNome(rs.getString("NOME"));
				clientej.setTelefone(rs.getInt("TELEFONE"));
				clientej.setCpf(rs.getInt("CPF"));
				clientej.setEmail(rs.getString("EMAIL"));
				clientej.setCep(rs.getString("CEP"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientej;
	}
	
	
	public int alterar(Cliente_Juridico clientej) {
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_CLIENTE_JURIDICO);) {
			pst.setString(1, clientej.getNome());
			pst.setInt(2, clientej.getTelefone());
			pst.setInt(3, clientej.getCpf());
			pst.setString(4, clientej.getEmail());
			pst.setString(5, clientej.getCep());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public int deletar(int id) {
        int quantidade = 0;
        try (Connection connection = this.conectar();
            PreparedStatement pst = connection.prepareStatement(DELETA_CLIENTE_JURIDICO);) {
            pst.setInt(1, id);
            quantidade = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantidade;
    }

}
