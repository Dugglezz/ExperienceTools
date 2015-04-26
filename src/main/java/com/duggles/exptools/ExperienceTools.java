package com.duggles.exptools;


import com.duggles.exptools.init.ModItems;
import com.duggles.exptools.proxy.IProxy;
import com.duggles.exptools.reference.Reference;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import com.duggles.exptools.handler.ConfigurationHandler;
import com.duggles.exptools.utility.LogHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class ExperienceTools
{
    @Mod.Instance(Reference.MODID)
    public static ExperienceTools instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @EventHandler
    public void init(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        //ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.xpEnderPearl), new Object[]{
                "AAA",
                "AAA",
                "AAA",
                'A', Items.apple
        });
    }
}