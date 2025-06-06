function fn() {
  var config = {
    baseUrl: 'https://reqres.in',
    reportDir: 'build/karate-reports' // Directorio para reportes
  };
  karate.configure('report', { showLog: true, showAllSteps: true });
  karate.configure('charset', 'UTF-8');
  return config;
}
