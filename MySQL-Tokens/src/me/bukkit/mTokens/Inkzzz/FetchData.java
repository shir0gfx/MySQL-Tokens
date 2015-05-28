package me.bukkit.mTokens.Inkzzz;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class FetchData {

	MySQL mysql = new MySQL();

	public int getTokens(Player p) {
		try {
			ResultSet r = mysql
					.getCurrentConnection()
					.createStatement()
					.executeQuery(
							"SELECT Tokens FROM mTokensData WHERE UUID = '"
									+ p.getUniqueId().toString() + "'");
			if (r.next()) {
				return r.getInt("Tokens");
			}
			r.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean isInDb(Player p) {
		try {
			ResultSet r = mysql
					.getCurrentConnection()
					.createStatement()
					.executeQuery(
							"SELECT * FROM mTokensData WHERE UUID = '"
									+ p.getUniqueId().toString() + "'");
			boolean contains = r.next();
			r.close();
			return contains;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
