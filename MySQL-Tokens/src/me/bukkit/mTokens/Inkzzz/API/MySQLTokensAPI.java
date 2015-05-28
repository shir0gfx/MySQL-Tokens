package me.bukkit.mTokens.Inkzzz.API;

import me.bukkit.mTokens.Inkzzz.FetchData;
import me.bukkit.mTokens.Inkzzz.SetData;

import org.bukkit.entity.Player;

public class MySQLTokensAPI {

	SetData sd = new SetData();
	FetchData fd = new FetchData();

	public int getTokens(Player p) {
		return fd.getTokens(p);
	}

	public boolean hasTokens(Player p) {
		return fd.isInDb(p);
	}

	public void giveTokens(Player p, int amount) {
		sd.giveTokens(p, amount);
	}

	public void takeTokens(Player p, int amount) {
		sd.takeTokens(p, amount);
	}

}
