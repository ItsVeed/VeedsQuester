package branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.WalkToTile;

public class IsPlayerInArea extends BranchTask {
    private Area area;
    private TreeTask nextTask;
    public IsPlayerInArea(APIContext ctx, Area area) {
        super(ctx);
        this.area = area;
        this.nextTask = nextTask;
    }
    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return new WalkToTile(ctx, area.getRandomTile());
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return nextTask;
    }

    @Override
    public boolean validate() {
        return area.contains(ctx.localPlayer().getLocation());
    }
}
