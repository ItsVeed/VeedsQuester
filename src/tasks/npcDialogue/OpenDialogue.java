package tasks.npcDialogue;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;

public class OpenDialogue extends LeafTask {
    private final NPC n;

    public OpenDialogue(APIContext ctx, NPC n) {
        super(ctx);
        this.n = n;
    }
    @Override
    public void execute() {
        n.interact("Talk-to");
        Time.sleep(10_000, () -> ctx.dialogues().isDialogueOpen(), 1_000);
    }
}
