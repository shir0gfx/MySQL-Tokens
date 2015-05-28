package me.bukkit.mTokens.Inkzzz.Commands;

import me.bukkit.mTokens.Inkzzz.FetchData;
import me.bukkit.mTokens.Inkzzz.Utils.Chatter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokensCMD implements CommandExecutor {

	FetchData fd = new FetchData();

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
				}
			}
		}
		return false;
	}

}
