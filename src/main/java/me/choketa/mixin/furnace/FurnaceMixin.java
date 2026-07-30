package me.choketa.mixin.furnace;


import me.choketa.PrimalSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Slot.class)
public class FurnaceMixin {
    @Shadow
    @Final
    public Container container;
    @Shadow
    @Final
    private int slot;

    @Inject(method = "set", at = @At("HEAD"))
    private void primalmod$overrideSetItem(ItemStack itemStack, CallbackInfo ci) {
        if (!(this.container instanceof AbstractFurnaceBlockEntity furnace)) return;
        if (this.slot != 0 && this.slot != 1) return;
        if (!itemStack.has(DataComponents.FOOD)) return;
        if (!(furnace.getLevel() instanceof ServerLevel serverLevel)) return;

        BlockPos pos = furnace.getBlockPos();

        serverLevel.playSound(
                null,
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                PrimalSounds.DIRTY_DOG,
                SoundSource.BLOCKS,
                1.0f,
                1.0f
        );
    }
}