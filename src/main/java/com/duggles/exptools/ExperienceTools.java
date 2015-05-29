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
        //ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        final int WILDCARD_VALUE = Short.MAX_VALUE;
        ItemStack woodenPickaxe = new ItemStack(Items.wooden_pickaxe,1,WILDCARD_VALUE);
        ItemStack stonePickaxe  = new ItemStack(Items.stone_pickaxe,1,WILDCARD_VALUE);
        ItemStack ironPickaxe   = new ItemStack(Items.iron_pickaxe,1,WILDCARD_VALUE);
        ItemStack diamondPickaxe= new ItemStack(Items.diamond_pickaxe,1,WILDCARD_VALUE);
        ItemStack woodenAxe     = new ItemStack(Items.wooden_axe,1,WILDCARD_VALUE);
        ItemStack stoneAxe      = new ItemStack(Items.stone_axe,1,WILDCARD_VALUE);
        ItemStack ironAxe       = new ItemStack(Items.iron_axe,1,WILDCARD_VALUE);
        ItemStack diamondAxe       = new ItemStack(Items.diamond_axe,1,WILDCARD_VALUE);
        ItemStack woodenSword   = new ItemStack(Items.wooden_sword,1,WILDCARD_VALUE);
        ItemStack stoneSword    = new ItemStack(Items.stone_sword,1,WILDCARD_VALUE);
        ItemStack ironSword     = new ItemStack(Items.iron_sword,1,WILDCARD_VALUE);
        ItemStack diamondSword     = new ItemStack(Items.diamond_sword,1,WILDCARD_VALUE);

        //XpIngot
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.xpIngot), new Object[]{Items.iron_ingot,Items.emerald,Items.iron_ingot});
        //XpEnderPearl
        GameRegistry.addRecipe(new ItemStack(ModItems.xpEnderPearl), new Object[]{"BAB","ACA","BAB",'A', ModItems.xpIngot, 'B', Items.emerald, 'C', Items.ender_pearl});
        //XpTools
        GameRegistry.addRecipe(new ItemStack(ModItems.xpPickaxe), new Object[]{"AAA"," B "," B ",'A', ModItems.xpIngot, 'B', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpAxe), new Object[]{" AA"," BA"," B ",'A', ModItems.xpIngot, 'B', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpSword), new Object[]{" A "," A "," B ",'A', ModItems.xpIngot, 'B', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpShovel), new Object[]{" A "," B "," B ",'A', ModItems.xpIngot, 'B', Items.stick});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpHoe), new Object[]{" AA"," B "," B ",'A', ModItems.xpIngot, 'B', Items.stick});
//Vanilla Tool crafting/upgrade
    //Pickaxe
        GameRegistry.addRecipe(new ItemStack(Items.stone_pickaxe), new Object[]{"AAA"," B ","   ",'A', Blocks.cobblestone, 'B', woodenPickaxe});
        GameRegistry.addRecipe(new ItemStack(Items.iron_pickaxe), new Object[]{"AAA"," B ","   ",'A', Items.iron_ingot, 'B', stonePickaxe});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_pickaxe), new Object[]{"AAA"," B ","   ",'A', Items.diamond, 'B', ironPickaxe});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpPickaxe), new Object[]{"AAA"," B ","   ",'A', ModItems.xpIngot, 'B', diamondPickaxe});
    //Axe
        GameRegistry.addRecipe(new ItemStack(Items.stone_axe), new Object[]{" AA"," BA","   ",'A', Blocks.cobblestone, 'B', woodenAxe});
        GameRegistry.addRecipe(new ItemStack(Items.iron_axe), new Object[]{" AA"," BA","   ",'A', Items.iron_ingot, 'B', stoneAxe});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_axe), new Object[]{" AA"," BA","   ",'A', Items.diamond, 'B', ironAxe});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpAxe), new Object[]{" AA"," BA","   ",'A', ModItems.xpIngot, 'B', diamondAxe});
    //Sword
        GameRegistry.addRecipe(new ItemStack(Items.stone_sword), new Object[]{" A "," A "," B ",'A', Blocks.cobblestone, 'B', woodenSword});
        GameRegistry.addRecipe(new ItemStack(Items.iron_sword), new Object[]{" A "," A "," B ",'A', Items.iron_ingot, 'B', stoneSword});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_sword), new Object[]{" A "," A "," B ",'A', Items.diamond, 'B', ironSword});
        GameRegistry.addRecipe(new ItemStack(ModItems.xpSword), new Object[]{" A "," A "," B ",'A', ModItems.xpIngot, 'B', diamondSword});
    }
}
