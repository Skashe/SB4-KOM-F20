package dk.sdu.mmmi.OSGiCommon.services;

import dk.sdu.mmmi.OSGiCommon.data.GameData;
import dk.sdu.mmmi.OSGiCommon.data.World;

public interface IEntityProcessingService {

    void process(GameData gameData, World world);
}
