package com.patternbox.javamodules.app;

import com.patternbox.javamodules.util.EnvVarsUtil;

public class EnvVarsApplication {

	public static void main(String[] args) {
		EnvVarsUtil helper = new EnvVarsUtil();
		helper.getEnvironmentVars().forEach((k, v) -> {
			System.out.println(k + "=" + v);
		});
	}

}
