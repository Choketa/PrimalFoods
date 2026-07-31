package me.choketa.food;

import net.minecraft.core.HolderSet;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.RemoveStatusEffectsConsumeEffect;


public class PrimalFoods {
    public static final FoodProperties VEGETABLE_JUICE = new FoodProperties.Builder().
            nutrition(0).alwaysEdible().saturationModifier(0.1f).build();
    public static final Consumable VEGETABLE_JUICE_CONSUMABLE = Consumables.defaultDrink()
            .consumeSeconds(1.5f)
            .onConsume(new RemoveStatusEffectsConsumeEffect(HolderSet.direct(
                    MobEffects.POISON, MobEffects.HUNGER,
                    MobEffects.WITHER, MobEffects.SLOWNESS,
                    MobEffects.WEAKNESS))).build();
}
