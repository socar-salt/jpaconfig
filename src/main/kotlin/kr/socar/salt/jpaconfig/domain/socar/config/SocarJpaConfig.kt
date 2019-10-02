package kr.socar.salt.jpaconfig.domain.socar.config

import kr.socar.salt.jpaconfig.domain.base.BaseJpaConfig
import kr.socar.salt.jpaconfig.properties.JpaProperties
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
    basePackages = [SocarJpaConfig.REPOSITORY_PACKAGE_NAME],
    entityManagerFactoryRef = SocarJpaConfig.ENTITY_MANAGER_FACTORY_BEAN_NAME,
    transactionManagerRef = SocarJpaConfig.TRANSACTION_MANAGER_BEAN_NAME
)
class SocarJpaConfig : BaseJpaConfig() {

    companion object {
        private const val JPA_PROPERTIES = "socar-jpa"
        private const val JPA_PROPERTIES_BEAN_NAME = "socarJpaProperties"
        private const val DATA_SOURCE_PROPERTIES = "socar-jpa.datasource"
        private const val DATA_SOURCE_PROPERTIES_BEAN_NAME = "socarDataSourceProperties"
        private const val DATA_SOURCE_BEAN_NAME = "socarDataSource"
        const val REPOSITORY_PACKAGE_NAME = "kr.socar.salt.jpaconfig.domain.socar.domain"
        const val ENTITY_MANAGER_FACTORY_BEAN_NAME = "socarEntityManagerFactory"
        const val TRANSACTION_MANAGER_BEAN_NAME = "socarTransactionManager"
    }

    @Primary
    @Bean(JPA_PROPERTIES_BEAN_NAME)
    @ConfigurationProperties(JPA_PROPERTIES)
    override fun jpaProperties(): JpaProperties {
        return super.jpaProperties()
    }

    @Primary
    @Bean(DATA_SOURCE_PROPERTIES_BEAN_NAME)
    @ConfigurationProperties(DATA_SOURCE_PROPERTIES)
    override fun dataSourceProperties(): DataSourceProperties {
        return super.dataSourceProperties()
    }

    @Primary
    @Bean(DATA_SOURCE_BEAN_NAME)
    override fun dataSource(
        @Qualifier(DATA_SOURCE_PROPERTIES_BEAN_NAME)
        dataSourceProperties: DataSourceProperties
    ): DataSource {
        return super.dataSource(dataSourceProperties)
    }

    @Primary
    @Bean(ENTITY_MANAGER_FACTORY_BEAN_NAME)
    override fun entityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier(DATA_SOURCE_BEAN_NAME) dataSource: DataSource,
        @Qualifier(JPA_PROPERTIES_BEAN_NAME) jpaProperties: JpaProperties
    ): LocalContainerEntityManagerFactoryBean {
        return super.entityManagerFactory(builder, dataSource, jpaProperties)
    }

    @Primary
    @Bean(TRANSACTION_MANAGER_BEAN_NAME)
    override fun transactionManager(
        @Qualifier(ENTITY_MANAGER_FACTORY_BEAN_NAME)
        entityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return super.transactionManager(entityManagerFactory)
    }
}
