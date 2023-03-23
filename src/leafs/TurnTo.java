package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.details.Locatable;
import com.epicbot.api.shared.script.tree.LeafTask;

public class TurnTo extends LeafTask {
    Locatable x;
    public TurnTo(APIContext ctx, Locatable x) {
        super(ctx);
        this.x = x;
    }
    @Override
    public void execute() {
        ctx.camera().turnTo(x);
    }
}
