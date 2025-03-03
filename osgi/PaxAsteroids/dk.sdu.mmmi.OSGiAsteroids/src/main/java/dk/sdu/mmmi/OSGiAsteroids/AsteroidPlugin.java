package dk.sdu.mmmi.OSGiAsteroids;

import dk.sdu.mmmi.OSGiCommon.data.Entity;
import dk.sdu.mmmi.OSGiCommon.data.GameData;
import dk.sdu.mmmi.OSGiCommon.data.World;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.LifePart;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.MovingPart;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.PositionPart;
import dk.sdu.mmmi.OSGiCommon.services.IGamePluginService;


import java.util.Random;


public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    public AsteroidPlugin() {
    }


    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {
        float radians = 3.1415f / 2 + (float) Math.random();
        float x = new Random().nextFloat() * gameData.getDisplayWidth();
        float y = new Random().nextFloat() * gameData.getDisplayHeight();

        int rndNum = new Random().nextInt(150) % 3;

        Asteroid asteroid = new Asteroid(AsteroidType.values()[rndNum]);

        asteroid.setRadius(asteroid.getSize());
        asteroid.add(new MovingPart(0, asteroid.getSpeed(), asteroid.getSpeed(), 0));
        asteroid.add(new PositionPart(x, y, radians));
        asteroid.add(new LifePart(asteroid.getLife(), 0));

        return asteroid;
    }

    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

}
