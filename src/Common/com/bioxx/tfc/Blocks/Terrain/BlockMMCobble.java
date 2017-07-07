package com.bioxx.tfc.Blocks.Terrain;

import com.bioxx.tfc.api.Constant.Global;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

@SuppressWarnings("SameParameterValue")
public class BlockMMCobble extends BlockCobble {
	public BlockMMCobble(Material material) {
		super(material);
		names = Global.STONE_MM;
		icons = new IIcon[names.length];
		looseStart = Global.STONE_MM_START;
	}
}
