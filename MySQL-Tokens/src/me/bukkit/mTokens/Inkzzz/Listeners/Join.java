package me.bukkit.mTokens.Inkzzz.Listeners;

import me.bukkit.mTokens.Inkzzz.FetchData;
import me.bukkit.mTokens.Inkzzz.SetData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

	SetData sd = new SetData();
	FetchData fd = new FetchData();

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (!fd.isInDb(p)) {
			sd.giveTokens(p, 0);
		}
	}

}
