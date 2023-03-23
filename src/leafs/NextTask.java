package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import quests.Quest;

public class NextTask extends LeafTask {
    private final Quest quest;

    public NextTask(APIContext ctx, Quest quest) {
        super(ctx);
        this.quest = quest;
    }
    @Override
    public void execute() {
        quest.nextTask();
    }
}
