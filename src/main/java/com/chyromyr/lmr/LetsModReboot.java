package com.chyromyr.lmr;

import com.chyromyr.lmr.handler.ConfigurationHandler;
import com.chyromyr.lmr.proxy.IProxy;
import com.chyromyr.lmr.reference.Reference;
import com.chyromyr.lmr.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version= Reference.VERSION, guiFactory = Reference.GUI_FACTORY)
public class LetsModReboot {

    @Mod.Instance(Reference.MOD_ID)
    public static LetsModReboot instance;

    @SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_SERVER)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
		ConfigurationHandler.init(evt.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		LogHelper.info("preInit");
	}

    @Mod.EventHandler
    public void init(FMLInitializationEvent evt)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {

    }
}
