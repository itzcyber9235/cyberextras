package cybermods.cyberextras.sound;

import cybermods.cyberextras.Cyberextras;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent AUDIO_LOG_025 = registerSoundEvent("audio_log_025");
    public static final RegistryKey<JukeboxSong> AUDIO_LOG_025_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Cyberextras.MOD_ID, "audio_log_025"));


    private static SoundEvent registerSoundEvent (String name){
        Identifier id = Identifier.of(Cyberextras.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
