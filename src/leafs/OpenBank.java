package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;

public class OpenBank extends LeafTask {
    public OpenBank(APIContext ctx) {
        super(ctx);
    }
    @Override
    public void execute() {
        ctx.bank().open();
    }
}
