/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.CronJobs.model;

/**
 *
 */
public class VeraExport
{
	private String baseCode;
	private String StyleVarientCode;
	private String sizeVarientCode;
	private String style;
	private String genders;

	/**
	 * @return the baseCode
	 */
	public String getBaseCode()
	{
		return baseCode;
	}

	/**
	 * @param baseCode
	 *           the baseCode to set
	 */
	public void setBaseCode(final String baseCode)
	{
		this.baseCode = baseCode;
	}

	/**
	 * @return the styleVarientCode
	 */
	public String getStyleVarientCode()
	{
		return StyleVarientCode;
	}

	/**
	 * @param styleVarientCode
	 *           the styleVarientCode to set
	 */
	public void setStyleVarientCode(final String styleVarientCode)
	{
		StyleVarientCode = styleVarientCode;
	}

	/**
	 * @return the sizeVarientCode
	 */
	public String getSizeVarientCode()
	{
		return sizeVarientCode;
	}

	/**
	 * @param sizeVarientCode
	 *           the sizeVarientCode to set
	 */
	public void setSizeVarientCode(final String sizeVarientCode)
	{
		this.sizeVarientCode = sizeVarientCode;
	}

	/**
	 * @return the style
	 */
	public String getStyle()
	{
		return style;
	}

	/**
	 * @param style
	 *           the style to set
	 */
	public void setStyle(final String style)
	{
		this.style = style;
	}

	/**
	 * @return the genders
	 */
	public String getGenders()
	{
		return genders;
	}

	/**
	 * @param genders
	 *           the genders to set
	 */
	public void setGenders(final String genders)
	{
		this.genders = genders;
	}

	@Override
	public String toString()
	{
		return "VeraExport [baseCode=" + baseCode + ", StyleVarientCode=" + StyleVarientCode + ", sizeVarientCode="
				+ sizeVarientCode + ", style=" + style + ", genders=" + genders + "]";
	}

}
