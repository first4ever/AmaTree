package com.first4ever.amatree;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class AmaTreeBlockListener implements Listener
{
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e)
	{
		if (e.isCancelled())
			return;
		
		final Block bloc = e.getBlock();

		if (bloc.getTypeId() != 17)
			return;

		final byte data = bloc.getData();
		Player p = e.getPlayer();

		boolean permEntire = Methods.hasPerm(p, "amatree.entiretree");
		boolean permReplant = Methods.hasPerm(p, "amatree.replanting");

		if (! permEntire && ! permReplant)
			return;

		if (permEntire)
		{
			int i = 1;
			boolean finished = false;

			while (! finished)
			{
				Block b = bloc.getRelative(BlockFace.UP, i);
				
				if (b.getTypeId() == 17)
					b.breakNaturally();
				else
					finished = true;
				i++;
			}
		}

		if (permReplant)
		{
			int id = bloc.getRelative(BlockFace.DOWN).getTypeId();
			
			if (id != 2 && id != 3)
				return;

			Core.plugin.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin, new Runnable() 
			{
				public void run()
				{
					if (bloc.getTypeId() == 0)
					{
						bloc.setTypeId(6);
						bloc.setData(data);
					}
				}
			}
			, 1 * 20L);
		}
	}
}