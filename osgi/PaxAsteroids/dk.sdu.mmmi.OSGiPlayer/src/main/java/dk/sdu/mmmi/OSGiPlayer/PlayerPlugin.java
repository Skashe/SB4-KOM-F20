package dk.sdu.mmmi.OSGiPlayer;

import dk.sdu.mmmi.OSGiCommon.data.Entity;
import dk.sdu.mmmi.OSGiCommon.data.GameData;
import dk.sdu.mmmi.OSGiCommon.data.World;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.LifePart;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.MovingPart;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.PositionPart;
import dk.sdu.mmmi.OSGiCommon.services.IEntityProcessingService;
import dk.sdu.mmmi.OSGiCommon.services.IGamePluginService;



public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    public PlayerPlugin() {
    }


    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        player = createPlayerShip(gameData);
        world.addEntity(player);
    }

    private Entity createPlayerShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 2f;
        float y = gameData.getDisplayHeight() / 2f;
        float radians = 3.1415f / 2;
        
        Entity playerShip = new Player();
        playerShip.setRadius(8);
        playerShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        playerShip.add(new PositionPart(x, y, radians));
        playerShip.add(new LifePart(3, 0));
        return playerShip;
    }


    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(player);
    }

}
