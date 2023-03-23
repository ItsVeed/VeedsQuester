package branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.GotoBank;
import leafs.OpenBank;

public class PrepareBank extends BranchTask {
    public PrepareBank(APIContext ctx) {
        super(ctx);
    }

    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return new GotoBank(ctx);
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return new OpenBank(ctx);
    }

    @Override
    public boolean validate() {
        return ctx.bank().isReachable() && ctx.bank().isVisible() ;
    }
}
