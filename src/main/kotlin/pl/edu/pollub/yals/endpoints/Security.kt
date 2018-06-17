//package pl.edu.pollub.yals.endpoints
//
////import com.auth0.jwk.JwkProvider
////import com.auth0.jwk.JwkProviderBuilder
////import com.auth0.spring.security.api.BearerSecurityContextRepository
////import com.auth0.spring.security.api.JwtAuthenticationProvider
////import org.springframework.beans.factory.annotation.Value
////import org.springframework.context.annotation.Bean
////import org.springframework.context.annotation.Configuration
////import org.springframework.context.annotation.PropertySource
////import org.springframework.http.HttpMethod
////import org.springframework.security.authentication.ReactiveAuthenticationManager
////import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
////import org.springframework.security.config.web.server.ServerHttpSecurity
////import org.springframework.security.core.Authentication
////import org.springframework.security.web.server.SecurityWebFilterChain
//import com.auth0.jwk.JwkProvider
//import com.auth0.jwk.JwkProviderBuilder
//import com.auth0.spring.security.api.JwtAuthenticationProvider
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.PropertySource
//import org.springframework.http.HttpMethod
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
//import org.springframework.security.config.web.server.ServerHttpSecurity
//import org.springframework.security.web.server.SecurityWebFilterChain
//import reactor.core.publisher.Mono
//
//@EnableWebFluxSecurity
//@Configuration
//@PropertySource("classpath:auth0.properties")
//class Security {
//    @Value(value = "\${auth0.apiAudience}")
//    lateinit var apiAudience: String;
//    @Value(value = "\${auth0.issuer}")
//    lateinit var issuer: String;
//
//    @Bean
//    fun jwkProvider(): JwkProvider = JwkProviderBuilder(issuer).build()
//
//    @Bean
//    fun jwtAuthenticationProvider(jwk: JwkProvider): JwtAuthenticationProvider =
//            JwtAuthenticationProvider(jwk, issuer, apiAudience)
//
//    @Bean
//    fun authorizationChain(http: ServerHttpSecurity, jwtAuthenticationProvider: JwtAuthenticationProvider): SecurityWebFilterChain = http
//            .csrf().disable()
//            .httpBasic().disable()
//            .formLogin().disable()
//            .exceptionHandling()
//            .and().authorizeExchange()
//            .pathMatchers(HttpMethod.GET, "/api/private/**").permitAll()
//            .pathMatchers(HttpMethod.GET, "/api/private/**").permitAll()
//            .pathMatchers(HttpMethod.POST, "/api/private/**").permitAll()
//            .pathMatchers(HttpMethod.PUT, "/api/private/**").permitAll()
//            .anyExchange().authenticated()
//            .and()
//            .securityContextRepository(BearerServerSecurityContextRepository())
//            .authenticationManager {
//                var authentication = it;
//                val auth = jwtAuthenticationProvider.authenticate(authentication);
//                if(auth !=null){
//                    authentication = auth;
//                }
//                Mono.just(authentication)
//            }
//            .build()
//}