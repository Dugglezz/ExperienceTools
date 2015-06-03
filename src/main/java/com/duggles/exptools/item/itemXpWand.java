package com.duggles.exptools.item;

import com.duggles.exptools.reference.Reference;

public class itemXpWand extends item_exptools {
    public itemXpWand() {
        super();
        this.setUnlocalizedName("xpWand");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MODID + ":xpWand");
        this.setMaxDamage(500);
        this.isDamageable();
    }
}