package requirements;

import branches.GetItem;
import com.epicbot.api.shared.APIContext;

public class ItemRequirement extends Requirement{
    private String item;
    private int quantity;

    public ItemRequirement(APIContext ctx, String item, int quantity) {
        super(ctx);
        this.requirementTask = new GetItem(ctx, item, quantity);
    }

    @Override
    public boolean check() {
        return ctx.inventory().getCount(item) >= quantity;
    }
}
