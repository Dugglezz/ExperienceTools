package com.duggles.exptools.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class block_infuser extends Block{
    public block_infuser (Material material){
        super(material);
        setHarvestLevel("pickaxe",0);
    }

}
