package tasks.npcDialogue;

import com.epicbot.api.shared.APIContext;
import requirements.Requirement;
import tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class NpcDialogue extends Task {

    private List<String> chatOptions = new ArrayList<String>();
    private int npcid;

    public NpcDialogue(APIContext ctx, int stage, int npcid) {
        super(ctx, stage);
        this.npcid = npcid;
    }

    @Override
    public Task confirm() {
        create(new FindNpc(ctx, npcid, chatOptions, area));
        return this;
    }
    public NpcDialogue addDialogueStep(String dialogueOption) {
        chatOptions.add(dialogueOption);
        return this;
    }
}
