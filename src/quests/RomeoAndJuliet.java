package quests;

import com.epicbot.api.shared.APIContext;
import com.epicbot.api.shared.methods.IQuestAPI;
import com.epicbot.api.shared.model.Area;
import requirements.ItemRequirement;
import requirements.Requirement;
import tasks.Task;
import tasks.npcDialogue.NpcDialogue;

public class RomeoAndJuliet extends Quest {
    Requirement CadavaBerries, CadavaPotion;
    Area varrockSquare, balcony, church, potionShop;

    Task talkToRomeo, talkToJuliet, giveLetterToRomeo, talkToLawrence, talkToApothecary, talkToApothecary2, givePotionToJuliet, finishQuest;
    public RomeoAndJuliet(APIContext ctx) {
        super(ctx);
        this.quest = IQuestAPI.Quest.ROMEO_AND_JULIET;
    }

    private void setupTasks() {
        talkToRomeo = new NpcDialogue(ctx, 0, 5037)
                .addDialogueStep("Perhaps I could help to find her for you?")
                .addDialogueStep("Yes.")
                .addDialogueStep("Ok, thanks")
                .setArea(varrockSquare)
                .startRequirements(CadavaBerries);

        talkToJuliet = new NpcDialogue(ctx, 10, 5035)
                .setArea(balcony);

        giveLetterToRomeo = new NpcDialogue(ctx, 20, 5037)
                .setArea(varrockSquare);

        talkToLawrence = new NpcDialogue(ctx, 30, 5038)
                .setArea(church);

        talkToApothecary = new NpcDialogue(ctx, 40, 5036)
                .addDialogueStep("Talk about something else.")
                .addDialogueStep("Talk about Romeo & Juliet.")
                .setArea(potionShop)
                .startRequirements(CadavaBerries);

        talkToApothecary2 = new NpcDialogue(ctx, 50, 5036)
                .addDialogueStep("Talk about something else.")
                .addDialogueStep("Talk about Romeo & Juliet.")
                .setArea(potionShop)
                .skipRequirements(CadavaPotion);

        givePotionToJuliet = new NpcDialogue(ctx, 50, 5035)
                .setArea(balcony);

        finishQuest = new NpcDialogue(ctx, 50, 5035)
                .setArea(varrockSquare);

    }

    private void setupRequirements() {
        CadavaBerries = new ItemRequirement(ctx, "Cadava berries", 1);
        CadavaPotion = new ItemRequirement(ctx, "Cadava potion", 1);
    }

    private void setupAreas() {
        varrockSquare = new Area(3206, 3435, 3220, 3422);
        balcony = new Area(1, 3156, 3426, 3160, 3425);
        church = new Area(3253, 3483, 3256, 3480);
        potionShop = new Area(3193, 3405, 3197, 3403);
    }
}
