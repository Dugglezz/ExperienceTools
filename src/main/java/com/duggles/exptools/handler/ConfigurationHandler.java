package com.duggles.exptools.handler;

import com.duggles.exptools.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static int pearlXpCost;
    public static int pearlMaxCharge;
    public static int mirrorXpCost;
    public static int mirrorMaxCharge;
    public static int toolChargeCost;

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
        pearlMaxCharge  = configuration.getInt("pearlMaxCharge",    Configuration.CATEGORY_GENERAL, 10, 0, 20,  "Max number of uses of pearl");
        mirrorMaxCharge = configuration.getInt("mirrorMaxCharge",   Configuration.CATEGORY_GENERAL, 10, 0, 20,  "Max number of uses of magic mirror");
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
