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
		Util.log("Inactif");
	}

	@Override
	public void onEnable()
	{
		plugin.getServer().getPluginManager().registerEvents(new AmaTreeBlockListener(), this);
		Util.log("Actif");
	}
}
