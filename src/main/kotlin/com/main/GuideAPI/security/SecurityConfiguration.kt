package com.main.GuideAPI.security
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.authentication.logout.LogoutHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class SecurityConfiguration(
    @Autowired
    private val jwtAuthFilter: JwtAuthenticationFilter,
    @Autowired
            private val authenticationProvider: AuthenticationProvider,
    @Autowired
            private val logoutHandler: LogoutHandler
) {
//.requestMatchers(new AntPathRequestMatcher("/public/**")).permitAll()
//            .anyRequest().authenticated()) //other URLs are only allowed authenticated users.

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .antMatchers("/api/v1/auth/**").permitAll().
                antMatchers("/api/v1/user/create").permitAll()
            //.antMatchers("/api/user/**").hasRole("USER")
            .anyRequest().authenticated()
            .and()


            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
            .logout()
            .logoutUrl("/api/v1/auth/logout")
            .addLogoutHandler(logoutHandler)
            .logoutSuccessHandler { request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication? -> SecurityContextHolder.clearContext() }
        return http.build()
    }
}