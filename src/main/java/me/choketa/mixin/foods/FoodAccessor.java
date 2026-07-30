package me.choketa.mixin.foods;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Foods.class)
public interface FoodAccessor {

    @Accessor("BEEF")
    @Mutable
    static void setBeef(FoodProperties food) { throw new AssertionError(); }

    @Accessor("COOKED_BEEF")
    @Mutable
    static void setCookedBeef(FoodProperties food) { throw new AssertionError(); }

    @Accessor("CHICKEN")
    static FoodProperties getChicken() { throw new AssertionError(); }
    @Accessor("CHICKEN")
    @Mutable
    static void setChicken(FoodProperties food) { throw new AssertionError(); }

    @Accessor("COOKED_CHICKEN")
    static FoodProperties getCookedChicken() { throw new AssertionError(); }
    @Accessor("COOKED_CHICKEN")
    @Mutable
    static void setCookedChicken(FoodProperties food) { throw new AssertionError(); }

    @Accessor("PORKCHOP")
    static FoodProperties getPorkchop() { throw new AssertionError(); }
    @Accessor("PORKCHOP")
    @Mutable
    static void setPorkchop(FoodProperties food) { throw new AssertionError(); }

    @Accessor("COOKED_PORKCHOP")
    static FoodProperties getCookedPorkchop() { throw new AssertionError(); }
    @Accessor("COOKED_PORKCHOP")
    @Mutable
    static void setCookedPorkchop(FoodProperties food) { throw new AssertionError(); }

    @Accessor("MUTTON")
    static FoodProperties getMutton() { throw new AssertionError(); }
    @Accessor("MUTTON")
    @Mutable
    static void setMutton(FoodProperties food) { throw new AssertionError(); }

    @Accessor("COOKED_MUTTON")
    static FoodProperties getCookedMutton() { throw new AssertionError(); }
    @Accessor("COOKED_MUTTON")
    @Mutable
    static void setCookedMutton(FoodProperties food) { throw new AssertionError(); }

    @Accessor("RABBIT")
    static FoodProperties getRabbit() { throw new AssertionError(); }
    @Accessor("RABBIT")
    @Mutable
    static void setRabbit(FoodProperties food) { throw new AssertionError(); }

    @Accessor("COOKED_RABBIT")
    static FoodProperties getCookedRabbit() { throw new AssertionError(); }
    @Accessor("COOKED_RABBIT")
    @Mutable
    static void setCookedRabbit(FoodProperties food) { throw new AssertionError(); }

    @Accessor("COD")
    static FoodProperties getCod() { throw new AssertionError(); }
    @Accessor("COD")
    @Mutable
    static void setCod(FoodProperties food) { throw new AssertionError(); }

    @Accessor("COOKED_COD")
    static FoodProperties getCookedCod() { throw new AssertionError(); }
    @Accessor("COOKED_COD")
    @Mutable
    static void setCookedCod(FoodProperties food) { throw new AssertionError(); }

    @Accessor("SALMON")
    static FoodProperties getSalmon() { throw new AssertionError(); }
    @Accessor("SALMON")
    @Mutable
    static void setSalmon(FoodProperties food) { throw new AssertionError(); }

    @Accessor("COOKED_SALMON")
    static FoodProperties getCookedSalmon() { throw new AssertionError(); }
    @Accessor("COOKED_SALMON")
    @Mutable
    static void setCookedSalmon(FoodProperties food) { throw new AssertionError(); }
}