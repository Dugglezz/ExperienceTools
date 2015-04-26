package com.duggles.strings.handler;

import com.duggles.strings.Strings;
import com.duggles.strings.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static int xpCost;
    public static int maxCharges;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        xpCost = configuration.getInt("xpCost", Configuration.CATEGORY_GENERAL, 2, 0, 30, "Experience cost of XpPearl:any value between 0-20");
        maxCharges = configuration.getInt("maxCharges", Configuration.CATEGORY_GENERAL, 10, 0, 100, "Max number of uses of pearl:any value between 0-20");
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MODID))
        {
            loadConfiguration();
        }
    }
}
