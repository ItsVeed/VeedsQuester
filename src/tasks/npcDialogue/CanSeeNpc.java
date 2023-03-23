package tasks.npcDialogue;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.TurnTo;

public class CanSeeNpc extends BranchTask {
    private NPC n;
    public CanSeeNpc(APIContext ctx, NPC n) {
        super(ctx);
        this.n = n;
    }
    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return new TurnTo(ctx, n);
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return new OpenDialogue(ctx, n);
    }

    @Override
    public boolean validate() {
        return n.isVisible();
    }
}
