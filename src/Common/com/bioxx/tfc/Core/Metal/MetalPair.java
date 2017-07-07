package com.bioxx.tfc.Core.Metal;

import com.bioxx.tfc.api.Metal;

@SuppressWarnings("CanBeFinal")
public class MetalPair {
	public Metal type;
	public float amount;

	public MetalPair(Metal t, float amnt) {
		type = t;
		amount = amnt;
	}
}
