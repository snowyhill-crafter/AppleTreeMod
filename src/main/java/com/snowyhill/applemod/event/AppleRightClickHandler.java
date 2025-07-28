package com.snowyhill.applemod.event;


import com.snowyhill.applemod.AppleMod;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AppleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AppleRightClickHandler {

    // AppleFlowerLeavesBlockのAGEプロパティにアクセスするために、static finalとして定義するか、
    // AppleFlowerLeavesBlockから直接取得できるようにする必要があります。
    // 今回はAppleFlowerLeavesBlockクラスで定義されているAGEプロパティを使用します。
    // AppleFlowerLeavesBlockクラスのMAX_AGEも参照します。

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        // 適切なブロック（あなたのAppleFlowerLeavesBlock）であるかを確認
        // 例: if (block == ModBlocks.APPLE_FLOWER_LEAVES.get()) { ... }
        // ここでは、AGEプロパティを持っているブロックとして汎用的にチェックします。
        // ただし、ModBlocks.APPLE_FLOWER_LEAVES.get()で特定することを強く推奨します。
        // ここでは仮にAppleFlowerLeavesBlockのAGE_2プロパティが適用されていると仮定します。
        if (state.hasProperty(IntegerProperty.create("age", 0, 2)) && block.getClass().getSimpleName().equals("AppleFlowerLeavesBlock")) {
            // 実際のAppleFlowerLeavesBlockインスタンスからAGEプロパティとMAX_AGEを取得
            IntegerProperty ageProperty = (IntegerProperty) state.getBlock().getStateDefinition().getProperty("age");
            int currentAge = state.getValue(ageProperty);

            // AppleFlowerLeavesBlockで定義したMAX_AGEが2であると仮定
            int maxAge = 2; // AppleFlowerLeavesBlock.MAX_AGE を直接参照できない場合

            if (currentAge == maxAge) { // 完熟状態の場合
                if (!level.isClientSide) {
                    // リンゴをドロップ
                    Block.popResource(level, pos, new ItemStack(Items.APPLE, 1)); // 1個のリンゴをドロップ

                    // 収穫音を再生
                    level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

                    // ブロックのAGEを0（花の状態）にリセット
                    BlockState newState = state.setValue(ageProperty, 0);
                    level.setBlock(pos, newState, 2); // フラグ2: クライアントに同期

                    // ゲームイベントを発火
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(event.getEntity(), newState));
                }
                event.setCancellationResult(InteractionResult.SUCCESS); // 右クリックイベントを消費
                event.setCanceled(true); // イベントをキャンセルして、他の処理が実行されないようにする
            }
        }
    }
}