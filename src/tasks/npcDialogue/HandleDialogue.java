package tasks.npcDialogue;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.entity.WidgetChild;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;

import java.util.List;

public class HandleDialogue extends LeafTask {
    private final List<String> chatOptions;

    public HandleDialogue(APIContext ctx, List<String> chatOptions) {
        super(ctx);
        this.chatOptions = chatOptions;
    }
    @Override
    public void execute() {
        if (ctx.dialogues().canContinue()) {
            ctx.dialogues().selectContinue();
            Time.sleep(10_000, () -> ctx.dialogues().isDialogueOpen(), 4_000);
        }
        if (ctx.dialogues().getOptions() != null) {
            handleOptions(chatOptions);
            Time.sleep(1_000);
        }
    }

    private void handleOptions(List<String> chatOptions){
        String bestOption = getBestDialogOption(chatOptions);
        if(bestOption != null) {
            ctx.dialogues().selectOption(bestOption);
            Time.sleep(5_000, () -> !ctx.dialogues().isLoading() || !ctx.dialogues().isDialogueOpen());
        }
    }

    protected String getBestDialogOption(List<String> dialogOptions){
        for(String chat : dialogOptions){
            for(WidgetChild option : ctx.dialogues().getOptions()){
                if(option.getText().equals(chat)){
                    return chat;
                }
            }
        }
        return null;
    }
}
