package me.choketa.mixin.foods;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Mixin(Foods.class)
public class FoodsInitMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void primalmod$modifyFoods(CallbackInfo ci) {
        FoodAccessor.setBeef(new FoodProperties.Builder().nutrition(10).saturationModifier(0.8F).build());
        FoodAccessor.setCookedBeef(new FoodProperties.Builder().nutrition(6).saturationModifier(0.7F).build());

        swap(FoodAccessor::getChicken, FoodAccessor::setChicken, FoodAccessor::getCookedChicken, FoodAccessor::setCookedChicken);
        swap(FoodAccessor::getPorkchop, FoodAccessor::setPorkchop, FoodAccessor::getCookedPorkchop, FoodAccessor::setCookedPorkchop);
        swap(FoodAccessor::getMutton, FoodAccessor::setMutton, FoodAccessor::getCookedMutton, FoodAccessor::setCookedMutton);
        swap(FoodAccessor::getRabbit, FoodAccessor::setRabbit, FoodAccessor::getCookedRabbit, FoodAccessor::setCookedRabbit);
        swap(FoodAccessor::getCod, FoodAccessor::setCod, FoodAccessor::getCookedCod, FoodAccessor::setCookedCod);
        swap(FoodAccessor::getSalmon, FoodAccessor::setSalmon, FoodAccessor::getCookedSalmon, FoodAccessor::setCookedSalmon);
    }

    @Unique
    private static void swap(Supplier<FoodProperties> getRaw, Consumer<FoodProperties> setRaw,
                             Supplier<FoodProperties> getCooked, Consumer<FoodProperties> setCooked) {
        FoodProperties raw = getRaw.get();
        FoodProperties cooked = getCooked.get();
        setRaw.accept(cooked);
        setCooked.accept(raw);
    }
}

