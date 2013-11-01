package com.octopod.nixium.nxtimesync;

import java.util.Calendar;

import com.octopod.nixium.nxtimesync.Config;
import com.octopod.nixium.utils.NXTimer;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class NXtimesync extends JavaPlugin{
	
	public final NXtimesync plugin = this;
	
	public void console(String msg){plugin.getLogger().info(msg);}
	
	@Override
	public void onEnable(){
		new Config(this);
		new NXTimer(this);
		new Timer(this);
		new Commands(this);
	}
	
	public void updateTime(){
		
		YamlConfiguration config = Config.config;
		Calendar cal = Calendar.getInstance();

		int h = cal.get(Calendar.HOUR) * 1000;
		int m = (int)Math.floor(cal.get(Calendar.MINUTE) * 1000 / 60);
		
		long time = (long)((h + m) - 7000);
		if(time < 0){time = time + 24000;}
		
		for(String worldname:config.getConfigurationSection("worlds").getKeys(false)){
			int offset = config.getInt("worlds."+ worldname);
			long newTime = time + offset;
			plugin.getServer().getWorld("world").setTime(newTime);
		}
		
	}
	
}
