package com.octopod.nixium.utils;

import org.bukkit.scheduler.BukkitTask;

import com.octopod.nixium.nxtimesync.NXtimesync;

public class NXTimer {
	
	static NXtimesync plugin;
	
	public NXTimer(NXtimesync plugin){NXTimer.plugin = plugin;}
	
	public static BukkitTask runTimeout(long delay, Runnable code) {

		BukkitTask ID = plugin.getServer().getScheduler().runTaskLaterAsynchronously(plugin, code, delay);
		return ID;
		
	}
	
	public static BukkitTask runInterval(long delay, Runnable code) {

		BukkitTask ID = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, code, delay, delay);
		return ID;
		
	}
	
}
