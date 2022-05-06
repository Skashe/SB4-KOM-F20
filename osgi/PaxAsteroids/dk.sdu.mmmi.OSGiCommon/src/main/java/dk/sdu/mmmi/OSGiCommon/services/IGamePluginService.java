package dk.sdu.mmmi.OSGiCommon.services;

import dk.sdu.mmmi.OSGiCommon.data.GameData;
import dk.sdu.mmmi.OSGiCommon.data.World;

public interface IGamePluginService {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
