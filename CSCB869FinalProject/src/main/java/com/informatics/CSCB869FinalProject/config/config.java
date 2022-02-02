package com.informatics.CSCB869FinalProject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class config
{
  @Bean
  public ModelMapper modelMapper()
  {
    return new ModelMapper();
  }

//  @Bean
//  public DataSource dataSource() {
//    return new EmbeddedDatabaseBuilder().setName("garage_db2").build();
//  }
//
//  @Bean
//  public JdbcTemplate jdbcTemplate() {
//    return new JdbcTemplate(dataSource());
//  }
//
//  @Bean
//  public PlatformTransactionManager transactionManager(){
//    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource());
//    return transactionManager;
//  }
}
