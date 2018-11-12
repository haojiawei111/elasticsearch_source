/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.aggregations.pipeline.bucketmetrics.stats.extended;

import org.elasticsearch.search.DocValueFormat;
import org.elasticsearch.search.aggregations.ParsedAggregation;
import org.elasticsearch.search.aggregations.metrics.InternalExtendedStatsTests;
import org.elasticsearch.search.aggregations.metrics.stats.extended.InternalExtendedStats;
import org.elasticsearch.search.aggregations.pipeline.PipelineAggregator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class InternalExtendedStatsBucketTests extends InternalExtendedStatsTests {

    @Override
    protected InternalExtendedStatsBucket createInstance(String name, long count, double sum, double min, double max, double sumOfSqrs,
            double sigma, DocValueFormat formatter, List<PipelineAggregator> pipelineAggregators, Map<String, Object> metaData) {
        return new InternalExtendedStatsBucket(name, count, sum, min, max, sumOfSqrs, sigma, formatter, pipelineAggregators,
                Collections.emptyMap());
    }

    @Override
    protected void assertFromXContent(InternalExtendedStats aggregation, ParsedAggregation parsedAggregation) {
        super.assertFromXContent(aggregation, parsedAggregation);
        assertTrue(parsedAggregation instanceof ParsedExtendedStatsBucket);
    }
}
