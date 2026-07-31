package me.choketa.mixin.foods;

import me.choketa.PrimalUtils;
import me.choketa.item.PrimalItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(Consumable.class)
public class FoodBehaviorMixin {
    @Unique
    private Set<Item> badItems;

    @Unique
    private void initList() {
        badItems = Set.of(
                Items.POISONOUS_POTATO,
                Items.POTATO,
                Items.BAKED_POTATO,
                Items.COOKIE,
                Items.DRIED_KELP,
                Items.CARROT,
                Items.GOLDEN_CARROT,
                Items.BEETROOT,
                Items.BEETROOT_SOUP,
                Items.PUMPKIN_PIE,
                Items.SUSPICIOUS_STEW,
                Items.MUSHROOM_STEW,
                Items.BREAD);
    }
    @Inject(method = "onConsume", at = @At("HEAD"))
    private void primalmod$overrideEating(Level level, LivingEntity user, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        if (badItems == null) initList();
        if (!(user instanceof Player player)) return;
        Item item = stack.getItem();
        if (item.equals(Items.MILK_BUCKET)) {
            FoodData data = player.getFoodData();
            data.setFoodLevel(data.getFoodLevel()+1);
            data.setSaturation(data.getSaturationLevel()+0.1f); //Raw milk + yes = holy height
            return;
        }
        else if (item.equals(PrimalItems.VEGETABLE_JUICE)) {
            if (player.hasEffect(MobEffects.WEAKNESS) ||
                player.hasEffect(MobEffects.SLOWNESS) ||
                player.hasEffect(MobEffects.POISON) ||
                player.hasEffect(MobEffects.WITHER)) return;
            FoodData data = player.getFoodData();
            data.setFoodLevel(data.getFoodLevel()-1); //Antinootrients maxxing
        }
        if (!badItems.contains(item))
            return;
        if (item.equals(Items.GOLDEN_CARROT))
            player.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 1));
        PrimalUtils.punishPlayer(player);
    }
}
