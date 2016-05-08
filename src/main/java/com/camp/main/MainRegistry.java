package com.camp.main;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.camp.block.BlockRegistry;
import com.camp.item.ItemRegistry;
import com.camp.lib.Strings;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Strings.MODID, name = Strings.name, version = Strings.version)

public class MainRegistry {
	
	@SidedProxy(clientSide = "com.camp.main.ClientProxy", serverSide = "com.camp.main.ServerProxy")
	public static ClientProxy proxy;
	
	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent){
		proxy.registerRenderThings();
		PlayGround.init();
		ItemRegistry.mainRegistry();
		BlockRegistry.mainRegistry();
		RecipeRegistry.mainRegistry();
		//PlayGround.addBlockRecipes();
	}
	
	@EventHandler
	public static void Load(FMLInitializationEvent Event){
		
	}
	
	@EventHandler
	public static void Postload(FMLPostInitializationEvent PostEvent){
		
	}

}
