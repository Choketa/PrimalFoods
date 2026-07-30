package me.choketa.mixin.consumables;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Consumables.class)
public class ConsumablesInitMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void primalmod$modifyFoods(CallbackInfo ci) {
        ConsumableAccessor.setRottenFlesh(Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 600, 0), 0.8F))
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1), 0.1F)).build());
        ConsumableAccessor.setChicken(Consumables.defaultFood().build());
    }
}
