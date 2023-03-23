package tasks.npcDialogue;

import branches.IsPlayerInArea;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.NPC;
import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;

import java.util.List;

public class FindNpc extends BranchTask {
    private Area area;
    private List<String> chatOptions;
    private NPC n;
    private int npcid;
    public FindNpc(APIContext ctx, int npcid, List<String> chatOptions, Area area) {
        super(ctx);
        this.npcid = npcid;
        this.chatOptions = chatOptions;
        this.area = area;
    }
    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return new IsPlayerInArea(ctx, area);
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return new IsDialogueOpen(ctx, n, chatOptions);
    }

    @Override
    public boolean validate() {
        n = ctx.npcs().query().id(npcid).results().nearest();
        return n != null;
    }
}
