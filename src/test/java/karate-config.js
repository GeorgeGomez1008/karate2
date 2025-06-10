function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }

  var config = {
    env: env,
    baseUrl: 'https://gopass.tuya.com.co/' // default baseUrl
  }

  if (env == 'develop') {
    var config = {
    baseUrl: 'https://gopass.tuya.com.co/'
    };
  } else if (env == 'qa'){
    var config = {
    baseUrl: 'https://gopass.tuya.com.co/'
    };
  } else if (env == 'pdn'){
    var config = {
      baseUrl: 'https://gopass.tuya.com.co/'
   };
 }
  return config;

}


// function fn() {
//   var config = {
//     baseUrl: 'https://gopass.tuya.com.co/',
//     reportDir: 'build/karate-reports' // Directorio para reportes
//   };
//   karate.configure('report', { showLog: true, showAllSteps: true });
//   karate.configure('charset', 'UTF-8');
//   return config;
// }
