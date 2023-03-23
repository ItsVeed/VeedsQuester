package tasks.npcDialogue;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;

import java.util.List;

public class IsDialogueOpen extends BranchTask {
    private final NPC n;
    private final List<String> chatOptions;

    public IsDialogueOpen(APIContext ctx, NPC n, List<String> chatOptions) {
        super(ctx);
        this.n = n;
        this.chatOptions = chatOptions;
    }
    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return new CanSeeNpc(ctx, n);
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return new HandleDialogue(ctx, chatOptions);
    }

    @Override
    public boolean validate() {
        return ctx.dialogues().isDialogueOpen();
    }
}
