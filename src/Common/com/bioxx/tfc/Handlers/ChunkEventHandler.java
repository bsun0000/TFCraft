package com.bioxx.tfc.Handlers;

import java.util.List;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;

import com.bioxx.tfc.Chunkdata.ChunkData;
import com.bioxx.tfc.Core.TFC_Climate;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.Core.TFC_Time;
import com.bioxx.tfc.Food.CropIndex;
import com.bioxx.tfc.Food.CropManager;
import com.bioxx.tfc.WorldGen.Generators.WorldGenGrowCrops;
import com.bioxx.tfc.api.Constant.Global;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChunkEventHandler
{
	@SubscribeEvent
	public void onLoad(ChunkEvent.Load event)
	{
		if (!event.world.isRemote)
		{
			ChunkData cd = TFC_Core.getCDM(event.world).getData(event.getChunk().xPosition, event.getChunk().zPosition);
			if(cd== null)
				return;
			int month = TFC_Time.getSeasonAdjustedMonth(event.getChunk().zPosition << 4);
			if (TFC_Time.getYear() > cd.lastSpringGen && month > 1 && month < 6)
			{
				int chunk_X = event.getChunk().xPosition;
				int chunk_Z = event.getChunk().zPosition;
				cd.fishPop *= Math.pow(1.2,cd.lastSpringGen - TFC_Time.getYear());
				cd.fishPop = Math.min(cd.fishPop, ChunkData.fishPopMax);
				cd.lastSpringGen = TFC_Time.getYear();

				Random rand = new Random(event.world.getSeed() + ((chunk_X >> 3) - (chunk_Z >> 3)) * (chunk_Z >> 3));
				int cropid = rand.nextInt(24);
				CropIndex crop = CropManager.getInstance().getCropFromId(cropid);
				if (event.world.rand.nextInt(25) == 0 && crop != null)
				{
					int num = 1 + event.world.rand.nextInt(5);
					WorldGenGrowCrops cropGen = new WorldGenGrowCrops(cropid);
					int x = (chunk_X << 4) + event.world.rand.nextInt(16) + 8;
					int z = (chunk_Z << 4) + event.world.rand.nextInt(16) + 8;
					cropGen.generate(event.world, event.world.rand, x, z, num);
				}
			}
			else if(TFC_Time.getYear() > cd.lastSpringGen && month >= 6){
				cd.fishPop *= Math.pow(1.2,cd.lastSpringGen - TFC_Time.getYear());
				cd.fishPop = Math.min(cd.fishPop, ChunkData.fishPopMax);
				cd.lastSpringGen = TFC_Time.getYear();
			}
			else if(TFC_Time.getYear() > cd.lastSpringGen + 1){
				cd.fishPop *= Math.pow(1.2,cd.lastSpringGen - TFC_Time.getYear() - 1);
				cd.fishPop = Math.min(cd.fishPop, ChunkData.fishPopMax);
				cd.lastSpringGen = TFC_Time.getYear();
			}
		}
		else
		{
			ChunkData data = new ChunkData().CreateNew(event.world, event.getChunk().xPosition, event.getChunk().zPosition);
			data.rainfallMap = TFC_Climate.getCacheManager(event.world).loadRainfallLayerGeneratorData(data.rainfallMap, event.getChunk().xPosition * 16, event.getChunk().zPosition * 16, 16, 16);
			//data.rockMap1 =  TFC_Climate.getCacheManager(event.world).loadRockLayerGeneratorData(data.rockMap1, event.getChunk().xPosition * 16, event.getChunk().zPosition * 16, 16, 16, 0);
			//data.rockMap2 =  TFC_Climate.getCacheManager(event.world).loadRockLayerGeneratorData(data.rockMap2, event.getChunk().xPosition * 16, event.getChunk().zPosition * 16, 16, 16, 1);
			//data.rockMap3 =  TFC_Climate.getCacheManager(event.world).loadRockLayerGeneratorData(data.rockMap3, event.getChunk().xPosition * 16, event.getChunk().zPosition * 16, 16, 16, 2);
			TFC_Core.getCDM(event.world).addData(event.getChunk(), data);
		}
	}

	@SubscribeEvent
	public void onUnload(ChunkEvent.Unload event)
	{
		TFC_Core.getCDM(event.world).getData(event.getChunk().xPosition, event.getChunk().zPosition).isUnloaded = true;
	}

	@SubscribeEvent
	public void onUnloadWorld(WorldEvent.Unload event)
	{
		TFC_Climate.removeCacheManager(event.world);
		TFC_Core.removeCDM(event.world);
	}

	@SubscribeEvent
	public void onLoadWorld(WorldEvent.Load event)
	{
		if(event.world.provider.dimensionId == 0 && event.world.getTotalWorldTime() < 100)
			createSpawn(event.world);
	}

	@SubscribeEvent
	public void onDataLoad(ChunkDataEvent.Load event)
	{
		if(!event.world.isRemote)
		{
			NBTTagCompound eventTag = event.getData();

			if(eventTag.hasKey("ChunkData"))
			{
				NBTTagCompound spawnProtectionTag = eventTag.getCompoundTag("ChunkData");
				ChunkData data = new ChunkData(spawnProtectionTag);
				TFC_Core.getCDM(event.world).addData(event.getChunk(), data);
			}
			else
			{
				/*if(TFC_Core.getCDM(event.world).hasData(event.getChunk()))
					return;*/
				NBTTagCompound levelTag = eventTag.getCompoundTag("Level");
				ChunkData data = new ChunkData().CreateNew(event.world, levelTag.getInteger("xPos"), levelTag.getInteger("zPos"));
				TFC_Core.getCDM(event.world).addData(event.getChunk(), data);
			}
		}
	}

	@SubscribeEvent
	public void onDataSave(ChunkDataEvent.Save event)
	{
		if(!event.world.isRemote)
		{
			NBTTagCompound levelTag = event.getData().getCompoundTag("Level");
			int x = levelTag.getInteger("xPos");
			int z = levelTag.getInteger("zPos");
			ChunkData data = TFC_Core.getCDM(event.world).getData(x, z);

			if(data != null)
			{
				NBTTagCompound spawnProtectionTag = data.getTag();
				// Why was this line here in the first place?
				//spawnProtectionTag = new NBTTagCompound();
				event.getData().setTag("ChunkData", spawnProtectionTag);
				if(data.isUnloaded)
					TFC_Core.getCDM(event.world).removeData(x, z);
			}
		}
	}

	private ChunkCoordinates createSpawn(World world)
	{
		List biomeList = world.getWorldChunkManager().getBiomesToSpawnIn();
		long seed = world.getWorldInfo().getSeed();
		Random rand = new Random(seed);

		ChunkPosition chunkCoord = null;
		int xOffset = 0;
		int xCoord = 0;
		int yCoord = Global.SEALEVEL+1;
		int zCoord = 10000;
		int startingZ = 5000 + rand.nextInt(10000);

		while(chunkCoord == null)
		{
			chunkCoord = world.getWorldChunkManager().findBiomePosition(xOffset, -startingZ, 64, biomeList, rand);
			if (chunkCoord != null)
			{
				xCoord = chunkCoord.chunkPosX;
				zCoord = chunkCoord.chunkPosZ;
			}
			else
			{
				xOffset += 64;
				//System.out.println("Unable to find spawn biome");
			}
		}

		int var9 = 0;
		while (!world.provider.canCoordinateBeSpawn(xCoord, zCoord))
		{
			xCoord += rand.nextInt(16) - rand.nextInt(16);
			zCoord += rand.nextInt(16) - rand.nextInt(16);
			++var9;
			if (var9 == 1000)
				break;
		}

		WorldInfo info = world.getWorldInfo();
		info.setSpawnPosition(xCoord, world.getTopSolidOrLiquidBlock(xCoord, zCoord), zCoord);
		return new ChunkCoordinates(xCoord, world.getTopSolidOrLiquidBlock(xCoord, zCoord), zCoord);
	}
}
