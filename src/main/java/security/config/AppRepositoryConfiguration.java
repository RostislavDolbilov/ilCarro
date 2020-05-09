package security.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Objects;

/*
 * @author Rostislav Dolbilov
 * Datasource configuration for {@link datasource-cfg.properties}.
 */

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:datasource-cfg.properties" })
@EnableJpaRepositories(
		basePackages = "security.repository.app",
		entityManagerFactoryRef = "appEntityManagerFactory",
		transactionManagerRef = "appTransactionManager"
		)
public class AppRepositoryConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSourceProperties appDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource dataSource() {
		return appDataSourceProperties().initializeDataSourceBuilder()
				.type(BasicDataSource.class).build();
	}

	@Bean(name = "appEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean appEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource()).packages("security.model.app")
				.build();
	}

	@Bean(name = "appTransactionManager")
	public PlatformTransactionManager appTransactionManager(
			@Qualifier("appEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean.getObject()));
	}
}
