package com.hca.utils;

import java.util.Locale;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
public final class ProjectConstants {

	// FIXME : Customize project constants for your application.

	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final Locale TURKISH_LOCALE = new Locale.Builder().setLanguage("tr").setRegion("TR").build();

	public static final Locale VIETNAM_LOCALE = new Locale.Builder().setLanguage("vn").setRegion("VN").build();
	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}
