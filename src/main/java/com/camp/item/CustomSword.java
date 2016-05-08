package com.camp.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.camp.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class CustomSword extends ItemSword{
	private String itemName = "Custom_Block_Name";
	private String itemTexture = "Custom_Block";
	private Object[] shapedRecipe;
	public CustomSword(ToolMaterial material){
 		super(material);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(1);
 		this.setTextureName(Strings.MODID + ":" + itemTexture);
	}

	public CustomSword setName(String name) {
		itemName = name;
		this.setUnlocalizedName(name);
		return this;
	}

	public CustomSword setTexture(String name) {
		itemTexture = name;
		this.setTextureName(Strings.MODID + ":" + itemTexture);
		return this;
	}
	public void setRecipe(Object... recipe){
		this.shapedRecipe = recipe;
	}
	public void addRecipe(){
		GameRegistry.addShapedRecipe(new ItemStack(this), shapedRecipe);
	}
	public void onKill(){
		
	}
	
}
			