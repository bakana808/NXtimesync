package com.octopod.nixium.nxtimesync;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	static NXtimesync plugin;
	static YamlConfiguration defaultConfig;
	static YamlConfiguration config;
	
	public Config(NXtimesync plugin){
		Config.plugin = plugin;
		Config.defaultConfig = YamlConfiguration.loadConfiguration(plugin.getResource("config.yml"));
		if(!configExists()){
			boolean result = configOverwrite();
			if(result){
				plugin.console("New config written successfully!");
			}else {
				plugin.console("New config failed to write!");
			}
		}
		Config.config = readConfig();
	}
	
	public YamlConfiguration readConfig(){
		
		File file = new File("plugins/NXtimesync/config.yml");
		
		if(file.exists()){
			return YamlConfiguration.loadConfiguration(file);
		}else{
			return defaultConfig;
		}
		
	}
	
	public boolean configExists(){
		
		File file = new File("plugins/NXtimesync/config.yml");
		return file.exists();
		
	}
	
	public boolean configOverwrite(){
		
		try{
			File file = new File("plugins/NXtimesync/config.yml");
			Config.defaultConfig.save(file);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
