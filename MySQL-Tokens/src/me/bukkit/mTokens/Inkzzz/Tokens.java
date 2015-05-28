package me.bukkit.mTokens.Inkzzz;

import me.bukkit.mTokens.Inkzzz.Listeners.Join;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Tokens extends JavaPlugin {

	private MySQL mysql = new MySQL();
	
	private static Tokens instance;
	
	public void onEnable() {
		instance = this;
		loadListeners();
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
	
	public static Tokens getInstance() { return instance; }
	
}
