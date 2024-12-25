package dev.jsinco.luma.manager.commands;

import dev.jsinco.luma.manager.modules.LumaModule;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public interface AbstractSubCommand<P extends JavaPlugin> extends LumaModule {


    boolean execute(P plugin, CommandSender sender, String label, String[] args);

    List<String> tabComplete(P plugin, CommandSender sender, String label, String[] args);

    default Class<? extends AbstractCommandManager> parent() {
        return info().parent();
    }

    default String name() {
        return info().name();
    }

    default String permission() {
        return info().permission();
    }

    default boolean playerOnly() {
        return info().playerOnly();
    }

    default String usage(String label) {
        return info().usage().replace("<command>", label);
    }

    default SubCommandInfo info() {
        SubCommandInfo info = getClass().getAnnotation(SubCommandInfo.class);
        if (info == null) {
            throw new IllegalStateException("CommandInfo annotation not found on " + getClass().getName());
        }
        return info;
    }
}