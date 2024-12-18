package me.sootysplash.mixin;

import me.sootysplash.MainKB;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.sootysplash.MainKB.mc;

@Mixin(PlayerEntity.class)
public class ParticleMixin {
	@Inject(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V", shift = At.Shift.AFTER, ordinal = 0))
	private void kbHit(Entity target, CallbackInfo info) {
		addKnockbackParticles(target);
	}
	@Unique
	void addKnockbackParticles(Entity target) {
		mc.particleManager.addEmitter(target, MainKB.SPRINT_HIT_PARTICLE);
	}
}