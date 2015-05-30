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
    public static int toolChargeCost;
    public static int crystalDurability;
    public static int crystalT2Durability;
    public static int crystalT3Durability;

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
        pearlXpCost     = configuration.getInt("pearlXpCost",       Configuration.CATEGORY_GENERAL, 1, 0, 20,   "Experience cost of XpPearl");
        pearlMaxCharge  = configuration.getInt("pearlMaxCharge",    Configuration.CATEGORY_GENERAL, 10, 0, 20,  "Max number of uses of pearl");
        toolChargeCost  = configuration.getInt("toolChargeCost",    Configuration.CATEGORY_GENERAL, 1, 0, 30,   "Experience cost of recharging a tool");

        crystalDurability =     configuration.getInt("crystalDurability",   Configuration.CATEGORY_GENERAL, 500, 0, 1000,   "Max amount of experience the crystal can store");
        crystalT2Durability =   configuration.getInt("crystalT2Durability", Configuration.CATEGORY_GENERAL, 1000, 0, 2500,    "Max amount of experience the tier 2 crystal can store");
        crystalT3Durability =   configuration.getInt("crystalT3Durability", Configuration.CATEGORY_GENERAL, 2500, 0, 10000, "Max amount of experience the tier 3 crystal can store");
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
