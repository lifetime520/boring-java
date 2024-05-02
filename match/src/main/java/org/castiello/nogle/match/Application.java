package org.castiello.nogle.match;

import java.io.File;
import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@EnableBatchProcessing
@SpringBootApplication
@Log4j2
@EnableAutoConfiguration
public class Application {

	// -Dpath=/Users/castiello.tsai/WorkSpace/Nogle/GitLab
	public static void main(String[] args) {
		System.setProperty("path", "/Users/castiello.tsai/WorkSpace/Nogle/GitLab");
		System.setProperty("input", "file://" + new File("/User/castiello.tsai/Destop/in.csv"));
		System.setProperty("output", "file://" + new File("/User/castiello.tsai/Destop/out.csv"));
		ApplicationContext context = SpringApplication.run(Application.class, args);
		log.info("applicationName:{} Ready.", context.getApplicationName());
	}

	@Bean
	Job job(JobBuilderFactory jbf
			, StepBuilderFactory sbf
			, Step1Configuration step1Configuration
			, Step2Configuration step2Configuration) {
		Step s1 = sbf.get("file-db")
				.<Person, Person> chunk(100)
				.reader(step1Configuration.fileReader(null))
//				.processor(new ItemProcessor<Person, Person>() {
//
//					@Override
//					public Person process(Person item) throws Exception {
//						// TODO Auto-generated method stub
//						return null;
//					}
//					
//				})
				.writer(step1Configuration.jdbcWriter(null))
				.build();

		Step s2 = sbf.get("db-file")
				.<Map<Integer, Integer>, Map<Integer, Integer>>chunk(1000)
				.reader(step2Configuration.jdbcReader(null))
				.writer(step2Configuration.fileWriter(null))
				.build();

		return jbf.get("etl")
				.incrementer(new RunIdIncrementer())
				.start(s1)
				.next(s2)
				.build();
	}

}

@Configuration
class Step1Configuration {

	@Bean
	FlatFileItemReader<Person> fileReader(@Value("${input}") Resource in) {
		return new FlatFileItemReaderBuilder<Person>()
				.resource(in)
				.name("file-reader")
				.targetType(Person.class)
				.delimited().delimiter(",").names(new String[] {"firstName", "age", "enail"})
				.build();
	}

	@Bean
	JdbcBatchItemWriter<Person> jdbcWriter(DataSource ds) {
		return new JdbcBatchItemWriterBuilder<Person>()
				.dataSource(ds)
				.sql("INSERT INTO PEOPLE(AGE, FIRST_NAME, EMAIL) VALUES (:age, :firstName, :email)")
				.beanMapped()
				.build();
	}
}

@Configuration
class Step2Configuration {

	@Bean
	FlatFileItemWriter<Map<Integer, Integer>> fileWriter(@Value("${output}") Resource out) {
		return new FlatFileItemWriterBuilder<Map<Integer, Integer>>()
				.name("file-writer")
				.resource(out)
				.lineAggregator(new DelimitedLineAggregator<Map<Integer, Integer>>() {
					{
						setDelimiter(",");
						setFieldExtractor(integerIntegerMap -> {
							Map.Entry<Integer, Integer> next = integerIntegerMap.entrySet().iterator().next();
							return new Object[] {next.getKey(), next.getValue()};
						});
					}
				})
				.build();
	}

	@Bean
	ItemReader<Map<Integer, Integer>> jdbcReader(DataSource ds) {
		return new JdbcCursorItemReaderBuilder<Map<Integer, Integer>>()
				.dataSource(ds)
				.name("jdbc-reader")
				.sql("SELECT COUNT(age) age_count, age FROM PEOPLE GROUP BY age")
				.rowMapper((result, rowNum) -> Collections.singletonMap(result.getInt("age_count"), result.getInt("age")))
				.build();
	}
}

@Getter
@Setter
class Person {
	private int age;
	private String firstName, email;
}
