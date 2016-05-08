package com.camp.block;

import java.util.Random;

import com.camp.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomBlock extends Block{
	private String blockName = "Custom_Block_Name";
	private String blockTexture = "Custom_Block";
	private Object[] shapedRecipe;
	private boolean hasRecipe = false;
	private Item drop;
	protected CustomBlock(Material p_i45394_1_){
		super(p_i45394_1_);
		this.setBlockName(blockName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName(Strings.MODID + ":" + blockTexture);
	}
	public CustomBlock setName(String blockName){
		this.blockName = blockName;
		this.setBlockName(blockName);
		return this;
	}
	public CustomBlock setTexture(String text){
		this.blockTexture = text;
		this.setBlockTextureName(Strings.MODID + ":" + blockTexture);
		return this;
	}
	public void setRecipe(Object... recipe){
		hasRecipe = true;
		this.shapedRecipe = recipe;
	}
	public CustomBlock addRecipe(){
		GameRegistry.addShapedRecipe(new ItemStack(this), shapedRecipe);
		return this;
	}
	
	public CustomBlock addItemDropped(Item droppedItem){
		this.drop = droppedItem;
		return this;
	}
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
	    return this.drop;
	}
	
	public boolean hasRecipe(){
		return hasRecipe;
	}
}