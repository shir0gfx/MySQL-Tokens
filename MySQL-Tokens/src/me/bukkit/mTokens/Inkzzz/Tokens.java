package me.bukkit.mTokens.Inkzzz;

import org.bukkit.plugin.java.JavaPlugin;

public class Tokens extends JavaPlugin {

	private static Tokens instance;
	
	public void onEnable() {
		instance = this;
	}
	
	public void onDisable() {
		instance = null;
	}
	
	public static Tokens getInstance() { return instance; }
	
}
