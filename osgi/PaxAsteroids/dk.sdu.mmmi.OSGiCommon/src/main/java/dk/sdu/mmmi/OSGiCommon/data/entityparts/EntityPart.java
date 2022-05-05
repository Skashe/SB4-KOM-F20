/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.OSGiCommon.data.entityparts;

import dk.sdu.mmmi.cbse.OSGiCommon.data.Entity;
import dk.sdu.mmmi.cbse.OSGiCommon.data.GameData;

/**
 *
 * @author Alexander
 */
public interface EntityPart {
    void process(GameData gameData, Entity entity);
}
