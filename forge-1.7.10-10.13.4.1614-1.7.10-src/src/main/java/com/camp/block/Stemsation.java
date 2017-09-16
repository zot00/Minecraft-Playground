package com.camp.block;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.camp.lib.Strings;

public class Stemsation extends Block{
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	protected Stemsation(Material p_i45394_1_,Item drop, int meta, int least_quantity, int most_quantity){
		super(p_i45394_1_);
		this.setTickRandomly(true);
		this.drop = drop;
	    this.meta = meta;
	    this.least_quantity = least_quantity;
	    this.most_quantity = most_quantity;
		this.setBlockName("WaffleBlock1");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockTextureName(Strings.MODID + ":" + "TEST");
	}
	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
	    return this.drop;
	}

	 public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
	    {
	        if (p_149674_1_.getGameRules().getGameRuleBooleanValue("doFireTick"))
	        {
	            boolean flag = p_149674_1_.getBlock(p_149674_2_, p_149674_3_ - 1, p_149674_4_).isFireSource(p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_, UP);

	            if (!this.canPlaceBlockAt(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_))
	            {
	                p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
	            }

	            if (!flag && p_149674_1_.isRaining() && (p_149674_1_.canLightningStrikeAt(p_149674_2_, p_149674_3_, p_149674_4_) || p_149674_1_.canLightningStrikeAt(p_149674_2_ - 1, p_149674_3_, p_149674_4_) || p_149674_1_.canLightningStrikeAt(p_149674_2_ + 1, p_149674_3_, p_149674_4_) || p_149674_1_.canLightningStrikeAt(p_149674_2_, p_149674_3_, p_149674_4_ - 1) || p_149674_1_.canLightningStrikeAt(p_149674_2_, p_149674_3_, p_149674_4_ + 1)))
	            {
	                p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
	            }
	            else
	            {
	                int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);

	                if (l < 15)
	                {
	                    p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_, p_149674_4_, l + p_149674_5_.nextInt(3) / 2, 4);
	                }

	                p_149674_1_.scheduleBlockUpdate(p_149674_2_, p_149674_3_, p_149674_4_, this, this.tickRate(p_149674_1_) + p_149674_5_.nextInt(10));

	                if (!flag && !this.canNeighborBurn(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_))
	                {
	                    if (!World.doesBlockHaveSolidTopSurface(p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_) || l > 3)
	                    {
	                        p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
	                    }
	                }
	                else if (!flag && !this.canCatchFire(p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_, UP) && l == 15 && p_149674_5_.nextInt(4) == 0)
	                {
	                    p_149674_1_.setBlockToAir(p_149674_2_, p_149674_3_, p_149674_4_);
	                }
	                else
	                {
	                    boolean flag1 = p_149674_1_.isBlockHighHumidity(p_149674_2_, p_149674_3_, p_149674_4_);
	                    byte b0 = 0;

	                    if (flag1)
	                    {
	                        b0 = -50;
	                    }

	                    this.tryCatchFire(p_149674_1_, p_149674_2_ + 1, p_149674_3_, p_149674_4_, 300 + b0, p_149674_5_, l, WEST );
	                    this.tryCatchFire(p_149674_1_, p_149674_2_ - 1, p_149674_3_, p_149674_4_, 300 + b0, p_149674_5_, l, EAST );
	                    this.tryCatchFire(p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_, 250 + b0, p_149674_5_, l, UP   );
	                    this.tryCatchFire(p_149674_1_, p_149674_2_, p_149674_3_ + 1, p_149674_4_, 250 + b0, p_149674_5_, l, DOWN );
	                    this.tryCatchFire(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_ - 1, 300 + b0, p_149674_5_, l, SOUTH);
	                    this.tryCatchFire(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_ + 1, 300 + b0, p_149674_5_, l, NORTH);

	                    for (int i1 = p_149674_2_ - 1; i1 <= p_149674_2_ + 1; ++i1)
	                    {
	                        for (int j1 = p_149674_4_ - 1; j1 <= p_149674_4_ + 1; ++j1)
	                        {
	                            for (int k1 = p_149674_3_ - 1; k1 <= p_149674_3_ + 4; ++k1)
	                            {
	                                if (i1 != p_149674_2_ || k1 != p_149674_3_ || j1 != p_149674_4_)
	                                {
	                                    int l1 = 100;

	                                    if (k1 > p_149674_3_ + 1)
	                                    {
	                                        l1 += (k1 - (p_149674_3_ + 1)) * 100;
	                                    }

	                                    int i2 = this.getChanceOfNeighborsEncouragingFire(p_149674_1_, i1, k1, j1);

	                                    if (i2 > 0)
	                                    {
	                                        int j2 = (i2 + 40 + p_149674_1_.difficultySetting.getDifficultyId() * 7) / (l + 30);

	                                        if (flag1)
	                                        {
	                                            j2 /= 2;
	                                        }

	                                        if (j2 > 0 && p_149674_5_.nextInt(l1) <= j2 && (!p_149674_1_.isRaining() || !p_149674_1_.canLightningStrikeAt(i1, k1, j1)) && !p_149674_1_.canLightningStrikeAt(i1 - 1, k1, p_149674_4_) && !p_149674_1_.canLightningStrikeAt(i1 + 1, k1, j1) && !p_149674_1_.canLightningStrikeAt(i1, k1, j1 - 1) && !p_149674_1_.canLightningStrikeAt(i1, k1, j1 + 1))
	                                        {
	                                            int k2 = l + p_149674_5_.nextInt(5) / 4;

	                                            if (k2 > 15)
	                                            {
	                                                k2 = 15;
	                                            }

	                                            p_149674_1_.setBlock(i1, k1, j1, this, k2, 3);
	                                        }
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }

	 private int getChanceOfNeighborsEncouragingFire(World p_149845_1_, int p_149845_2_, int p_149845_3_, int p_149845_4_)
	    {
	        byte b0 = 0;

	        if (!p_149845_1_.isAirBlock(p_149845_2_, p_149845_3_, p_149845_4_))
	        {
	            return 0;
	        }
	        else
	        {
	            int l = b0;
	            l = this.getChanceToEncourageFire(p_149845_1_, p_149845_2_ + 1, p_149845_3_, p_149845_4_, l, WEST );
	            l = this.getChanceToEncourageFire(p_149845_1_, p_149845_2_ - 1, p_149845_3_, p_149845_4_, l, EAST );
	            l = this.getChanceToEncourageFire(p_149845_1_, p_149845_2_, p_149845_3_ - 1, p_149845_4_, l, UP   );
	            l = this.getChanceToEncourageFire(p_149845_1_, p_149845_2_, p_149845_3_ + 1, p_149845_4_, l, DOWN );
	            l = this.getChanceToEncourageFire(p_149845_1_, p_149845_2_, p_149845_3_, p_149845_4_ - 1, l, SOUTH);
	            l = this.getChanceToEncourageFire(p_149845_1_, p_149845_2_, p_149845_3_, p_149845_4_ + 1, l, NORTH);
	            return l;
	        }
	    }
	 public int getChanceToEncourageFire(IBlockAccess world, int x, int y, int z, int oldChance, ForgeDirection face)
	    {
	        int newChance = world.getBlock(x, y, z).getFireSpreadSpeed(world, x, y, z, face);
	        return (newChance > oldChance ? newChance : oldChance);
	    }
	private void tryCatchFire(World p_149841_1_, int p_149841_2_, int p_149841_3_, int p_149841_4_, int p_149841_5_, Random p_149841_6_, int p_149841_7_, ForgeDirection face)
   {
       int j1 = p_149841_1_.getBlock(p_149841_2_, p_149841_3_, p_149841_4_).getFlammability(p_149841_1_, p_149841_2_, p_149841_3_, p_149841_4_, face);

       if (p_149841_6_.nextInt(p_149841_5_) < j1)
       {
           boolean flag = p_149841_1_.getBlock(p_149841_2_, p_149841_3_, p_149841_4_) == Blocks.tnt;

           if (p_149841_6_.nextInt(p_149841_7_ + 10) < 5 && !p_149841_1_.canLightningStrikeAt(p_149841_2_, p_149841_3_, p_149841_4_))
           {
               int k1 = p_149841_7_ + p_149841_6_.nextInt(5) / 4;

               if (k1 > 15)
               {
                   k1 = 15;
               }

               p_149841_1_.setBlock(p_149841_2_, p_149841_3_, p_149841_4_, this, k1, 3);
           }
           else
           {
               p_149841_1_.setBlockToAir(p_149841_2_, p_149841_3_, p_149841_4_);
           }

           if (flag)
           {
               Blocks.tnt.onBlockDestroyedByPlayer(p_149841_1_, p_149841_2_, p_149841_3_, p_149841_4_, 1);
           }
       }
   }
   private boolean canNeighborBurn(World p_149847_1_, int p_149847_2_, int p_149847_3_, int p_149847_4_)
   {
       return this.canCatchFire(p_149847_1_, p_149847_2_ + 1, p_149847_3_, p_149847_4_, WEST ) ||
              this.canCatchFire(p_149847_1_, p_149847_2_ - 1, p_149847_3_, p_149847_4_, EAST ) ||
              this.canCatchFire(p_149847_1_, p_149847_2_, p_149847_3_ - 1, p_149847_4_, UP   ) ||
              this.canCatchFire(p_149847_1_, p_149847_2_, p_149847_3_ + 1, p_149847_4_, DOWN ) ||
              this.canCatchFire(p_149847_1_, p_149847_2_, p_149847_3_, p_149847_4_ - 1, SOUTH) ||
              this.canCatchFire(p_149847_1_, p_149847_2_, p_149847_3_, p_149847_4_ + 1, NORTH);
   }
   public boolean canCatchFire(IBlockAccess world, int x, int y, int z, ForgeDirection face)
   {
       return world.getBlock(x, y, z).isFlammable(world, x, y, z, face);
   }
   
   public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
   {
       if (p_149734_5_.nextInt(24) == 0)
       {
           p_149734_1_.playSound((double)((float)p_149734_2_ + 0.5F), (double)((float)p_149734_3_ + 0.5F), (double)((float)p_149734_4_ + 0.5F), "fire.fire", 1.0F + p_149734_5_.nextFloat(), p_149734_5_.nextFloat() * 0.7F + 0.3F, false);
       }

       int l;
       float f;
       float f1;
       float f2;

       if (!World.doesBlockHaveSolidTopSurface(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && !Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_, UP))
       {
           if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_ - 1, p_149734_3_, p_149734_4_, EAST))
           {
               for (l = 0; l < 2; ++l)
               {
                   f = (float)p_149734_2_ + p_149734_5_.nextFloat() * 0.1F;
                   f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
                   f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
                   p_149734_1_.spawnParticle("happyVillager", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
               }
           }

           if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_ + 1, p_149734_3_, p_149734_4_, WEST))
           {
               for (l = 0; l < 2; ++l)
               {
                   f = (float)(p_149734_2_ + 1) - p_149734_5_.nextFloat() * 0.1F;
                   f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
                   f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
                   p_149734_1_.spawnParticle("happyVillager", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
               }
           }

           if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_ - 1, SOUTH))
           {
               for (l = 0; l < 2; ++l)
               {
                   f = (float)p_149734_2_ + p_149734_5_.nextFloat();
                   f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
                   f2 = (float)p_149734_4_ + p_149734_5_.nextFloat() * 0.1F;
                   p_149734_1_.spawnParticle("happyVillager", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
               }
           }

           if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_ + 1, NORTH))
           {
               for (l = 0; l < 2; ++l)
               {
                   f = (float)p_149734_2_ + p_149734_5_.nextFloat();
                   f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
                   f2 = (float)(p_149734_4_ + 1) - p_149734_5_.nextFloat() * 0.1F;
                   p_149734_1_.spawnParticle("happyVillager", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
               }
           }

           if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_, p_149734_3_ + 1, p_149734_4_, DOWN))
           {
               for (l = 0; l < 2; ++l)
               {
                   f = (float)p_149734_2_ + p_149734_5_.nextFloat();
                   f1 = (float)(p_149734_3_ + 1) - p_149734_5_.nextFloat() * 0.1F;
                   f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
                   p_149734_1_.spawnParticle("happyVillager", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
               }
           }
       }
       else
       {
           for (l = 0; l < 3; ++l)
           {
               f = (float)p_149734_2_ + p_149734_5_.nextFloat();
               f1 = (float)p_149734_3_ + p_149734_5_.nextFloat() * 0.5F + 0.5F;
               f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
               p_149734_1_.spawnParticle("happyVillager", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
           }
       }
   }
   
}