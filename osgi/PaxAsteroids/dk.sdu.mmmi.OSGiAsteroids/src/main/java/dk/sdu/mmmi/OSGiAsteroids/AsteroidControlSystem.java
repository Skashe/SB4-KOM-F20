package dk.sdu.mmmi.OSGiAsteroids;

import dk.sdu.mmmi.OSGiCommon.data.Entity;
import dk.sdu.mmmi.OSGiCommon.data.GameData;
import static dk.sdu.mmmi.OSGiCommon.data.GameKeys.LEFT;
import static dk.sdu.mmmi.OSGiCommon.data.GameKeys.RIGHT;
import static dk.sdu.mmmi.OSGiCommon.data.GameKeys.UP;
import dk.sdu.mmmi.OSGiCommon.data.World;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.LifePart;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.MovingPart;
import dk.sdu.mmmi.OSGiCommon.data.entityparts.PositionPart;
import dk.sdu.mmmi.OSGiCommon.services.IEntityProcessingService;


import java.util.Random;



public class AsteroidControlSystem implements IEntityProcessingService {

    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            LifePart lifePart = asteroid.getPart(LifePart.class);

            movingPart.setLeft(new Random().nextInt(10) > 7);
            movingPart.setUp(true);
            
            
            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);
            lifePart.process(gameData, asteroid);

            updateShape(asteroid);
        }
    }

    private void updateShape(Entity entity) {
        Asteroid asteroid = (Asteroid) entity;
        int numPoints = asteroid.getPoints();
        float radius = entity.getRadius();
        float angle = asteroid.getAngle() - (float) Math.random() / 100;
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        float[] shapex = new float[numPoints], shapey = new float[numPoints];

        for (int i = 0; i < numPoints; i++){
            shapex[i] = x + (float) Math.cos(radians + angle) * radius;
            shapey[i] = y + (float) Math.sin(radians + angle) * radius;

            angle += (2 * 3.1415f / numPoints);
        }


        asteroid.setAngle(angle);
        asteroid.setShapeX(shapex);
        asteroid.setShapeY(shapey);
    }

}
