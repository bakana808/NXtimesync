package com.octopod.nixium.nxtimesync;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.octopod.nixium.nxtimesync.NXtimesync;

public class Commands implements Listener{

	NXtimesync plugin;
	
    public Commands(NXtimesync plugin){
    	this.plugin = plugin;
    	plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    final public String pre = ChatColor.GRAY + "[" + ChatColor.AQUA + "NXtime" + ChatColor.GRAY + "] " + ChatColor.WHITE;
    
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){

        Player player = event.getPlayer();
        String[] args = event.getMessage().split(" ");
        
        if(args[0].equalsIgnoreCase("/nxtime")){
        	
        	event.setCancelled(true);
        	
        	if(args.length == 1){
        		
        		SimpleDateFormat date = new SimpleDateFormat("HH:mm");
        		String format = date.format(new Date());
        		player.sendMessage(pre + "The current time is " + ChatColor.AQUA + format);
        		player.sendMessage(pre + "NXtimesync " + plugin.getDescription().getVersion() + " by Octopod");
        		return;
        		
        	}
        	
        	if(args[1].equalsIgnoreCase("info")){
        		
        		YamlConfiguration config = Config.config;
        		World world = player.getWorld();
        		
        		if(config.getConfigurationSection("worlds").getKeys(false).contains(world.getName())){
        			
        			try{
	        			player.sendMessage(
	        				pre + "The offset in this world is " + ChatColor.AQUA + 
	        				config.getInt("worlds." + world.getName() + ".offset") + ChatColor.WHITE + " ticks."
	        			);
        			}catch(Exception e){}
        			
        		}else{
        			
        			player.sendMessage(pre + "This world is not affected by this plugin.");
        			
        		}
        		
        	}
        	
        }

    }
        
}
