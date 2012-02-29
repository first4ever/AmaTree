package com.first4ever.amatree;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.entity.Player;

public class Methods
{
	// Logging
	static Logger log = Logger.getLogger("Minecraft");
	static String prefix = "[AmaTree] ";

	public static void log(String msg, Level l)
	{
		if (l == Level.WARNING)
			log.warning(prefix + msg);
		else if (l == Level.SEVERE)
			log.severe(prefix + msg);
		else
			log.info(prefix + msg);
	}

	public static void log(String msg)
	{
		log(msg, Level.INFO);
	}


	// Permissions
	static boolean hasPerm(Player p, String perm)
	{
		if (p.hasPermission(perm))
			return true;

		return false;
	}
}
