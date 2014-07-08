package com.chyromyr.lmr.handler;

import com.chyromyr.lmr.reference.Reference;
import com.chyromyr.lmr.utility.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
	public static Configuration configuration;
	public static boolean debugMode = true;

	public static void init(File configFile)
	{
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent evt)
	{
		LogHelper.info("onConfigChangedEvent " + evt.modID);
		if (evt.modID.equalsIgnoreCase(Reference.MOD_ID))
			loadConfiguration();
	}

	public static void loadConfiguration()
	{
		if (configuration == null)
			return;

		//configuration.get().getType();

		debugMode = configuration.get(Configuration.CATEGORY_GENERAL, "debugMode", debugMode).getBoolean(debugMode);

		if (configuration.hasChanged())
			configuration.save();
	}
}
