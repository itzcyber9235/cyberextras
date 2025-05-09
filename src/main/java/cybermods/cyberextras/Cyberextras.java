package cybermods.cyberextras;

import cybermods.cyberextras.block.ModBlocks;
import cybermods.cyberextras.item.ModItems;
import cybermods.cyberextras.util.EyePickaxeUsageEvent;
import cybermods.cyberextras.util.EyeShovelUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cyberextras implements ModInitializer {
	public static final String MOD_ID = "cyberextras";
	;

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		//This is taking the registrModItems function from the ModItems class and applying its code into this function which is called once when the mod is loaded into the game.
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();


		PlayerBlockBreakEvents.BEFORE.register(new EyePickaxeUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new EyeShovelUsageEvent());
		//Same as the registerModitems function above but for registerItemgroups from the moditemgroups class.

	}
}