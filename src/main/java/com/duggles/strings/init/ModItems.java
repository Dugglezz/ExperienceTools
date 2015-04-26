package com.duggles.strings.init;

import com.duggles.strings.item.item_strings;
import com.duggles.strings.item.ItemXpEnderP;
import com.duggles.strings.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems
{
    public static final item_strings xpEnderPearl = new ItemXpEnderP();

    public static void init()
    {
        GameRegistry.registerItem(xpEnderPearl, "xpEnderPearl");
    }
}