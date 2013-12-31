// Date: 29/12/2013 11:39:01 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package TFC.Render.Models;

import org.lwjgl.opengl.GL11;

import TFC.API.Entities.IAnimal;
import TFC.API.Entities.IAnimal.GenderEnum;
import TFC.Core.TFC_Core;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPheasant extends ModelBase
{
	//fields
	ModelRenderer Body;
	ModelRenderer Tail;
	ModelRenderer LeftLeg;
	ModelRenderer RightLeg;
	ModelRenderer TailFeather;
	ModelRenderer LeftLowerLeg;
	ModelRenderer RightLowerLeg;
	ModelRenderer Neck;
	ModelRenderer Head;
	ModelRenderer Beak;
	ModelRenderer Chest;
	ModelRenderer LeftWing;
	ModelRenderer RightWing;
	ModelRenderer LeftFoot;
	ModelRenderer RightFoot;

	public ModelPheasant()
	{
		textureWidth = 42;
		textureHeight = 30;

		Body = new ModelRenderer(this, 0, 7);
		Body.addBox(-4F, 0F, -2.5F, 9, 6, 5);
		Body.setRotationPoint(0F, 12F, 0F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, -0.5235988F);
		Tail = new ModelRenderer(this, 0, 0);
		Tail.addBox(-7F, 2F, -2F, 6, 3, 4);
		Tail.setRotationPoint(0F, 12F, 0F);
		Tail.setTextureSize(64, 32);
		Tail.mirror = true;
		setRotation(Tail, 0F, 0F, -0.1745329F);
		LeftLeg = new ModelRenderer(this, 16, 24);
		LeftLeg.addBox(1F, 4F, 1F, 3, 4, 2);
		LeftLeg.setRotationPoint(0F, 12F, 0F);
		LeftLeg.setTextureSize(64, 32);
		LeftLeg.mirror = true;
		setRotation(LeftLeg, 0F, 0F, 0.3490659F);
		RightLeg = new ModelRenderer(this, 26, 24);
		RightLeg.addBox(1F, 4F, -3F, 3, 4, 2);
		RightLeg.setRotationPoint(0F, 12F, 0F);
		RightLeg.setTextureSize(64, 32);
		RightLeg.mirror = true;
		setRotation(RightLeg, 0F, 0F, 0.3490659F);
		TailFeather = new ModelRenderer(this, 20, 0);
		TailFeather.addBox(-14.96F, 3F, -1F, 9, 1, 2);
		TailFeather.setRotationPoint(0F, 12F, 0F);
		TailFeather.setTextureSize(64, 32);
		TailFeather.mirror = true;
		setRotation(TailFeather, 0F, 0F, -0.0872665F);
		LeftLowerLeg = new ModelRenderer(this, 34, 19);
		LeftLowerLeg.addBox(-1F, 8F, 1.5F, 1, 4, 1);
		LeftLowerLeg.setRotationPoint(0F, 0F, 0F);
		LeftLowerLeg.setTextureSize(64, 32);
		LeftLowerLeg.mirror = true;
		setRotation(LeftLowerLeg, 0F, 0F, 0F);
		RightLowerLeg = new ModelRenderer(this, 38, 19);
		RightLowerLeg.addBox(-1F, 8F, -2.5F, 1, 4, 1);
		RightLowerLeg.setRotationPoint(0F, 0F, 0F);
		RightLowerLeg.setTextureSize(64, 32);
		RightLowerLeg.mirror = true;
		setRotation(RightLowerLeg, 0F, 0F, 0F);
		Neck = new ModelRenderer(this, 28, 13);
		Neck.addBox(4F, 2F, -1.5F, 4, 3, 3,0.05F);
		Neck.setRotationPoint(-4F, 2F, 0F);
		Neck.setTextureSize(64, 32);
		Neck.mirror = true;
		setRotation(Neck, 0F, 0F, -0.8726646F);
		Head = new ModelRenderer(this, 16, 18);
		Head.addBox(2.5F, -3F, -1.5F, 3, 3, 3,0.1F);
		Head.setRotationPoint(4F, 10F, 0F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Beak = new ModelRenderer(this, 28, 19);
		Beak.addBox(5F, -2F, -0.5F, 2, 1, 1);
		Beak.setRotationPoint(4F, 10F, 0F);
		Beak.setTextureSize(64, 32);
		Beak.mirror = true;
		setRotation(Beak, 0F, 0F, 0F);
		Chest = new ModelRenderer(this, 28, 7);
		Chest.addBox(-1F, 4.5F, -1.5F, 4, 3, 3);
		Chest.setRotationPoint(-4F, 2F, 0F);
		Chest.setTextureSize(64, 32);
		Chest.mirror = true;
		setRotation(Chest, 0F, 0F, -1.396263F);
		LeftWing = new ModelRenderer(this, 0, 23);
		LeftWing.addBox(-3F, 1F, 2.5F, 7, 4, 1);
		LeftWing.setRotationPoint(0F, 12F, 0F);
		LeftWing.setTextureSize(64, 32);
		LeftWing.mirror = true;
		setRotation(LeftWing, 0F, 0F, -0.5235988F);
		RightWing = new ModelRenderer(this, 0, 18);
		RightWing.addBox(-3F, 1F, -3.5F, 7, 4, 1);
		RightWing.setRotationPoint(0F, 12F, 0F);
		RightWing.setTextureSize(64, 32);
		RightWing.mirror = true;
		setRotation(RightWing, 0F, 0F, -0.5235988F);
		LeftFoot = new ModelRenderer(this, 20, 3);
		LeftFoot.addBox(-2F, 11.9F, 0.5F, 4, 0, 3,0.001F);
		LeftFoot.setRotationPoint(0F, 0F, 0F);
		LeftFoot.setTextureSize(64, 32);
		LeftFoot.mirror = true;
		setRotation(LeftFoot, 0F, 0F, 0F);
		RightFoot = new ModelRenderer(this, 20, 3);
		RightFoot.addBox(-2F, 11.9F, -3.5F, 4, 0, 3,0.001F);
		RightFoot.setRotationPoint(0F, 0F, 0F);
		RightFoot.setTextureSize(64, 32);
		RightFoot.mirror = true;
		setRotation(RightFoot, 0F, 0F, 0F);
		
		Head.addChild(Neck);
		Head.addChild(Chest);
		
		RightLeg.addChild(RightLowerLeg);
		RightLowerLeg.addChild(RightFoot);
		LeftLeg.addChild(LeftLowerLeg);
		LeftLowerLeg.addChild(LeftFoot);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		float percent = Math.max(TFC_Core.getPercentGrown((IAnimal)entity),0);
		float ageScale = 2.0F-percent;
		float offset = 1.4f - percent;

		GL11.glPushMatrix ();

		GL11.glTranslatef (0.0F, (0.75f-(0.75f*percent)), 0f);
		GL11.glScalef(1/ageScale, 1/ageScale, 1/ageScale);

		this.Head.render(par7);
		this.Beak.render(par7);
		//this.Neck.render(par7);
		//this.Chest.render(par7);


		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef (0.0F, (0.75f-(0.75f*percent)), 0f);
		GL11.glScalef(1/ageScale, 1/ageScale, 1/ageScale);
		this.Body.render(par7);
		this.RightLeg.render(par7);
		this.LeftLeg.render(par7);
		//this.RightLowerLeg.render(par7);
		//this.LeftLowerLeg.render(par7);
		this.RightWing.render(par7);
		this.LeftWing.render(par7);
		//this.LeftFoot.render(par7);
		//this.RightFoot.render(par7);
		this.Tail.render(par7);
		this.TailFeather.render(par7);
		GL11.glPopMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
	{	
		//this.Head.rotateAngleZ = -(par5 / (180F / (float)Math.PI));
		this.Head.rotateAngleY = par4 / (180F / (float)Math.PI);
		//this.Beak.rotateAngleZ = this.Head.rotateAngleZ;
		this.Beak.rotateAngleY = this.Head.rotateAngleY;
		//this.Neck.rotateAngleY = this.Head.rotateAngleY;
		//this.Chest.rotateAngleY = this.Head.rotateAngleY;
		this.Neck.rotateAngleZ = -(5*(float)(Math.PI / 18F));
		this.Chest.rotateAngleZ = -(8*(float)(Math.PI / 18F));
		this.Body.rotateAngleZ = -((float)(Math.PI / 6F));
		this.RightWing.rotateAngleZ = -((float)(Math.PI / 6F));
		this.LeftWing.rotateAngleZ =  -((float)(Math.PI / 6F));
		
		System.out.println(((ModelBox)(RightWing.cubeList.get(0))).posX1);
		if(par3!=0){
			RightWing.setRotationPoint(4, 12, -2);
			LeftWing.setRotationPoint(4, 12, 2);
			RightWing.rotateAngleZ =-(float)(Math.PI/2F);
			LeftWing.rotateAngleZ =-(float)(Math.PI/2F);
			RightWing.offsetX = -3F/16F;
			RightWing.offsetY = -3F/16F;
			RightWing.offsetZ = -1.5F/16F;
			LeftWing.offsetX = -3F/16F;
			LeftWing.offsetY = -3F/16F;
			LeftWing.offsetZ = 1.5F/16F;
		}
		else{
			RightWing.setRotationPoint(0, 12, 0);
			LeftWing.setRotationPoint(0, 12, 0);
			RightWing.offsetX = 0;
			RightWing.offsetY = 0;
			RightWing.offsetZ = 0;
			LeftWing.offsetX = 0;
			LeftWing.offsetY = 0;
			LeftWing.offsetZ = 0;
		}
		this.RightWing.rotateAngleY = par3;
		this.LeftWing.rotateAngleY = -par3;
		
		
		this.Tail.rotateAngleZ = -((float)(Math.PI / 18F));
		this.TailFeather.rotateAngleZ = -((float)(Math.PI / 36F));
		this.RightLeg.rotateAngleZ = ((float)(Math.PI / 9F))+ MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.LeftLeg.rotateAngleZ = ((float)(Math.PI / 9F)) + MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		this.RightLowerLeg.rotateAngleZ = -((float)(Math.PI / 9F));
		this.LeftLowerLeg.rotateAngleZ = -((float)(Math.PI / 9F));
		this.RightFoot.rotateAngleZ = 0;
		this.LeftFoot.rotateAngleZ = 0;
	}

}
