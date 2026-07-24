package eu.dudko.harvesting_enchantment.content;

import eu.dudko.harvesting_enchantment.registry.HEBlockTags;
import eu.dudko.harvesting_enchantment.registry.HEEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

public class Harvesting {

    public static void harvestCrops(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemStack = context.getItemInHand();
        if (!hasHarvestingEffect(itemStack)) return;

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        BlockState state = level.getBlockState(pos);
        if (state.is(HEBlockTags.NON_HARVESTABLE)) return;

        Block block = state.getBlock();
        if (!(block instanceof CropBlock crop)) return;
        if (!crop.isMaxAge(state)) return;

        if (level instanceof ServerLevel serverLevel) {
            Item cropItem = crop.asItem();
            List<ItemStack> drops = Block.getDrops(state, serverLevel, pos, null, context.getPlayer(), itemStack);
            drops.stream().filter(stack -> stack.is(cropItem)).findFirst().ifPresent(stack -> stack.shrink(1));
            drops.forEach(stack -> Block.popResource(level, pos, stack));
            state.spawnAfterBreak(serverLevel, pos, itemStack, true);
            serverLevel.playSound(null, pos, state.getSoundType().getBreakSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
        }
        level.setBlock(pos, crop.getStateForAge(0), Block.UPDATE_CLIENTS);
        cir.setReturnValue(InteractionResult.SUCCESS);
    }

    public static boolean hasHarvestingEffect(DataComponentHolder componentHolder) {
        ItemEnchantments
                enchantments =
                componentHolder.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);

        if (enchantments.isEmpty()) return false;

        return enchantments.keySet().stream().anyMatch(holder -> holder.is(HEEnchantments.HARVESTING));
    }

}
