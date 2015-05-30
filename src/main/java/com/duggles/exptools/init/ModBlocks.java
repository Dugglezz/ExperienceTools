package com.duggles.exptools.init;

import com.duggles.exptools.block.block_infuser;
import com.duggles.exptools.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks
{
    public final static Block xpInfuser = new block_infuser(Material.anvil)
            .setHardness(5.0F)
            .setStepSound(Block.soundTypeAnvil)
            .setBlockName("xpInfuser")
            .setCreativeTab(CreativeTabs.tabBlock);

    public static void init()
    {
        GameRegistry.registerBlock(xpInfuser, "xpInfuser");
    }
}
