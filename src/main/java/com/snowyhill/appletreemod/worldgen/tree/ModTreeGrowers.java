package com.snowyhill.appletreemod.worldgen.tree;

import com.snowyhill.appletreemod.worldgen.features.ModFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower APPLE_TREE = new TreeGrower(
            "apple_tree", Optional.empty(),
            Optional.of(ModFeatures.APPLE_TREE_KEY),
            Optional.empty());

}
