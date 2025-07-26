package com.snowyhill.applemod.block;

import com.snowyhill.applemod.worldgen.features.ModFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;


public class AppleSaplingBlock extends SaplingBlock {

    public AppleSaplingBlock(Properties properties) {
        super(TreeGrower.OAK, properties);

    }

    @Override
    public void advanceTree(ServerLevel world, BlockPos pos, BlockState state, RandomSource random) {
        // 10% の確率で本当に木に成長する


        world.removeBlock(pos, false); // 先に苗木を消す




        Holder<ConfiguredFeature<?, ?>> featureHolder =
                world.registryAccess()
                        .registryOrThrow(Registries.CONFIGURED_FEATURE)
                        .getHolderOrThrow(ModFeatures.APPLE_TREE_KEY);

        // 苗木の位置を起点として木を生成
        boolean success = featureHolder.value().place(world, world.getChunkSource().getGenerator(), random, pos);

        if (!success) {
            // 木の生成に失敗したら苗木を戻す
            world.setBlock(pos, this.defaultBlockState(), 3);
        }


    }



    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true; // 骨粉の成功判定も常にOKにする（調整可能）
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (random.nextFloat() < 0.25F) {
            this.advanceTree(level, pos, state, random);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.scheduleTick(pos, this, 1);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getRawBrightness(pos.above(), 0) >= 9 && random.nextInt(7) == 0) {
            this.advanceTree(level, pos, state, random);
        }
    }


}