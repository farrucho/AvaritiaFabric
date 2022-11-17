package net.farrucho.avaritia.mixin;

import net.farrucho.avaritia.item.AvaritiaModItems;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(PlayerEntity.class)
public class ExampleMixin {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity)(Object)this;
        //player.sendMessage(Text.of("levou damage"));
        //player.sendMessage(Text.of(new Boolean(hasFullSuitOfArmorOn(player)).toString()));

        if (hasFullSuitOfArmorOn((PlayerEntity)(Object)this)) {
            cir.setReturnValue(false);
        }else{
        }

    }

    private static boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return (boots.getItem().equals(AvaritiaModItems.INFINITY_BOOTS) &&
                leggings.getItem().equals(AvaritiaModItems.INFINITY_LEGGINGS) &&
                chestplate.getItem().equals(AvaritiaModItems.INFINITY_CHESTPLATE) &&
                helmet.getItem().equals(AvaritiaModItems.INFINITY_HELMET));
    }



}




/*@Mixin(Entity.class)
public class ExampleMixin {
    //@Inject(at = @At("HEAD"), method = "init()V")
    //private void init(CallbackInfo info) {Avaritia.LOGGER.info("This line is printed by an example mod mixin!");}

	/*@Inject(method = "damage", at = @At("RETURN"),cancellable = true)
	private void injectDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(false);
	}*/

/*
    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return (boots.getItem().equals(AvaritiaModItems.INFINITY_BOOTS) &&
                leggings.getItem().equals(AvaritiaModItems.INFINITY_LEGGINGS) &&
                chestplate.getItem().equals(AvaritiaModItems.INFINITY_CHESTPLATE) &&
                helmet.getItem().equals(AvaritiaModItems.INFINITY_HELMET));
    }

    public void kill() {
        this.remove(Entity.RemovalReason.KILLED);
        this.emitGameEvent(GameEvent.ENTITY_DIE);
    }*/





/*
	private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
		ItemStack boots = player.getInventory().getArmorStack(0);
		ItemStack leggings = player.getInventory().getArmorStack(1);
		ItemStack chestplate = player.getInventory().getArmorStack(2);
		ItemStack helmet = player.getInventory().getArmorStack(3);

		return (boots.getItem().equals(AvaritiaModItems.INFINITY_BOOTS) &&
				leggings.getItem().equals(AvaritiaModItems.INFINITY_LEGGINGS) &&
				chestplate.getItem().equals(AvaritiaModItems.INFINITY_CHESTPLATE) &&
				helmet.getItem().equals(AvaritiaModItems.INFINITY_HELMET));
	}

	*/


	/*PlayerEntity player = (PlayerEntity)(Object)this;


	private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
		ItemStack boots = player.getInventory().getArmorStack(0);
		ItemStack leggings = player.getInventory().getArmorStack(1);
		ItemStack chestplate = player.getInventory().getArmorStack(2);
		ItemStack helmet = player.getInventory().getArmorStack(3);

		return (boots.getItem().equals(AvaritiaModItems.INFINITY_BOOTS) &&
				leggings.getItem().equals(AvaritiaModItems.INFINITY_LEGGINGS) &&
				chestplate.getItem().equals(AvaritiaModItems.INFINITY_CHESTPLATE) &&
				helmet.getItem().equals(AvaritiaModItems.INFINITY_HELMET));
	}

	private boolean hasAnyInfinityArmorOn(PlayerEntity player) {
		ItemStack boots = player.getInventory().getArmorStack(0);
		ItemStack leggings = player.getInventory().getArmorStack(1);
		ItemStack chestplate = player.getInventory().getArmorStack(2);
		ItemStack helmet = player.getInventory().getArmorStack(3);

		return (boots.getItem().equals(AvaritiaModItems.INFINITY_BOOTS) ||
				leggings.getItem().equals(AvaritiaModItems.INFINITY_LEGGINGS) ||
				chestplate.getItem().equals(AvaritiaModItems.INFINITY_CHESTPLATE) ||
				helmet.getItem().equals(AvaritiaModItems.INFINITY_HELMET));
	}
	*/
//}
