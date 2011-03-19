package com.niccholaspage.nAliases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class nAliases extends JavaPlugin {
	private final nAliasesPlayerListener playerListener = new nAliasesPlayerListener(this);
	public ArrayList<Alias> aliases = new ArrayList<Alias>();
    @Override
	public void onDisable() {
		//Print "Basic Disabled" on the log.
		System.out.println("nAliases Disabled");
		
	}
    @Override
	public void onEnable() {
		//Create the pluginmanage pm.
		PluginManager pm = getServer().getPluginManager();
		//Create PlayerCommand listener
	    pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, this.playerListener, Event.Priority.Normal, this);
       //Get the infomation from the yml file.
        PluginDescriptionFile pdfFile = this.getDescription();
        //Print that the plugin has been enabled!
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
        readConfig();
	}
	public static ArrayList<String> filetoarray(BufferedReader in){
		  String line = "";
		  ArrayList<String> data = new ArrayList<String>();
		  try {
		   while((line = in.readLine()) != null) {
		 
		    data.add(line);
		   }
		  }
		  catch(FileNotFoundException fN) {
		  }
		  catch(IOException e) {
		  }
		  return data;
	}
    public void readConfig(){
			File f = new File("plugins/nAliases/");
			BufferedReader in = null;
			ArrayList <String> data = new ArrayList<String>();
			if (!(f.exists())){
				f.mkdir();
			}
			f = new File("plugins/nAliases/commands.txt");
			if (!(f.exists())){
    	    	try {
					f.createNewFile();
					System.out.println("Add your aliases in plugins/nAliases/commands.txt.");
					return;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
	      try{
	    	    FileReader fstream = new FileReader("plugins/nAliases/commands.txt");
	    	    in = new BufferedReader(fstream);
	    	    }catch (Exception e){
	    	    }
	    		data = filetoarray(in);
	    		Alias temp;
	    		for (int i = 0; i < data.size(); i++){
	    			temp = new Alias();
	    			temp.setCommand(data.get(i).split(":")[1]);
	    			temp.setAlias(data.get(i).split(":")[0]);
	    			aliases.add(temp);
	    		}
    }
}
