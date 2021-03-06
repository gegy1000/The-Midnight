package com.mushroom.midnight.client.render.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mushroom.midnight.Midnight;
import com.mushroom.midnight.client.model.NovaModel;
import com.mushroom.midnight.common.entity.creature.NovaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class NovaRenderer extends MobRenderer<NovaEntity, NovaModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Midnight.MODID, "textures/entities/nova.png");

    public NovaRenderer(EntityRendererManager manager) {
        super(manager, new NovaModel(), 0.6f);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(NovaEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void preRenderCallback(NovaEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.translate(0f, -0.25f + (MathHelper.sin((entitylivingbaseIn.ticksExisted + partialTickTime) * 0.14f - 0.5f) / 8), 0f);
        matrixStackIn.scale(0.8f, 0.8f, 0.8f);
    }
}
