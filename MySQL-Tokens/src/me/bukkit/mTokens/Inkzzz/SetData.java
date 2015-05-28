package me.bukkit.mTokens.Inkzzz;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SetData {

	MySQL mysql = new MySQL();
	FetchData fd = new FetchData();

	public void giveTokens(final Player p, final int tokens) {
		Bukkit.getScheduler().runTaskAsynchronously(Tokens.getInstance(),
				new Runnable() {
					public void run() {
						try {
							PreparedStatement sql = mysql
									.getCurrentConnection()
									.prepareStatement(
											"INSERT INTO `mTokensData` (UUID, Tokens) VALUES (?,?) ON DUPLICATE KEY UPDATE Tokens = ?");
							sql.setString(1, p.getUniqueId().toString());
							sql.setInt(2, tokens);
							sql.setInt(3, tokens + fd.getTokens(p));
							sql.execute();
							sql.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				});
	}

	public void takeTokens(final Player p, final int tokens) {
		Bukkit.getScheduler().runTaskAsynchronously(Tokens.getInstance(),
				new Runnable() {
					public void run() {
						try {
							PreparedStatement sql = mysql
									.getCurrentConnection()
									.prepareStatement(
											"INSERT INTO `mTokensData` (UUID, Tokens) VALUES (?,?) ON DUPLICATE KEY UPDATE Tokens = ?");
							sql.setString(1, p.getUniqueId().toString());
							sql.setInt(2, fd.getTokens(p) - tokens);
							sql.setInt(3, fd.getTokens(p) - tokens);
							sql.execute();
							sql.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				});
	}
}
