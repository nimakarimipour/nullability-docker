package org.cache2k;

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
import org.cache2k.processor.EntryMutator;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cache2k.processor.EntryProcessingResult;
import org.cache2k.processor.EntryProcessor;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;

/**
 * Base class for implementations of the cache interface. By default every methods throws
 * {@link UnsupportedOperationException}.
 *
 * @author Jens Wilke
 */
public class AbstractCache<K, V> implements Cache<K, V> {

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(@javax.annotation.Nullable K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CacheEntry<K, V> getEntry(@javax.annotation.Nullable K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V peek(@javax.annotation.Nullable K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CacheEntry<K, V> peekEntry(@javax.annotation.Nullable K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsKey(@javax.annotation.Nullable K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void put(@javax.annotation.Nullable K key, @javax.annotation.Nullable V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V computeIfAbsent(@javax.annotation.Nullable K key, @javax.annotation.Nullable Callable<V> callable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean putIfAbsent(@javax.annotation.Nullable K key, @javax.annotation.Nullable V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V peekAndReplace(@javax.annotation.Nullable K key, @javax.annotation.Nullable V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean replace(@javax.annotation.Nullable K key, @javax.annotation.Nullable V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean replaceIfEquals(@javax.annotation.Nullable K key, @javax.annotation.Nullable V oldValue, @javax.annotation.Nullable V newValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V peekAndRemove(@javax.annotation.Nullable K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAndRemove(@javax.annotation.Nullable K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(@javax.annotation.Nullable K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIfEquals(@javax.annotation.Nullable K key, @javax.annotation.Nullable V expectedValue) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAll(@javax.annotation.Nullable Iterable<? extends K> keys) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V peekAndPut(@javax.annotation.Nullable K key, @javax.annotation.Nullable V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void expireAt(@javax.annotation.Nullable K key, @javax.annotation.Nullable long millis) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadAll(@javax.annotation.Nullable Iterable<? extends K> keys, @javax.annotation.Nullable CacheOperationCompletionListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reloadAll(@javax.annotation.Nullable Iterable<? extends K> keys, @javax.annotation.Nullable CacheOperationCompletionListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Void> loadAll(@javax.annotation.Nullable Iterable<? extends K> keys) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CompletableFuture<Void> reloadAll(@javax.annotation.Nullable Iterable<? extends K> keys) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <R> R invoke(@javax.annotation.Nullable K key, @javax.annotation.Nullable EntryProcessor<K, V, R> processor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <R> Map<K, EntryProcessingResult<R>> invokeAll(@javax.annotation.Nullable Iterable<? extends K> keys, @javax.annotation.Nullable EntryProcessor<K, V, R> entryProcessor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void mutate(@javax.annotation.Nullable K key, @javax.annotation.Nullable EntryMutator<K, V> mutator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void mutateAll(@javax.annotation.Nullable Iterable<? extends K> keys, @javax.annotation.Nullable EntryMutator<K, V> mutator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<K, V> getAll(@javax.annotation.Nullable Iterable<? extends K> keys) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<K, V> peekAll(@javax.annotation.Nullable Iterable<? extends K> keys) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(@javax.annotation.Nullable Map<? extends K, ? extends V> valueMap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<K> keys() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<CacheEntry<K, V>> entries() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CacheManager getCacheManager() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <X> X requestInterface(@javax.annotation.Nullable Class<X> type) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
