package com.snowyhill.applemod.event;


import com.snowyhill.applemod.AppleMod;
import com.snowyhill.applemod.registry.ModBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = AppleMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {

    @SubscribeEvent
    public static void onBlockColors(RegisterColorHandlersEvent.Block event) {
        // リンゴの葉の色を固定（青みのある緑）

        // バイオームのfoliage.png（バニラ仕様）を参照する
        event.register(
                (state, world, pos, tintIndex) -> {
                    if (world != null && pos != null) {
                        // バニラの葉ブロックが使っている色（バイオーム色）
                        return BiomeColors.getAverageFoliageColor(world, pos);
                    }
                    // デフォルト（アイテムなどバイオームなしのとき）はこれ
                    return FoliageColor.getDefaultColor();
                },
                ModBlocks.APPLE_LEAVES.get(),
                ModBlocks.APPLE_FLOWER_LEAVES.get(),
                ModBlocks.ORNAMENTAL_APPLE_FLOWER_LEAVES.get(),
                ModBlocks.ORNAMENTAL_APPLE_UNRIPE_LEAVES.get(),
                ModBlocks.ORNAMENTAL_APPLE_FRUIT_LEAVES.get()
        );

    }

    @SubscribeEvent
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {
        // アイテムでもリンゴの葉の色を固定（青みのある緑）
        // バニラ葉と同じく、getDefaultColor() を使う（テクスチャが青みがかっていれば、同じ見た目になる）
        event.register(
                (stack, tintIndex) -> FoliageColor.getDefaultColor(),
                ModBlocks.APPLE_LEAVES.get(),
                ModBlocks.APPLE_FLOWER_LEAVES.get(),
                ModBlocks.ORNAMENTAL_APPLE_FLOWER_LEAVES.get(),
                ModBlocks.ORNAMENTAL_APPLE_UNRIPE_LEAVES.get(),
                ModBlocks.ORNAMENTAL_APPLE_FRUIT_LEAVES.get()
        );








    }
}
