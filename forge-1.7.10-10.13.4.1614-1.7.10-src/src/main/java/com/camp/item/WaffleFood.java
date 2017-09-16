package com.camp.item;

import com.camp.lib.Strings;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class WaffleFood extends ItemFood{
	  private final int healAmount;
	public WaffleFood(int p_i45339_1_, int p_i45340_1_, boolean p_i45340_2_) {
		super(p_i45340_1_, p_i45340_2_);
        this.healAmount = p_i45339_1_;
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName("Waffle").setTextureName(Strings.MODID + ":" + "Waffle");
	}
	
}
