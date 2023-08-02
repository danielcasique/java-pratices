package org.casique.dagger;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = VehiclesModule.class)
public interface VehiclesComponent {
  Car buildCar();
}
