package io.github.Tors_0.voidfalling.registry;

import io.github.Tors_0.voidfalling.entity.VoidActuatorEntity;
import io.github.Tors_0.voidfalling.Voidfalling;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

public interface ModEntities {
	Map<EntityType<? extends Entity>, Identifier> ENTITIES = new LinkedHashMap<>();

	EntityType<VoidActuatorEntity> VOID_ACTUATOR = createEntity("void_actuator",
		QuiltEntityTypeBuilder.<VoidActuatorEntity>create(SpawnGroup.MISC, VoidActuatorEntity::new).setDimensions(EntityDimensions.fixed(.5f,.5f)).maxChunkTrackingRange(128).build());

	private static <T extends EntityType<? extends Entity>> T createEntity(String name, T entity) {
		ENTITIES.put(entity, new Identifier(Voidfalling.ID, name));
		return entity;
	}

	static void initialize() {
		ENTITIES.keySet().forEach(entityType -> Registry.register(Registry.ENTITY_TYPE, ENTITIES.get(entityType), entityType));
	}
}
