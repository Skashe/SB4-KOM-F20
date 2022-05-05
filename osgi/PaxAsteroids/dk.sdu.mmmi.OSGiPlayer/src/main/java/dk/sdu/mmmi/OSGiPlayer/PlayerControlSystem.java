package dk.sdu.mmmi.cbse.OSGiPlayer;

import dk.sdu.mmmi.cbse.OSGiCommon.data.Entity;
import dk.sdu.mmmi.cbse.OSGiCommon.data.GameData;
import static dk.sdu.mmmi.cbse.OSGiCommon.data.GameKeys.LEFT;
import static dk.sdu.mmmi.cbse.OSGiCommon.data.GameKeys.RIGHT;
import static dk.sdu.mmmi.cbse.OSGiCommon.data.GameKeys.UP;
import dk.sdu.mmmi.cbse.OSGiCommon.data.World;
import dk.sdu.mmmi.cbse.OSGiCommon.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.OSGiCommon.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.OSGiCommon.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.OSGiCommon.services.IEntityProcessingService;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;


public class PlayerControlSystem implements IEntityProcessingService {

    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            PositionPart positionPart = player.getPart(PositionPart.class);
            MovingPart movingPart = player.getPart(MovingPart.class);
            LifePart lifePart = player.getPart(LifePart.class);

            movingPart.setLeft(gameData.getKeys().isDown(LEFT));
            movingPart.setRight(gameData.getKeys().isDown(RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(UP));
            
            
            movingPart.process(gameData, player);
            positionPart.process(gameData, player);
            lifePart.process(gameData, player);

            updateShape(player);
        }
    }

    private void updateShape(Entity entity) {
        float radius = entity.getRadius();
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * radius);
        shapey[0] = (float) (y + Math.sin(radians) * radius);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * radius);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * radius);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * radius * 0.625);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * radius * 0.625);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * radius);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * radius);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
