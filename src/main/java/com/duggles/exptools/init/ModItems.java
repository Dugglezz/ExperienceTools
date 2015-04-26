package com.duggles.exptools.init;

import com.duggles.exptools.item.item_exptools;
import com.duggles.exptools.item.ItemXpEnderP;
import com.duggles.exptools.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems
{
    public static final item_exptools xpEnderPearl = new ItemXpEnderP();

    public static void init()
    {
        GameRegistry.registerItem(xpEnderPearl, "xpEnderPearl");
    }
}