package com.yuzee.common.lib.job;

import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "spring.batch.job.max-skip")
public class SkipAnyFailureSkipPolicy implements SkipPolicy {

	@Value("${spring.batch.job.max-skip}")
	private int maxSkip;

	@Override
	public boolean shouldSkip(Throwable exception, int skipCount) {
		return true;
	}
}