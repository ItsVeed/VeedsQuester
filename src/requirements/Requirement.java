package requirements;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.Error;
import quests.Quest;

public class Requirement {
    APIContext ctx;
    public TreeTask requirementTask = new Error(ctx, "Requirement task not implemented.");
    public Requirement(APIContext ctx) {
        this.ctx = ctx;
    }

    public boolean check() {
        return false;
    }
}
