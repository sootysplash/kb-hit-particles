package me.sootysplash;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.DamageParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainKB implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("KbHitParticles");
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static final DefaultParticleType SPRINT_HIT_PARTICLE = FabricParticleTypes.simple();


	@Override
	public void onInitialize() {
		LOGGER.info("KbHitParticles | Sootysplash was here!");
		Registry.register(Registries.PARTICLE_TYPE, new Identifier("kb-hit-particles", "sprint_hit_particle"), SPRINT_HIT_PARTICLE);
		ParticleFactoryRegistry.getInstance().register(SPRINT_HIT_PARTICLE, DamageParticle.Factory::new);

	}
}