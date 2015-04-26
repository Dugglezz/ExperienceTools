package com.duggles.strings.creativetab;


import com.duggles.strings.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabStrings
{
    public static final CreativeTabs Strings_TAB = new CreativeTabs(Reference.MODID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.diamond;
        }
    };
}
