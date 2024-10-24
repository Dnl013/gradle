/*
 * Copyright 2019 the original author or authors.
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

package org.gradle.api.artifacts.repositories;

import org.gradle.api.file.FileSystemLocation;
import org.gradle.api.provider.Property;
import org.gradle.internal.instrumentation.api.annotations.ReplacedAccessor;
import org.gradle.internal.instrumentation.api.annotations.ReplacesEagerProperty;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

/**
 * A repository that supports resolving artifacts from a URL.
 *
 * @since 6.0
 */
public interface UrlArtifactRepository {

    /**
     * The base URL of this repository.
     */
    @ReplacesEagerProperty(replacedAccessors = {
        @ReplacedAccessor(originalType = URI.class, value = ReplacedAccessor.AccessorType.GETTER, name = "getUrl"),
    })
    Property<URI> getUrl();

    /**
     * Sets the base URL of this repository.
     *
     * @param url The base URL.
     * <p>The provided value is evaluated as per {@link org.gradle.api.Project#uri(Object)}. This means, for example, you can pass in a {@code File} object, or a relative path to be evaluated relative
     * to the project directory.
     * @deprecated Use {@link #getUrl()} instead.
     */
    @Deprecated
    void setUrl(CharSequence url);

    /**
     * Sets the base URL of this repository.
     *
     * @param url The base URL.
     * <p>The provided value is evaluated as per {@link org.gradle.api.Project#uri(Object)}. This means, for example, you can pass in a {@code File} object, or a relative path to be evaluated relative
     * to the project directory.
     * @deprecated Use {@link #getUrl()} instead.
     */
    @Deprecated
    void setUrl(File url);

    /**
     * Sets the base URL of this repository.
     *
     * @param url The base URL.
     * <p>The provided value is evaluated as per {@link org.gradle.api.Project#uri(Object)}. This means, for example, you can pass in a {@code File} object, or a relative path to be evaluated relative
     * to the project directory.
     * @deprecated Use {@link #getUrl()} instead.
     */
    @Deprecated
    void setUrl(FileSystemLocation url);

    /**
     * Sets the base URL of this repository.
     *
     * @param url The base URL.
     * <p>The provided value is evaluated as per {@link org.gradle.api.Project#uri(Object)}. This means, for example, you can pass in a {@code File} object, or a relative path to be evaluated relative
     * to the project directory.
     * @deprecated Use {@link #getUrl()} instead.
     */
    @Deprecated
    void setUrl(Path url);

    /**
     * Sets the base URL of this repository.
     *
     * @param url The base URL.
     * <p>The provided value is evaluated as per {@link org.gradle.api.Project#uri(Object)}. This means, for example, you can pass in a {@code File} object, or a relative path to be evaluated relative
     * to the project directory.
     * @deprecated Use {@link #getUrl()} instead.
     */
    @Deprecated
    void setUrl(URL url);
    /**
     * Sets the base URL of this repository.
     *
     * @param url The base URL.
     * <p>The provided value is evaluated as per {@link org.gradle.api.Project#uri(Object)}. This means, for example, you can pass in a {@code File} object, or a relative path to be evaluated relative
     * to the project directory.
     * @deprecated Use {@link #getUrl()} instead.
     */
    @Deprecated
    void setUrl(URI url);

    /**
     * Specifies whether it is acceptable to communicate with a repository over an insecure HTTP connection.
     * <p>
     * For security purposes this intentionally requires a user to opt-in to using insecure protocols on case by case basis.
     * <p>
     * Gradle intentionally does not offer a global system/gradle property that allows a universal disable of this check.
     * <p>
     * <b>Allowing communication over insecure protocols allows for a man-in-the-middle to impersonate the intended server,
     * and gives an attacker the ability to
     * <a href="https://max.computer/blog/how-to-take-over-the-computer-of-any-java-or-clojure-or-scala-developer/">serve malicious executable code onto the system.</a>
     * </b>
     * <p>
     * See also:
     * <a href="https://medium.com/bugbountywriteup/want-to-take-over-the-java-ecosystem-all-you-need-is-a-mitm-1fc329d898fb">Want to take over the Java ecosystem? All you need is a MITM!</a>
     */
    @ReplacesEagerProperty(originalType = boolean.class)
    Property<Boolean> getAllowInsecureProtocol();
}
