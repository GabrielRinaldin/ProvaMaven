package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banco.ConexaoHSQLDB;
import entidade.Cliente_Fisico;

public class Cliente_FisicoDao extends ConexaoHSQLDB{

	final String SQL_INSERT_CLIENTE_FISICO = "INSERT INTO Cliente_fisico (NOME, TELEFONE, CPF, EMAIL, CEP) VALUES ( ?, ?, ?, ?, ?)";
	final String SQL_SELECT_CLIENTE_FISICO = "SELECT * FROM Cliente_fisico";
	final String SQL_SELECT_CLIENTE_FISICO_ID = "SELECT * FROM Cliente_fisico WHERE ID_cli_fisico = ?";
	final String SQL_ALTERA_CLIENTE_FISICO = "UPDATE Cliente_fisico SET  NOME = ?, TELEFONE = ?, CPF = ?, EMAIL = ?, CEP = ?  WHERE ID = ?"; 
	final String SQL_DELETA_CLIENTE_FISICO = "DELETE FROM Cliente_fisico WHERE ID = ?";
	
	public int inserir(Cliente_Fisico clientef){
		int quantidade = 0;

		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_INSERT_CLIENTE_FISICO);) {
			pst.setString(1, clientef.getNome());
			pst.setInt(2, clientef.getTelefone());
			pst.setInt(3, clientef.getCpf());
			pst.setString(4, clientef.getEmail());
			pst.setString(5, clientef.getCep());
			quantidade = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return quantidade;
	}
	
	public List<Cliente_Fisico> listAll(){
		List<Cliente_Fisico> listaCliente_Fisico = new ArrayList<Cliente_Fisico>();
		
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SQL_SELECT_CLIENTE_FISICO);){

			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Cliente_Fisico clientef = new Cliente_Fisico();
				clientef.setId(rs.getInt("ID"));
				clientef.setNome(rs.getString("NOME"));
				clientef.setTelefone(rs.getInt("TELEFONE"));
				clientef.setCpf(rs.getInt("CPF"));
				clientef.setEmail(rs.getString("EMAIL"));
				clientef.setCep(rs.getString("CEP"));
				listaCliente_Fisico.add(clientef);
				System.out.println(clientef);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCliente_Fisico;
	}
	
	
	public Cliente_Fisico findByID(int id)
	{
		Cliente_Fisico clientef = null;
		try(Connection connection = this.conectar();
				PreparedStatement pst	= connection.prepareStatement(SQL_SELECT_CLIENTE_FISICO_ID);)
		{
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				clientef = new Cliente_Fisico();					
				clientef.setId(rs.getInt("ID"));
				clientef.setNome(rs.getString("NOME"));
				clientef.setTelefone(rs.getInt("TELEFONE"));
				clientef.setCpf(rs.getInt("CPF"));
				clientef.setEmail(rs.getString("EMAIL"));
				clientef.setCep(rs.getString("CEP"));
				
			}		
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	  return clientef;
	}
	
	public int alterar(Cliente_Fisico clientef) {

		int quantidade = 0;		
		try (Connection connection = this.conectar();
			PreparedStatement pst	= connection.prepareStatement(SQL_ALTERA_CLIENTE_FISICO);)
		{
			pst.setString(1, clientef.getNome());
			pst.setInt(2, clientef.getTelefone());
			pst.setInt(3, clientef.getCpf());
			pst.setString(4, clientef.getEmail());
			pst.setString(5, clientef.getCep());
			quantidade = pst.executeUpdate();			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return quantidade;
	}
	
	
	public int deleta(Cliente_Fisico clientef)
	{
		int quantidade = 0;
		
		try (Connection connection = this.conectar();
			PreparedStatement pst = connection.prepareStatement(SQL_DELETA_CLIENTE_FISICO);)
		{
			pst.setInt(1, clientef.getId());
			quantidade = pst.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	 
		
		return quantidade;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

