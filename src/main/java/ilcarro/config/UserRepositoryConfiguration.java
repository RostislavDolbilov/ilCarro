package ilcarro.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
 * Second-datasource configuration for {@link datasource-cfg.properties}.
 */

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:datasource-cfg.properties" })
@EnableJpaRepositories(
		basePackages = "ilcarro.repository.auth",
		entityManagerFactoryRef = "userEntityManager",
		transactionManagerRef = "userTransactionManager"
		)
public class UserRepositoryConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.second-datasource")
	public DataSourceProperties userDataSourceProperties() {
		return new DataSourceProperties();
	}


	@Bean
	@Primary
	public DataSource userDataSource() {
		return userDataSourceProperties().initializeDataSourceBuilder()
				.type(BasicDataSource.class).build();
	}

	@Bean(name = "userEntityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean userEntityManager(
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(userDataSource()).packages("ilcarro.model.auth")
				.build();
	}

	@Bean(name = "userTransactionManager")
	@Primary
	public PlatformTransactionManager userTransactionManager(
			@Qualifier("userEntityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean.getObject()));
	}
}
