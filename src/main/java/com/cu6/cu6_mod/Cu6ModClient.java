package com.cu6.cu6_mod;

import com.cu6.cu6_mod.client.model.PhocidaeModel;
import com.cu6.cu6_mod.common.entity.PhocidaeEntity;
import com.cu6.cu6_mod.init.registry.CMEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Mod(value = Cu6Mod.MOD_ID, dist = Dist.CLIENT)

@EventBusSubscriber(modid = Cu6Mod.MOD_ID, value = Dist.CLIENT)
public class Cu6ModClient {
    public Cu6ModClient(ModContainer container) {

        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PhocidaeModel.LAYER_LOCATION, PhocidaeModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void clientSetUp(FMLClientSetupEvent event) {
        CMEntities.onClientSetup();
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(CMEntities.PHOCIDAE.get(), PhocidaeEntity.createAttributes().build());
    }
}
