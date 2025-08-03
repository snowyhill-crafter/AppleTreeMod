package com.snowyhill.appletreemod;

//import com.mojang.logging.LogUtils;

import com.snowyhill.appletreemod.registry.ModBlocks;
import com.snowyhill.appletreemod.registry.ModItems;
import com.snowyhill.appletreemod.registry.ModTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import org.slf4j.Logger;


@Mod(AppleTreeMod.MOD_ID)
public class AppleTreeMod
{

    public static final String MOD_ID = "appletreemod";
//    private static final Logger LOGGER = LogUtils.getLogger();


    public AppleTreeMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();


        modEventBus.addListener(this::commonSetup);

        //アイテムレジストリとイベントバスに登録　IntroductionItemsから情報を得ている。
        ModItems.ITEMS.register(modEventBus);
        //クリエイティブタブをイベントバスに登録
        ModTabs.register(modEventBus);





        // DataComponentTypeの登録
        //ModDataComponents.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);







        // ブロックレジストリをイベントバスに登録
        ModBlocks.BLOCKS.register(modEventBus);

    }





    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

      @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
