package net.sacredlabyrinth.phaed.simpleclans.commands.completions;

import co.aikar.commands.BukkitCommandCompletionContext;
import co.aikar.commands.InvalidCommandArgument;
import net.sacredlabyrinth.phaed.simpleclans.Clan;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class WarringClansCompletion extends AbstractSyncCompletion {
    public WarringClansCompletion(@NotNull SimpleClans plugin) {
        super(plugin);
    }

    @Override
    public Collection<String> getCompletions(BukkitCommandCompletionContext c) throws InvalidCommandArgument {
        if (c.getIssuer().isPlayer()) {
            Player player = c.getPlayer();
            Clan clan = clanManager.getClanByPlayerUniqueId(player.getUniqueId());
            if (clan != null) {
                return clan.getWarringClans().stream().map(Clan::getTag).collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public @NotNull String getId() {
        return "warring_clans";
    }
}
