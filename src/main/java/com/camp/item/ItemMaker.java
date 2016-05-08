package com.camp.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;

import com.camp.block.CustomBlock;

public class ItemMaker {
static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public static ArrayList<Item> itemListMaker(){
		return itemList;
	}
	
	public static CustomSword newSword(String name){
		CustomSword test = new CustomSword(ToolMaterial.EMERALD);
		test.setName(name);
		test.setTexture(name);
		itemList.add(test);
		return test;
	}
	
	/*public static ItemFood addFood(String name){
		ItemFood test = new ItemFood(0, false);
		test.setName(name);
		test.setTexture(name);
		itemList.add(test);
		return test;
	}*/
}
