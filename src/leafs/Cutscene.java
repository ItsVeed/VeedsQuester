package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;

public class Cutscene extends LeafTask {
    public Cutscene(APIContext ctx) {
        super(ctx);
    }

    @Override
    public void execute() {
        if (ctx.dialogues().isDialogueOpen()) {
            if (ctx.dialogues().canContinue()) {
                ctx.dialogues().selectContinue();
            }
        }
    }
}
