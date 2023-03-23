package leafs;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.LeafTask;
import com.epicbot.api.shared.util.time.Time;

public class WithdrawFromBank extends LeafTask {
    private String item;
    private int quantity;
    public WithdrawFromBank(APIContext ctx, String item, int quantity) {
        super(ctx);
    }

    @Override
    public void execute() {
        ctx.bank().withdraw(quantity, item);

        Time.sleep(500, 1000);

        ctx.bank().close();
    }
}
