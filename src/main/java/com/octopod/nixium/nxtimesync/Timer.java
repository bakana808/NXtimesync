package com.octopod.nixium.nxtimesync;

import org.bukkit.Bukkit;

import com.octopod.nixium.utils.NXTimer;

public class Timer {

	public Timer(final NXtimesync plugin){
		
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule doDaylightCycle false");
		NXTimer.runInterval(20L,
				new Runnable(){
			
					public void run(){plugin.updateTime();}
					
				}
			);
		
	}

}
