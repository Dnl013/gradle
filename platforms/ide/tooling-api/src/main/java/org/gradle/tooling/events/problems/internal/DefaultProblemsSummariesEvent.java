/*
 * Copyright 2024 the original author or authors.
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

package org.gradle.tooling.events.problems.internal;

import org.gradle.tooling.events.OperationDescriptor;
import org.gradle.tooling.events.internal.BaseProgressEvent;
import org.gradle.tooling.events.problems.ProblemsSummaries;
import org.gradle.tooling.events.problems.ProblemsSummariesEvent;

public class DefaultProblemsSummariesEvent extends BaseProgressEvent implements ProblemsSummariesEvent {
    private final ProblemsSummaries defaultProblemsSummaries;

    public DefaultProblemsSummariesEvent(long eventTime, OperationDescriptor descriptor, ProblemsSummaries defaultProblemsSummaries) {
        super(eventTime, descriptor == null ? "<null>" : descriptor.getDisplayName(), descriptor);
        this.defaultProblemsSummaries = defaultProblemsSummaries;
    }

    @Override
    public ProblemsSummaries getProblemsSummaries() {
        return defaultProblemsSummaries;
    }
}
