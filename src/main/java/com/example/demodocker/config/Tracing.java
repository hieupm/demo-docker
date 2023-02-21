package com.example.demodocker.config;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;

public class Tracing {
    public static final Tracer tracer = initTracer();

    private static Tracer initTracer() {
        Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv()
                .withType("const")
                .withParam(1);

        Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv()
                .withLogSpans(true);

        Configuration config = new Configuration("my-service")
                .withSampler(samplerConfig)
                .withReporter(reporterConfig);

        return config.getTracer();
    }
}
