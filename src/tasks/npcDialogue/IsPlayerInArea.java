package tasks.npcDialogue;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;
import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.WalkToTile;

import java.util.List;

public class IsPlayerInArea extends BranchTask {
    private final List<String> chatOptions;
    private final NPC n;
    private Area area;
    private TreeTask nextTask;
    public IsPlayerInArea(APIContext ctx, Area area, NPC n, List<String> chatOptions) {
        super(ctx);
        this.area = area;
        this.n = n;
        this.chatOptions = chatOptions;
    }
    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return new WalkToTile(ctx, area.getCentralTile());
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return new IsDialogueOpen(ctx, n, chatOptions);
    }

    @Override
    public boolean validate() {
        return area.contains(ctx.localPlayer().getLocation());
    }
}
