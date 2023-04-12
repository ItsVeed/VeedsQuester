package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;
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

        Time.sleep(2_000, 3_000);
    }
}
