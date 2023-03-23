package branches;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.script.tree.BranchTask;
import com.epicbot.api.shared.script.tree.TreeTask;
import leafs.WithdrawFromBank;

public class GetItem extends BranchTask {
    private String item;
    private int quantity;
    public GetItem(APIContext ctx, String item, int quantity) {
        super(ctx);
        this.item = item;
        this.quantity = quantity;
    }
    @Override
    protected TreeTask createFailureTask(APIContext apiContext) {
        return new PrepareBank(ctx);
    }

    @Override
    protected TreeTask createSuccessTask(APIContext apiContext) {
        return new WithdrawFromBank(ctx, item, quantity);
    }

    @Override
    public boolean validate() {
        return ctx.bank().isOpen();
    }
}
