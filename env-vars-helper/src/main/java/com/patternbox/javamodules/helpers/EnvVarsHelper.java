package com.patternbox.javamodules.helpers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnvVarsHelper {

	public List<String> getEnvironmentVars() {
		Map<String, String> env = System.getenv();
		return env.keySet().stream().sorted().collect(Collectors.toList());
	}
}
