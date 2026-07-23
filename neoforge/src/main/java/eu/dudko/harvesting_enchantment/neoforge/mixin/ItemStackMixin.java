package eu.dudko.harvesting_enchantment.neoforge.mixin;

import eu.dudko.harvesting_enchantment.content.Harvesting;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements DataComponentHolder {

    @Inject(method = "onItemUse", at = @At("TAIL"), cancellable = true)
    private void harvestingEnchantment$harvestCrops(UseOnContext context, Function<UseOnContext, InteractionResult> callback, CallbackInfoReturnable<InteractionResult> cir) {
        Harvesting.harvestCrops(context, cir);
    }

}
