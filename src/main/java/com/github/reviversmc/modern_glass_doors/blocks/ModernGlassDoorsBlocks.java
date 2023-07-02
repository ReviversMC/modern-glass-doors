package com.github.reviversmc.modern_glass_doors.blocks;

import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.TallBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import com.github.reviversmc.modern_glass_doors.ModernGlassDoors;

public class ModernGlassDoorsBlocks {
	public static final List<GlassDoorBlock> GLASS_DOORS = new ArrayList<>();
	public static final List<GlassTrapdoorBlock> GLASS_TRAPDOORS = new ArrayList<>();

	// Glass doors
	public static Block OAK_GLASS_DOOR;
	public static Block SPRUCE_GLASS_DOOR;
	public static Block BIRCH_GLASS_DOOR;
	public static Block ACACIA_GLASS_DOOR;
	public static Block JUNGLE_GLASS_DOOR;
	public static Block DARK_OAK_GLASS_DOOR;
	public static Block CRIMSON_GLASS_DOOR;
	public static Block WARPED_GLASS_DOOR;
	public static Block IRON_GLASS_DOOR;
	public static Block MANGROVE_GLASS_DOOR;
	public static Block BAMBOO_GLASS_DOOR;

	// Glass trapdoors
	public static Block OAK_GLASS_TRAPDOOR;
	public static Block SPRUCE_GLASS_TRAPDOOR;
	public static Block BIRCH_GLASS_TRAPDOOR;
	public static Block ACACIA_GLASS_TRAPDOOR;
	public static Block JUNGLE_GLASS_TRAPDOOR;
	public static Block DARK_OAK_GLASS_TRAPDOOR;
	public static Block CRIMSON_GLASS_TRAPDOOR;
	public static Block WARPED_GLASS_TRAPDOOR;
	public static Block IRON_GLASS_TRAPDOOR;
	public static Block MANGROVE_GLASS_TRAPDOOR;
	public static Block BAMBOO_GLASS_TRAPDOOR;

	public static void register() {
		// Glass doors
		OAK_GLASS_DOOR = registerDoor("oak", Material.WOOD, Blocks.OAK_DOOR);
		SPRUCE_GLASS_DOOR = registerDoor("spruce", Material.WOOD, Blocks.SPRUCE_DOOR);
		BIRCH_GLASS_DOOR = registerDoor("birch", Material.WOOD, Blocks.BIRCH_DOOR);
		ACACIA_GLASS_DOOR = registerDoor("acacia", Material.WOOD, Blocks.ACACIA_DOOR);
		JUNGLE_GLASS_DOOR = registerDoor("jungle", Material.WOOD, Blocks.JUNGLE_DOOR);
		DARK_OAK_GLASS_DOOR = registerDoor("dark_oak", Material.WOOD, Blocks.DARK_OAK_DOOR);
		CRIMSON_GLASS_DOOR = registerDoor("crimson", Material.NETHER_WOOD, Blocks.CRIMSON_DOOR);
		WARPED_GLASS_DOOR = registerDoor("warped", Material.NETHER_WOOD, Blocks.WARPED_DOOR);
		IRON_GLASS_DOOR = registerDoor("iron", Material.METAL, Blocks.IRON_DOOR);
		MANGROVE_GLASS_DOOR = registerDoor("mangrove", Material.WOOD, Blocks.MANGROVE_DOOR);
		BAMBOO_GLASS_DOOR = registerDoor("bamboo", Material.WOOD, Blocks.BAMBOO_DOOR);

		// Glass trapdoors
		OAK_GLASS_TRAPDOOR = registerTrapdoor("oak", Material.WOOD, Blocks.OAK_TRAPDOOR);
		SPRUCE_GLASS_TRAPDOOR = registerTrapdoor("spruce", Material.WOOD, Blocks.SPRUCE_TRAPDOOR);
		BIRCH_GLASS_TRAPDOOR = registerTrapdoor("birch", Material.WOOD, Blocks.BIRCH_TRAPDOOR);
		ACACIA_GLASS_TRAPDOOR = registerTrapdoor("acacia", Material.WOOD, Blocks.ACACIA_TRAPDOOR);
		JUNGLE_GLASS_TRAPDOOR = registerTrapdoor("jungle", Material.WOOD, Blocks.JUNGLE_TRAPDOOR);
		DARK_OAK_GLASS_TRAPDOOR = registerTrapdoor("dark_oak", Material.WOOD, Blocks.DARK_OAK_TRAPDOOR);
		CRIMSON_GLASS_TRAPDOOR = registerTrapdoor("crimson", Material.NETHER_WOOD, Blocks.CRIMSON_TRAPDOOR);
		WARPED_GLASS_TRAPDOOR = registerTrapdoor("warped", Material.NETHER_WOOD, Blocks.WARPED_TRAPDOOR);
		IRON_GLASS_TRAPDOOR = registerTrapdoor("iron", Material.METAL, Blocks.IRON_TRAPDOOR);
		MANGROVE_GLASS_TRAPDOOR = registerTrapdoor("mangrove", Material.WOOD, Blocks.MANGROVE_TRAPDOOR);
		BAMBOO_GLASS_TRAPDOOR = registerTrapdoor("bamboo", Material.WOOD, Blocks.BAMBOO_TRAPDOOR);
	}

	private static Block registerDoor(String material, Material materialCategory, Block parentDoorType) {
		assert parentDoorType instanceof DoorBlock;

		GlassDoorBlock door = new GlassDoorBlock(materialCategory, (DoorBlock) parentDoorType);
		Identifier id = new Identifier(ModernGlassDoors.MOD_ID, material + "_glass_door");

		GLASS_DOORS.add(door);
		Registry.register(Registries.BLOCK, id, door);
		Registry.register(Registries.ITEM, id, new TallBlockItem(door, new Item.Settings()));
		ItemGroupEvents.modifyEntriesEvent(ModernGlassDoors.ITEM_GROUP)
				.register(entries -> entries.add(door));

		return door;
	}

	private static Block registerTrapdoor(String material, Material materialCategory, Block parentTrapdoorType) {
		assert parentTrapdoorType instanceof TrapdoorBlock;

		GlassTrapdoorBlock trapdoor = new GlassTrapdoorBlock(materialCategory, (TrapdoorBlock) parentTrapdoorType);
		Identifier id = new Identifier(ModernGlassDoors.MOD_ID, material + "_glass_trapdoor");

		GLASS_TRAPDOORS.add(trapdoor);
		Registry.register(Registries.BLOCK, id, trapdoor);
		Registry.register(Registries.ITEM, id, new BlockItem(trapdoor, new Item.Settings()));
		ItemGroupEvents.modifyEntriesEvent(ModernGlassDoors.ITEM_GROUP)
				.register(entries -> entries.add(trapdoor));

		return trapdoor;
	}
}
