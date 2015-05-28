package me.bukkit.mTokens.Inkzzz.Commands;

import me.bukkit.mTokens.Inkzzz.FetchData;
import me.bukkit.mTokens.Inkzzz.SetData;
import me.bukkit.mTokens.Inkzzz.Handlers.TokensHandler;
import me.bukkit.mTokens.Inkzzz.Utils.Chatter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokensCMD implements CommandExecutor {

	SetData sd = new SetData();
	FetchData fd = new FetchData();
	TokensHandler th = new TokensHandler();

	public boolean onCommand(CommandSender sender, Command cmd, String string,
			String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("tokens")) {
				if (args.length == 0) {
					p.sendMessage(Chatter.color("&6&lTokens &8&l"
							+ Chatter.arrow() + " &7You have &e"
							+ fd.getTokens(p) + " &7tokens."));
					return true;
				} else if (args.length == 2) {
					if (p.hasPermission("tokens.reset")) {
						if (args[0].equalsIgnoreCase("reset")) {
							Player target = Bukkit.getPlayer(args[1]);
							if (target != null) {
								sd.resetTokens(target);
								p.sendMessage(Chatter.color("&6&lTokens &8&l"
										+ Chatter.arrow()
										+ " &7You have reset &e"
										+ target.getName() + "'s &7tokens!"));
								return true;
							} else
								th.playerOffline(p, args[1]);
						} else
							th.tokensHelp(p);
					} else
						th.noperm(p);
				} else if (args.length == 3) {
					if (p.hasPermission("tokens.admin")) {
						if (th.isInt(args[2])) {
							Player target = Bukkit.getPlayer(args[1]);
							int tokens = Integer.valueOf(args[2]);
							if (args[0].equalsIgnoreCase("give")) {
								if (target != null) {
									sd.giveTokens(target, tokens);
									th.giveTokensMSG(p, target, tokens);
								} else
									th.playerOffline(p, args[1]);
							} else if (args[0].equalsIgnoreCase("take")) {
								if (target != null) {
									sd.takeTokens(target, tokens);
									th.takeTokensMSG(p, target, tokens);
								} else
									th.playerOffline(p, args[1]);
							}
						} else
							p.sendMessage(Chatter.color("&c&lError &8&l"
									+ Chatter.arrow() + " &e" + args[2]
									+ " &7isn't a number!"));
					} else
						th.noperm(p);
				}
			}
		} else {
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) {
						sd.resetTokens(target);
					}
				}
			} else if (args.length == 3) {
				if (th.isInt(args[2])) {
					Player target = Bukkit.getPlayer(args[1]);
					int tokens = Integer.valueOf(args[2]);
					if (args[0].equalsIgnoreCase("give")) {
						if (target != null) {
							sd.giveTokens(target, tokens);
						}
					} else if (args[0].equalsIgnoreCase("take")) {
						if (target != null) {
							sd.takeTokens(target, tokens);
						}
					}
				} else
					sender.sendMessage(Chatter.color("&e" + args[2]
							+ " &7isn't a number!"));
			}
		}
		return false;
	}

}
