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

    public static final SoundEvent NYAN_CAT = registerSoundEvent("nyan_cat");
    public static final RegistryKey<JukeboxSong> NYAN_CAT_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Cyberextras.MOD_ID, "nyan_cat"));

    public static final SoundEvent POOL_BROOM = registerSoundEvent("pool_broom");
    public static final RegistryKey<JukeboxSong> POOL_BROOM_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Cyberextras.MOD_ID, "pool_broom"));

    public static final SoundEvent FIRST_CLASS = registerSoundEvent("first_class");
    public static final RegistryKey<JukeboxSong> FIRST_CLASS_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Cyberextras.MOD_ID, "first_class"));

    public static final SoundEvent BOUNCY_MUSHROOMS = registerSoundEvent("bouncy_mushrooms");
    public static final RegistryKey<JukeboxSong> BOUNCY_MUSHROOMS_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Cyberextras.MOD_ID, "bouncy_mushrooms"));

    public static final SoundEvent SERIOUS_SILLY = registerSoundEvent("serious_silly");
    public static final RegistryKey<JukeboxSong> SERIOUS_SILLY_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Cyberextras.MOD_ID, "serious_silly"));

    public static final SoundEvent DARK_FLAME = registerSoundEvent("dark_flame");
    public static final RegistryKey<JukeboxSong> DARK_FLAME_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Cyberextras.MOD_ID, "dark_flame"));

    public static final SoundEvent BITER_HURT = registerSoundEvent("biter_hurt");
    public static final SoundEvent BITER_AMBIENT = registerSoundEvent("biter_ambient");
    public static final SoundEvent BITER_DEATH = registerSoundEvent("biter_death");


    private static SoundEvent registerSoundEvent (String name){
        Identifier id = Identifier.of(Cyberextras.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
