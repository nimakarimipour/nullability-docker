package org.cache2k.spi;

/*
 * #%L
 * cache2k API
 * %%
 * Copyright (C) 2000 - 2020 headissue GmbH, Munich
 * %%
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
 * #L%
 */
import org.cache2k.Cache;
import org.cache2k.CacheManager;
import org.cache2k.config.Cache2kConfig;

/**
 * Interface to the cache2k implementation. This interface is not intended for the application
 * usage. Use the static methods on the {@link CacheManager}.
 *
 * @author Jens Wilke; created: 2015-03-26
 */
public interface Cache2kCoreProvider {

    /**
     * @see CacheManager#setDefaultName(String)
     */
    void setDefaultManagerName(@javax.annotation.Nullable ClassLoader cl, @javax.annotation.Nullable String s);

    /**
     * @see CacheManager#getDefaultName()
     */
    String getDefaultManagerName(@javax.annotation.Nullable ClassLoader cl);

    /**
     * @see CacheManager#getInstance(ClassLoader, String)
     */
    CacheManager getManager(@javax.annotation.Nullable ClassLoader cl, @javax.annotation.Nullable String name);

    /**
     * Default class loader, this is the class loader used to load the cache implementation.
     */
    ClassLoader getDefaultClassLoader();

    /**
     * Close all cache2k cache managers.
     */
    void close();

    /**
     * Close all cache manager associated to this class loader.
     */
    void close(@javax.annotation.Nullable ClassLoader l);

    /**
     * Close a specific cache manager by its name.
     */
    void close(@javax.annotation.Nullable ClassLoader l, @javax.annotation.Nullable String managerName);

    /**
     * Create a cache, apply external configuration before creating it.
     */
    <K, V> Cache<K, V> createCache(@javax.annotation.Nullable CacheManager m, @javax.annotation.Nullable Cache2kConfig<K, V> cfg);

    /**
     * Return the effective default configuration for this manager. A different default
     * configuration may be provided by the configuration system.
     *
     * @return mutable configuration instance containing the effective configuration defaults,
     *         never {@code null}
     */
    Cache2kConfig getDefaultConfig(@javax.annotation.Nullable CacheManager m);

    /**
     * @since 2
     */
    String getVersion();
}
