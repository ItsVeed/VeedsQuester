package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;

public class Login extends LeafTask {
    public Login(APIContext ctx) {
        super(ctx);
    }

    @Override
    public void execute() {
        Time.sleep(2_000, () -> ctx.client().isLoggedIn());
    }
}
