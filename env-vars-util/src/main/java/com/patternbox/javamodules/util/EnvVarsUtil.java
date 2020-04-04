package com.patternbox.javamodules.util;

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class EnvVarsUtil {

	private static final Logger LOGGER = Logger.getLogger(EnvVarsUtil.class.getName());

	public EnvVarsUtil() {
		LOGGER.info("Class EnvVarsUtil created.");
	}

	public Map<String, String> getEnvironmentVars() {
		return new TreeMap<String, String>(System.getenv());
	}
}
