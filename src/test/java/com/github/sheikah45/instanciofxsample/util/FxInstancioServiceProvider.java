package com.github.sheikah45.instanciofxsample.util;

import org.instancio.generator.GeneratorContext;
import org.instancio.spi.InstancioServiceProvider;
import org.instancio.spi.ServiceProviderContext;

public class FxInstancioServiceProvider implements InstancioServiceProvider {

    private GeneratorContext generatorContext;

    @Override
    public void init(final ServiceProviderContext providerContext) {
        this.generatorContext = new GeneratorContext(
                providerContext.getSettings(),
                providerContext.random());
    }

    @Override
    public GeneratorProvider getGeneratorProvider() {
        return new FxGeneratorProvider(generatorContext);
    }
}
