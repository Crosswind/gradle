/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.project.taskfactory;

import org.gradle.internal.id.ConfigurationCacheableIdFactory;

import java.util.concurrent.atomic.AtomicLong;

public class TestTaskIdentities {

    public static TaskIdentityFactory factory() {
        AtomicLong idCounter = new AtomicLong(0);
        ConfigurationCacheableIdFactory idFactory = new ConfigurationCacheableIdFactory() {
            @Override
            public long createId() {
                return idCounter.incrementAndGet();
            }

            @Override
            public void idRecreated() {
            }
        };
        return new TaskIdentityFactory(idFactory);
    }
}
