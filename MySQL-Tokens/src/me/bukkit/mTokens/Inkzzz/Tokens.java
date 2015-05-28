package me.bukkit.mTokens.Inkzzz;

import me.bukkit.mTokens.Inkzzz.Commands.TokensCMD;
import me.bukkit.mTokens.Inkzzz.Listeners.Join;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Tokens extends JavaPlugin {

	private MySQL mysql = new MySQL();
	
	private static Tokens instance;
	
	public void onEnable() {
		instance = this;
		loadListeners();
		loadCommands();
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		mysql.checkTable();
	} 
	
	public void onDisable() {
		instance = null;
	}
	
	private void loadListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Join(), this);
	}
	
	private void loadCommands() {
		getCommand("tokens").setExecutor(new TokensCMD());
	}
	
	public static Tokens getInstance() { return instance; }
	
}
