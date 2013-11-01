package com.octopod.nixium.nxtimesync;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.octopod.nixium.utils.NXTimer;

public class Timer {

	public Timer(final NXtimesync plugin){
		
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule doDaylightCycle false");
		YamlConfiguration config = Config.config;
		
		int interval;
		
		try{interval = config.getInt("update-interval");}catch(Exception e){interval = 60000;}
		
		NXTimer.runInterval((long)(interval / 50),
			new Runnable(){
		
				public void run(){plugin.updateTime();}
				
			}
		);
		
	}

}
