package me.choketa.mixin.foods;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Foods.class)
public class FoodsInitMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void primalmod$modifyFoods(CallbackInfo ci) {
        FoodAccessor.setBeef(new FoodProperties.Builder().nutrition(10).saturationModifier(0.8F).build());
        FoodAccessor.setCookedBeef(new FoodProperties.Builder().nutrition(6).saturationModifier(0.7F).build());
    }
}
