package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;

public class Error extends LeafTask {
    private String errorMessage;

    public Error(APIContext ctx, String errorMessage) {
        super(ctx);
        this.errorMessage = errorMessage;
    }

    @Override
    public void execute() {
        ctx.script().stop(errorMessage);
    }
}
