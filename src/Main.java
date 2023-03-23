import com.epicbot.api.shared.GameType;
import com.epicbot.api.shared.script.ScriptManifest;
import com.epicbot.api.shared.script.TreeScript;
import quests.RomeoAndJuliet;

@ScriptManifest(gameType = GameType.OS, name = "VeedsQuester - TreeScript")
public class Main extends TreeScript {
    private long startTime;

    @Override
    public boolean onStart(String... strings) {
        startTime = System.currentTimeMillis();

        setRootTask(new RomeoAndJuliet(getAPIContext()));

        setIterationDelay(1000);

        return true;
    }
}
