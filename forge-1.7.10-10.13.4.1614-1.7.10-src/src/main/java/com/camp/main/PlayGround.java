package com.camp.main;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
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
		test = BlockMaker.addBlock("Ugly_Block");
		
		test.setName("Ugly Ore");
		test.setRecipe("wsw", 'w', Items.wheat, 's', Items.sugar);

		BlockMaker.addBlock("uglyblock").addItemDropped(Blocks.diamond_block);
		
		// creating swords and chaining
		ItemMaker.newSword("Waffle").setName("Not waffles")
				.setTexture("waffle_sword");
		
		ItemMaker.newSword("potion").setCreativeTab(CreativeTabs.tabCombat);
		ItemMaker.newSword("Waffle");
		ItemMaker.newSword("drew");
		ItemMaker.newSword("BB");
		ItemMaker.newSword("big sword");
		ItemMaker.newSword("bowsword");
	}

}
