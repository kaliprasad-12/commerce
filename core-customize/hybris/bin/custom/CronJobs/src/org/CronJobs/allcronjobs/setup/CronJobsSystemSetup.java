/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.CronJobs.allcronjobs.setup;

import static org.CronJobs.allcronjobs.constants.CronJobsConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.CronJobs.allcronjobs.constants.CronJobsConstants;
import org.CronJobs.allcronjobs.service.CronJobsService;


@SystemSetup(extension = CronJobsConstants.EXTENSIONNAME)
public class CronJobsSystemSetup
{
	private final CronJobsService CronJobsService;

	public CronJobsSystemSetup(final CronJobsService CronJobsService)
	{
		this.CronJobsService = CronJobsService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		CronJobsService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return CronJobsSystemSetup.class.getResourceAsStream("/CronJobs/sap-hybris-platform.png");
	}
}
