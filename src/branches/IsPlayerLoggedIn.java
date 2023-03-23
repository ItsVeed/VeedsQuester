package branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.Login;

public class IsPlayerLoggedIn extends BranchTask {

    private TreeTask nextTask;
    public IsPlayerLoggedIn(APIContext ctx, TreeTask nextTask) {
        super(ctx);
        this.nextTask = nextTask;
    }

    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return new Login(ctx);
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return nextTask;
    }

    @Override
    public boolean validate() {
        return ctx.client().isLoggedIn();
    }
}
