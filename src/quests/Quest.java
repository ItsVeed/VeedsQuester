package quests;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.methods.IQuestAPI;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.NextTask;
import tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class Quest extends BranchTask {
    private List<Task> tasks = new ArrayList<Task>();
    protected IQuestAPI.Quest quest;

    public Quest(APIContext ctx) {
        super(ctx);
    }


    protected void addTask(Task task) {
        tasks.add(task);
    }

    public void nextTask() {
        tasks.remove(0);
    }

    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return tasks.get(0);
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return new NextTask(ctx, this);
    }

    @Override
    public boolean validate() {
        System.out.println("Checking stage");
        System.out.println(getStage(quest));
        System.out.println(tasks.get(0).stage);
        return tasks.get(0).stage < getStage(quest) || tasks.get(0).checkSkipRequirements();
    }

    private int getStage(IQuestAPI.Quest quest){
        if(quest.getVarPlayer() != null){
            return ctx.vars().getVarp(quest.getVarPlayer().getId());
        } else if(quest.getVarbit() != null){
            return ctx.vars().getVarbit(quest.getVarbit().getId());
        }
        return -1;
    }
}
