package hello.security;


//@EnableWebSecurity
//@Configuration
public class SecurityConfig {

/*
    @Configuration
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(AuthenticationManagerBuilder auth)
                throws Exception {
            auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
            auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        }

        protected void configure(HttpSecurity http) throws Exception {
            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http
                    .antMatcher("/**")
                    .authorizeRequests()
                    .antMatchers("/**").authenticated()
                    .and()
                    .httpBasic();
        }

    }*/
}