package com.first4ever.amatree;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

	public static Core plugin;

	public Core()
	{
		plugin = this;
	}

	// ===========================================================================

	@Override
	public void onDisable()
	{
		Methods.log("Inactif");
	}

	@Override
	public void onEnable()
	{
		plugin.getServer().getPluginManager().registerEvents(new AmaTreeBlockListener(), this);
		Methods.log("Actif");
	}
}
