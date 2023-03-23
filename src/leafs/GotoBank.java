package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;

public class GotoBank extends LeafTask {
    public GotoBank(APIContext ctx) {
        super(ctx);
    }
    @Override
    public void execute() {
        ctx.webWalking().walkToBank();
    }
}
