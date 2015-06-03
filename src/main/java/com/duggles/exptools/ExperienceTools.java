package com.duggles.exptools;

import com.duggles.exptools.handler.ConfigurationHandler;
import com.duggles.exptools.init.ModBlocks;
import com.duggles.exptools.init.ModItems;
import com.duggles.exptools.proxy.IProxy;
import com.duggles.exptools.reference.Reference;
import com.duggles.exptools.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
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
        ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        final int WILDCARD_VALUE = Short.MAX_VALUE;
        ItemStack woodenPickaxe  = new ItemStack(Items.wooden_pickaxe,1,WILDCARD_VALUE);
        ItemStack stonePickaxe   = new ItemStack(Items.stone_pickaxe,1,WILDCARD_VALUE);
        ItemStack ironPickaxe    = new ItemStack(Items.iron_pickaxe,1,WILDCARD_VALUE);
        ItemStack woodenAxe      = new ItemStack(Items.wooden_axe,1,WILDCARD_VALUE);
        ItemStack stoneAxe       = new ItemStack(Items.stone_axe,1,WILDCARD_VALUE);
        ItemStack ironAxe        = new ItemStack(Items.iron_axe,1,WILDCARD_VALUE);
        ItemStack woodenSword    = new ItemStack(Items.wooden_sword,1,WILDCARD_VALUE);
        ItemStack stoneSword     = new ItemStack(Items.stone_sword,1,WILDCARD_VALUE);
        ItemStack ironSword      = new ItemStack(Items.iron_sword,1,WILDCARD_VALUE);
        ItemStack woodenShovel   = new ItemStack(Items.wooden_shovel,1,WILDCARD_VALUE);
        ItemStack stoneShovel    = new ItemStack(Items.stone_shovel,1,WILDCARD_VALUE);
        ItemStack ironShovel     = new ItemStack(Items.iron_shovel,1,WILDCARD_VALUE);
        ItemStack woodenHoe      = new ItemStack(Items.wooden_hoe,1,WILDCARD_VALUE);
        ItemStack stoneHoe       = new ItemStack(Items.stone_hoe,1,WILDCARD_VALUE);
        ItemStack ironHoe        = new ItemStack(Items.iron_hoe,1,WILDCARD_VALUE);
        ItemStack xpCrystal      = new ItemStack(ModItems.xpCrystal,1,WILDCARD_VALUE);

        //XpIngot
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.xpIngot), new Object[]{Items.iron_ingot,Items.emerald,Items.iron_ingot});


        GameRegistry.addRecipe(new ItemStack(ModItems.xpEnderPearl,1,ConfigurationHandler.pearlMaxCharge), new Object[]{" A ","ABA"," A ",'A', Items.ender_pearl, 'B', xpCrystal});
      //GameRegistry.addRecipe(new Itemstack(ModItems.magicMirror,1,ConfigurationHandler.mirrorMaxCharge), new Object[]{"","","",'A',,'B',});

        //XpCrystals
        GameRegistry.addRecipe(new ItemStack(ModItems.xpCrystal,1,500),      new Object[]{" A ","ABA"," A ",'A', ModItems.xpIngot, 'B', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpCrystalT2,1,1000),  new Object[]{" A ","ABA"," A ",'A', ModItems.xpIngot, 'B', xpCrystal});
        //GameRegistry.addRecipe(new ItemStack(ModItems.xpCrystalT3,1,2500),new Object[]{" A ","ABA"," A ",'A', ModItems.xpIngot, 'B', Items.emerald});
        //XpTools
        GameRegistry.addRecipe(new ItemStack(ModItems.xpPickaxe,1,1000),   new Object[]{"ACA"," B "," B ",'A', ModItems.xpIngot, 'B', Items.stick, 'C', xpCrystal});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpAxe,1,1000),       new Object[]{" CA"," BA"," B ",'A', ModItems.xpIngot, 'B', Items.stick, 'C', xpCrystal});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpSword,1,1000),     new Object[]{" C "," A "," B ",'A', ModItems.xpIngot, 'B', Items.stick, 'C', xpCrystal});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpShovel,1,1000),    new Object[]{" C "," B "," B ",'A', ModItems.xpIngot, 'B', Items.stick, 'C', xpCrystal});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpHoe,1,1000),       new Object[]{" CA"," B "," B ",'A', ModItems.xpIngot, 'B', Items.stick, 'C', xpCrystal});

//Vanilla Tool crafting/upgrade
    //Pickaxe
        GameRegistry.addRecipe(new ItemStack(Items.stone_pickaxe),  new Object[]{"AAA"," B ","   ",'A', Blocks.cobblestone, 'B', woodenPickaxe});
        GameRegistry.addRecipe(new ItemStack(Items.iron_pickaxe),   new Object[]{"AAA"," B ","   ",'A', Items.iron_ingot, 'B', stonePickaxe});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_pickaxe),new Object[]{"AAA"," B ","   ",'A', Items.diamond, 'B', ironPickaxe});
    //Axe
        GameRegistry.addRecipe(new ItemStack(Items.stone_axe),      new Object[]{" AA"," BA","   ",'A', Blocks.cobblestone, 'B', woodenAxe});
        GameRegistry.addRecipe(new ItemStack(Items.iron_axe),       new Object[]{" AA"," BA","   ",'A', Items.iron_ingot, 'B', stoneAxe});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_axe),    new Object[]{" AA"," BA","   ",'A', Items.diamond, 'B', ironAxe});
    //Sword
        GameRegistry.addRecipe(new ItemStack(Items.stone_sword),    new Object[]{" A "," A "," B ",'A', Blocks.cobblestone, 'B', woodenSword});
        GameRegistry.addRecipe(new ItemStack(Items.iron_sword),     new Object[]{" A "," A "," B ",'A', Items.iron_ingot, 'B', stoneSword});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_sword),  new Object[]{" A "," A "," B ",'A', Items.diamond, 'B', ironSword});
    //Shovel
        GameRegistry.addRecipe(new ItemStack(Items.stone_shovel),   new Object[]{" A "," B ","   ",'A', Blocks.cobblestone, 'B', woodenShovel});
        GameRegistry.addRecipe(new ItemStack(Items.iron_shovel),    new Object[]{" A "," B ","   ",'A', Items.iron_ingot, 'B', stoneShovel});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_shovel), new Object[]{" A "," B ","   ",'A', Items.diamond, 'B', ironShovel});

    //Hoe?
        GameRegistry.addRecipe(new ItemStack(Items.stone_hoe),      new Object[]{" AA"," B ","   ",'A', Blocks.cobblestone, 'B', woodenHoe});
        GameRegistry.addRecipe(new ItemStack(Items.iron_hoe),       new Object[]{" AA"," B ","   ",'A', Items.iron_ingot, 'B', stoneHoe});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_hoe),    new Object[]{" AA"," B ","   ",'A', Items.diamond, 'B', ironHoe});
    }
}
