var config = {
  service : {
    host : 'localhost',
    port : '4567',
    mode : 'http'
  }
};

function baseUrl() {
  return config.service.mode + '://' +
    config.service.host + ':' +
    config.service.port;
}

module.exports = config, baseUrl();