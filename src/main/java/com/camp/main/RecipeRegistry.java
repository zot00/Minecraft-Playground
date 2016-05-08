package com.camp.main;
 
import com.camp.block.BlockRegistry;
import com.camp.block.CustomBlock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;


public class RecipeRegistry{
 
    public static void mainRegistry(){
        addCraftingRecipes();
        addSmeltingRecipes();
    }//end mainRegistry
  
 
    public static void addCraftingRecipes() {
    	for(Block each : BlockRegistry.blockList){
    		if(((CustomBlock)each).hasRecipe()){
    			((CustomBlock)each).addRecipe();
    		}
    		}
        //Shaped Recipes
 
    }//end addCraftingRecipes    
  
 
    public static void addSmeltingRecipes() {    
 
    }//end addSmeltingRecipes
 
}//end class
