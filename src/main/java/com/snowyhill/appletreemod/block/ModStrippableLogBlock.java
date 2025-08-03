package com.snowyhill.appletreemod.block;

    //原木と木材用のクラス

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModStrippableLogBlock extends ModLogBlock{
    private final Supplier<Block> strippedLog;

    public ModStrippableLogBlock(BlockBehaviour.Properties pProperties, Supplier<Block> strippedLog) {
        super(pProperties);
        this.strippedLog = strippedLog;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
   //斧で右クリックすると樹皮を剥いだ原木に変更
      if (toolAction == ToolActions.AXE_STRIP){
          return strippedLog.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
      }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
