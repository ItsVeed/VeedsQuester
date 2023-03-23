package branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.methods.IQuestAPI;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.Cutscene;

public class HandleCutscene extends BranchTask {
    private final TreeTask entryTask;

    public HandleCutscene(APIContext ctx, TreeTask entryTask) {
        super(ctx);
        this.entryTask = entryTask;
    }
    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return entryTask;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return new Cutscene(ctx);
    }

    @Override
    public boolean validate() {
        return ctx.vars().getVarbit(IQuestAPI.QuestVarbits.CUTSCENE.getId()) == 1;
    }
}
