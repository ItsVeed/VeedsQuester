package tasks;

import branches.HandleCutscene;
import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.model.Area;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.Error;
import requirements.Requirement;

public class Task extends BranchTask {
    public int stage;
    private TreeTask requirementTask = new Error(ctx, "Requirement task not available");
    protected TreeTask entryTask = new Error(ctx, "Task is not yet implemented");
    private Requirement[] startRequirements = null;
    public Requirement[] skipRequirements = null;

    protected Area area = null;

    public Task(APIContext ctx, int stage) {
        super(ctx);
        this.stage = stage;
    }

    public Task startRequirements(Requirement... requirements) {
        this.startRequirements = requirements;
        return this;
    }

    public Task skipRequirements(Requirement... requirements) {
        this.skipRequirements = requirements;
        return this;
    }

    public boolean checkSkipRequirements() {
        if (skipRequirements == null) {
            return false;
        } else {
            for (Requirement requirement: skipRequirements) {
                if (requirement.check()) {
                    return true;
                }
            }
            return false;
        }
    }

    public void create(TreeTask entryTask) {
        this.entryTask = new HandleCutscene(ctx, entryTask);
    }

    public Task confirm() {
        return this;
    }

    public Task setArea(Area area) {
        this.area = area;
        return this;
    }
    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return requirementTask;
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return entryTask; //this will be the entry point to the task
    }

    @Override
    public boolean validate() {
        if (startRequirements == null) {
            return true;
        } else {
            for (Requirement requirement : startRequirements) {
                if (!requirement.check()) {
                    requirementTask = requirement.requirementTask;
                    return false;
                }
            }
            return true;
        }
    }
}
