package eu.dudko.harvesting_enchantment.mixin;

import eu.dudko.harvesting_enchantment.registry.HEBlockTags;
import eu.dudko.harvesting_enchantment.registry.HEEnchantmentEffectComponentTypes;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements DataComponentHolder {

    @Inject(method = "useOn", at = @At("TAIL"), cancellable = true)
    private void harvestingEnchantment$harvestCrops(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        if (cir.getReturnValue() != InteractionResult.PASS) return;
        if (!harvestingEnchantment$hasHarvestingEffect()) return;

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        BlockState state = level.getBlockState(pos);
        if (state.is(HEBlockTags.NON_HARVESTABLE)) return;

        Block block = state.getBlock();
        if (!(block instanceof CropBlock crop)) return;
        if (!crop.isMaxAge(state)) return;

        Block.dropResources(state, level, pos, null, context.getPlayer(), context.getItemInHand());
        level.setBlock(pos, crop.getStateForAge(0), Block.UPDATE_CLIENTS);
        cir.setReturnValue(InteractionResult.SUCCESS);
    }

    @Unique
    private boolean harvestingEnchantment$hasHarvestingEffect() {
        ItemEnchantments enchantments = getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);

        boolean hasEffect = false;

        for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantments.entrySet()) {
            Enchantment enchantment = entry.getKey().value();
            if (enchantment.effects().has(HEEnchantmentEffectComponentTypes.HARVEST_CROPS.get())) {
                hasEffect = true;
                break;
            }
        }

        return hasEffect;
    }

}
