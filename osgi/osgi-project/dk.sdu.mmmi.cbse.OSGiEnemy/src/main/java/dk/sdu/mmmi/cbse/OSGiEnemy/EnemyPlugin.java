package dk.sdu.mmmi.cbse.OSGiEnemy;

import dk.sdu.mmmi.cbse.OSGiCommon.data.Entity;
import dk.sdu.mmmi.cbse.OSGiCommon.data.GameData;
import dk.sdu.mmmi.cbse.OSGiCommon.data.World;
import dk.sdu.mmmi.cbse.OSGiCommon.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.OSGiCommon.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.OSGiCommon.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.OSGiCommon.services.IGamePluginService;


import java.util.Random;


public class EnemyPlugin implements IGamePluginService {

    private Entity player;

    public EnemyPlugin() {
    }


    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        player = createPlayerShip(gameData);
        world.addEntity(player);
    }

    private Entity createPlayerShip(GameData gameData) {
        float deceleration = 10;
        float acceleration = 150;
        float maxSpeed = 200;
        float rotationSpeed = 5;
        float x = new Random().nextFloat() * gameData.getDisplayWidth();
        float y = new Random().nextFloat() * gameData.getDisplayHeight();
        float radians = 3.1415f / 2;
        
        Entity enemyShip = new Enemy();
        enemyShip.setRadius(6);
        enemyShip.add(new MovingPart(deceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(1, 1000));
        
        return enemyShip;
    }


    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(player);
    }

}
