/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package logic.cronjobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.CronJobs.model.VeraExport;
import org.apache.log4j.Logger;

import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import com.opencsv.CSVWriter;


/**
 *
 */
public class VerraIntegrationJob extends AbstractJobPerformable<CronJobModel>
{
	private static final Logger LOG = Logger.getLogger(VerraIntegrationJob.class);

	@Resource
	private FlexibleSearchService flexibleSearchService;
	@Override
	public PerformResult perform(final CronJobModel arg0)
	{
		LOG.info("VerraIntegrationJob perform() method is invoked");
		final FlexibleSearchQuery query = new FlexibleSearchQuery(
				"select {tp.code},{p.code},{vp.code},{vp.style},{tp.genders} from {ApparelSizeVariantProduct as vp join ApparelStyleVariantProduct as  p on {vp.baseproduct}={p.pk} join ApparelProduct as tp on {p.baseproduct}={tp.pk}} where {p.code} like'%sku%'");
		query.setResultClassList(Arrays.asList(String.class, String.class, String.class, String.class, String.class));
		final SearchResult searchResult = flexibleSearchService.search(query);
		final List results = searchResult.getResult();
		final List<VeraExport> list = new ArrayList<VeraExport>();
		final int toSize = results.size();

		CSVWriter fileWriter;

		try
		{
			fileWriter = new CSVWriter(new FileWriter("F://Vera/test.csv"));
			LOG.info("VerraIntegrationJob try block2 is invoked");

			LOG.info("VerraIntegrationJob " + results + "try block2 is invoked");
		
			final List<String> ls = Lists.transform(results, Functions.toStringFunction());
			final Object[] objectArray = ls.toArray();
			final String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);
			fileWriter.writeNext(stringArray);

			//fileWriter.writeNext(stringArray);

			fileWriter.close();


		}
		catch (final IOException e)
		{
			LOG.info("VerraIntegrationJob catch block is invoked");
			e.printStackTrace();

		}
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);

	}

	private Object getRecordToPrint(final VeraExport result)
	{



		return result.toString();
	}

}
