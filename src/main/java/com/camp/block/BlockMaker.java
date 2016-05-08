package com.camp.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMaker {
	static ArrayList<Block> blockList = new ArrayList<Block>();
	
	public static ArrayList<Block> blockListMaker(){
		return blockList;
	}
	
	public static CustomBlock addBlock(String name){
		CustomBlock test = new CustomBlock(Material.rock);
		test.setName(name);
		test.setTexture(name);
		blockList.add(test);
		return test;
	}
}
