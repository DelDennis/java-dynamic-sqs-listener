package com.jashmore.sqs.broker.concurrent;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.validation.constraints.PositiveOrZero;

/**
 * Implementation that will cache the values as the methods to retrieve the values may be costly.
 *
 * <p>For example, an outbound call is needed to get this value and it is costly to do this every time a message has been processed.
 *
 * <p>This implementation is thread safe even though it is not required to be due to the thread safety of the {@link LoadingCache}.
 */
@ThreadSafe
public class CachingConcurrentMessageBrokerProperties implements ConcurrentMessageBrokerProperties {
    /**
     * Cache key as only a single value is being loaded into the cache.
     */
    private static final Boolean SINGLE_CACHE_VALUE_KEY = true;

    private final LoadingCache<Boolean, Integer> cachedConcurrencyLevel;
    private final LoadingCache<Boolean, Long> cachedPreferredConcurrencyPollingRateInSeconds;
    private final LoadingCache<Boolean, Long> cachedErrorBackoffTimeInMilliseconds;
    private final String threadNameFormat;
    private final LoadingCache<Boolean, Long> cachedShutdownTimeoutInSeconds;
    private final LoadingCache<Boolean, Boolean> interruptThreadsProcessingMessagesOnShutdownCache;

    /**
     * Constructor.
     *
     * @param cachingTimeoutInMs the amount of time in milliseconds that the values for each property should be cached internally
     * @param delegateProperties the delegate properties object that should be called when the cache has not been populated yet or has expired
     */
    public CachingConcurrentMessageBrokerProperties(final int cachingTimeoutInMs,
                                                    final ConcurrentMessageBrokerProperties delegateProperties) {
        this.cachedConcurrencyLevel = CacheBuilder.newBuilder()
                .expireAfterWrite(cachingTimeoutInMs, TimeUnit.MILLISECONDS)
                .build(CacheLoader.from(delegateProperties::getConcurrencyLevel));

        this.cachedPreferredConcurrencyPollingRateInSeconds = CacheBuilder.newBuilder()
                .expireAfterWrite(cachingTimeoutInMs, TimeUnit.MILLISECONDS)
                .build(CacheLoader.from(delegateProperties::getPreferredConcurrencyPollingRateInMilliseconds));

        this.cachedErrorBackoffTimeInMilliseconds = CacheBuilder.newBuilder()
                .expireAfterWrite(cachingTimeoutInMs, TimeUnit.MILLISECONDS)
                .build(CacheLoader.from(delegateProperties::getErrorBackoffTimeInMilliseconds));

        this.threadNameFormat = delegateProperties.getThreadNameFormat();

        this.cachedShutdownTimeoutInSeconds = CacheBuilder.newBuilder()
                .expireAfterWrite(cachingTimeoutInMs, TimeUnit.MILLISECONDS)
                .build(CacheLoader.from(delegateProperties::getShutdownTimeoutInSeconds));

        this.interruptThreadsProcessingMessagesOnShutdownCache = CacheBuilder.newBuilder()
                .expireAfterWrite(cachingTimeoutInMs, TimeUnit.MILLISECONDS)
                .build(CacheLoader.from(delegateProperties::shouldInterruptThreadsProcessingMessagesOnShutdown));
    }

    @PositiveOrZero
    @Override
    public Integer getConcurrencyLevel() {
        return cachedConcurrencyLevel.getUnchecked(SINGLE_CACHE_VALUE_KEY);
    }

    @PositiveOrZero
    @Override
    public Long getPreferredConcurrencyPollingRateInMilliseconds() {
        return cachedPreferredConcurrencyPollingRateInSeconds.getUnchecked(SINGLE_CACHE_VALUE_KEY);
    }

    @Nullable
    @Override
    public String getThreadNameFormat() {
        return threadNameFormat;
    }

    @Nullable
    @PositiveOrZero
    @Override
    public Long getErrorBackoffTimeInMilliseconds() {
        return cachedErrorBackoffTimeInMilliseconds.getUnchecked(SINGLE_CACHE_VALUE_KEY);
    }

    @Nullable
    @Override
    public @PositiveOrZero Long getShutdownTimeoutInSeconds() {
        return cachedShutdownTimeoutInSeconds.getUnchecked(SINGLE_CACHE_VALUE_KEY);
    }

    @Override
    public boolean shouldInterruptThreadsProcessingMessagesOnShutdown() {
        return interruptThreadsProcessingMessagesOnShutdownCache.getUnchecked(SINGLE_CACHE_VALUE_KEY);
    }
}
