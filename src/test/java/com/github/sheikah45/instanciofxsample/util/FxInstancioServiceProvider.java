package com.github.sheikah45.instanciofxsample.util;

import org.instancio.spi.InstancioServiceProvider;

public class FxInstancioServiceProvider implements InstancioServiceProvider {
    @Override
    public GeneratorProvider getGeneratorProvider() {
        return new FxGeneratorProvider();
    }
}
