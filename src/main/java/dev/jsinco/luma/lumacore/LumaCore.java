package dev.jsinco.luma.lumacore;

import dev.jsinco.luma.lumacore.manager.modules.ModuleManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class LumaCore extends JavaPlugin {

    @Getter
    private static LumaCore instance;
    private static ModuleManager coreModuleManager;

    @Override
    public void onLoad() {
        instance = this;
        coreModuleManager = new ModuleManager(this);
    }

    @Override
    public void onEnable() {
        coreModuleManager.reflectivelyRegisterModules();
    }

    @Override
    public void onDisable() {
        coreModuleManager.unregisterModules();
    }
}