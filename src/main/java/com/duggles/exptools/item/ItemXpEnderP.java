package com.duggles.exptools.item;

import com.duggles.exptools.handler.ConfigurationHandler;
import com.duggles.exptools.reference.Reference;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemXpEnderP extends item_exptools {
    public ItemXpEnderP() {
        super();
        this.setUnlocalizedName("xpEnderP");
        this.setMaxStackSize(1);
        this.setTextureName(Reference.MODID + ":xpEnderP");
        this.setMaxDamage(10);
        this.isDamageable();
    }
int charge = 10;

    public void onCreated(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {
        charge = 0;
        //p_77622_1_.setItemDamage(1);
    }

    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        if (p_77659_3_.capabilities.isCreativeMode) {
            return p_77659_1_;
        } else {

            if (p_77659_3_.isSneaking()) {
                if (!p_77659_2_.isRemote) {
                    if (charge<ConfigurationHandler.maxCharges & p_77659_3_.experienceLevel>ConfigurationHandler.xpCost){p_77659_1_.damageItem(-1, p_77659_3_);
                        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.successful_hit", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                        p_77659_3_.addExperienceLevel(-ConfigurationHandler.xpCost);
                        p_77659_1_.damageItem(-1, p_77659_3_);
                        charge=charge+2;
                    } else { p_77659_2_.playSoundAtEntity(p_77659_3_, "random.fizz", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));}}
            } else if (!p_77659_2_.isRemote){
                if (p_77659_1_.getItemDamage()==(ConfigurationHandler.maxCharges)) {
                    p_77659_2_.playSoundAtEntity(p_77659_3_, "random.fizz", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                }else{
                p_77659_2_.playSoundAtEntity(p_77659_3_, "random.successful_hit", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                p_77659_2_.spawnEntityInWorld(new EntityEnderPearl(p_77659_2_, p_77659_3_));
                p_77659_1_.damageItem(1, p_77659_3_);
                charge--;}}
        }


        return p_77659_1_;
    }


}

