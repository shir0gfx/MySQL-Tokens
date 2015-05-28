package me.bukkit.mTokens.Inkzzz.Handlers;

import me.bukkit.mTokens.Inkzzz.Utils.Chatter;

import org.bukkit.entity.Player;

public class TokensHandler {

	public boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void giveTokensMSG(Player p, Player target, int tokens) {
		p.sendMessage(Chatter.color("&6&lTokens &8&l" + Chatter.arrow()
				+ " &7You have given &e" + tokens + " &7tokens to &e"
				+ target.getName() + "&7."));
		target.sendMessage(Chatter.color("&6&lTokens &8&l" + Chatter.arrow()
				+ " &e" + p.getName() + " &7has given you &e" + tokens
				+ " &7tokens."));
		return;
	}

	public void takeTokensMSG(Player p, Player target, int tokens) {
		p.sendMessage(Chatter.color("&6&lTokens &8&l" + Chatter.arrow()
				+ " &7You have taken &e" + tokens + " &7tokens from &e"
				+ target.getName() + "'s &7account."));
		target.sendMessage(Chatter.color("&6&lTokens &8&l" + Chatter.arrow()
				+ " &e" + p.getName() + " &7has taken &e" + tokens
				+ " &7tokens from your account."));
		return;
	}

	public void noperm(Player p) {
		p.sendMessage(Chatter.color("&c&lPermission &8&l" + Chatter.arrow()
				+ " &7You don't have permission!"));
		return;
	}
	
	public void playerOffline(Player p, String s) {
		p.sendMessage(Chatter.color("&c&lError &8&l" + Chatter.arrow() + " &e" + s + " &7isn't online."));
	}
	
	public void tokensHelp(Player p) {
		p.sendMessage(Chatter.color("&c&m====================================="));
		p.sendMessage(Chatter.color("&7> &6&lTokens&7:"));
		p.sendMessage(Chatter.color(" "));
		p.sendMessage(Chatter.color("&7> &e/tokens"));
		p.sendMessage(Chatter.color("&7> &e/tokens reset <player>"));
		p.sendMessage(Chatter.color("&7> &e/tokens give <player> <amount>"));
		p.sendMessage(Chatter.color("&7> &e/tokens take <player> <amount>"));
		p.sendMessage(Chatter.color(" "));
		p.sendMessage(Chatter.color("&c&m====================================="));
	}

}
