package ovh.not.javamusicbot.command;

import ovh.not.javamusicbot.AbstractCommand;
import ovh.not.javamusicbot.CommandContext;
import ovh.not.javamusicbot.GuildManager;
import ovh.not.javamusicbot.MusicManager;

import java.util.Collections;
import java.util.List;

public class ShuffleCommand extends AbstractCommand {
    public ShuffleCommand() {
        super("shuffle");
    }

    @Override
    public void on(CommandContext context) {
        MusicManager musicManager = GuildManager.getInstance().getMusicManager(context.getEvent().getGuild());
        if (!musicManager.isPlayingMusic()) {
            context.reply("No music is playing on this guild! To play a song use `{{prefix}}play`");
            return;
        }
        Collections.shuffle((List<?>) musicManager.getTrackScheduler().getQueue());
        context.reply("Queue shuffled!");
    }
}
