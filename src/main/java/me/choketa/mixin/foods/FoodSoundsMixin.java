package me.choketa.mixin.foods;

import me.choketa.PrimalSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
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
public class FoodSoundsMixin {
    @Unique
    private Set<Item> badItems;

    @Unique
    private void initList() {
        badItems = Set.of(
                Items.POISONOUS_POTATO,
                Items.POTATO,
                Items.BAKED_POTATO,
                Items.CAKE,
                Items.COOKIE,
                Items.DRIED_KELP,
                Items.CARROT,
                Items.GOLDEN_CARROT,
                Items.BEETROOT,
                Items.BEETROOT_SOUP,
                Items.PUMPKIN_PIE,
                Items.SUSPICIOUS_STEW,
                Items.MUSHROOM_STEM);
    }
    @Inject(method = "onConsume", at = @At("HEAD"))
    private void primalfoods$overrideEatingSound(Level level, LivingEntity user, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        if (badItems == null) initList();
        if (!badItems.contains(stack.getItem()))
            return;
        user.playSound(PrimalSounds.GOATIS_CORTISOL, 2.0f, 1.0f);
        user.animateHurt(0f);
        user.playSound(SoundEvents.PLAYER_HURT, 1.0f, 1.0f);
        user.setHealth(user.getHealth()-2.0f);
    }
}
