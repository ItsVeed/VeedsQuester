package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.model.Tile;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;

public class WalkToTile extends LeafTask {
    private Tile tile;
    public WalkToTile(APIContext ctx, Tile tile) {
        super(ctx);
        this.tile = tile;
    }

    @Override
    public void execute() {
        if (tile.distanceTo(ctx) > 10) {
            ctx.webWalking().walkTo(tile);
        } else {
            ctx.walking().walkTo(tile);
        }
        Time.sleep(10_000, () -> !ctx.localPlayer().isMoving() && !ctx.localPlayer().isAnimating());
    }
}
