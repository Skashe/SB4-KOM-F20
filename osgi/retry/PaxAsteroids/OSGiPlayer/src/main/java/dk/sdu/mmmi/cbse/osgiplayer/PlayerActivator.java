package dk.sdu.mmmi.cbse.osgiplayer;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PlayerActivator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        PlayerPlugin player = new PlayerPlugin();
        bundleContext.registerService(IGamePluginService.class, player, null);
        PlayerControlSystem ControlSystem = new PlayerControlSystem();
        bundleContext.registerService(IEntityProcessingService.class, ControlSystem, null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception{

    }
}
