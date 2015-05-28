package me.bukkit.mTokens.Inkzzz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

	private Connection con;

	public synchronized void openConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://"
					+ Tokens.getInstance().getConfig().getString("host") + ":"
					+ Tokens.getInstance().getConfig().getString("port") + "/"
					+ Tokens.getInstance().getConfig().getString("database"),
					Tokens.getInstance().getConfig().getString("user"), Tokens
							.getInstance().getConfig().getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public synchronized void closeConnection() {
		try {
			if (!con.isClosed() || con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return con;
	}

}
