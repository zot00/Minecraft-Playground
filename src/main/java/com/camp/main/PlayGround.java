package com.camp.main;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;

import com.camp.block.BlockMaker;
import com.camp.block.BlockRegistry;
import com.camp.block.CustomBlock;
import com.camp.item.ItemMaker;

import cpw.mods.fml.common.registry.GameRegistry;

public class PlayGround {
	static CustomBlock test;

	public static void init() {

		// Using BlockMaker class
		BlockMaker.addBlock("UFO");
		BlockMaker.addBlock("TEST");
		test = BlockMaker.addBlock("drew");
		test.setName("The magical BLock!");
		test.setRecipe("wsw", 'w', Items.wheat, 's', Items.sugar);

		BlockMaker.addBlock("yell").addItemDropped(Items.baked_potato);
		
		// creating swords and chaining
		ItemMaker.newSword("Waffle").setName("Not waffles")
				.setTexture("waffle_sword");

		ItemMaker.newSword("potion").setCreativeTab(CreativeTabs.tabCombat);
		ItemMaker.newSword("Waffle");
		ItemMaker.newSword("drew");

	}

}
