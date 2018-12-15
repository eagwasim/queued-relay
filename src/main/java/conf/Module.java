/**
 * Copyright (C) 2012-2018 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package conf;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import ninja.utils.NinjaProperties;
import services.*;

@Singleton
public class Module extends AbstractModule {
    private NinjaProperties ninjaProperties;

    @Inject
    public Module(NinjaProperties ninjaProperties) {
        this.ninjaProperties = ninjaProperties;
    }

    protected void configure() {
        if (ninjaProperties.isDev()) {
            bind(QueueService.class).to(MockSynchronizedQueueImpl.class);
        } else {
            bind(QueueService.class).to(ActiveMQImpl.class);
        }

        bind(Initialization.class);
        bind(DataQueuingService.class);
        bind(DataRestorationService.class);
    }
}
