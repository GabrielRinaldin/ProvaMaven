package com.banco;

import java.sql.Connection;

public class TestaDB {

	public static void main(String[] args) {
		
		Connection cnx = new ConexaoHSQLDB().conectar();
		if(cnx != null)
			System.out.println("Conectou");
		
	}

}
