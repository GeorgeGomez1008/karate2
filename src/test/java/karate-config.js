function fn() {
    var env = karate.env || 'dev';
    karate.log('karate.env system property was:', env);
    var config = {
        env: env,
        baseUrl: 'https://gopass.tuya.com.co/'
    };
    if (env == 'develop') {
        config.baseUrl = 'https://gopass.tuya.com.co/';
    } else if (env == 'qa') {
        config.baseUrl = 'https://gopass.tuya.com.co/';
    } else if (env == 'pdn') {
        config.baseUrl = 'https://gopass.tuya.com.co/';
    }
    return config;
}