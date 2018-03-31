/**
 * bereq stands for backend-request :) This is specifically a tooling file
 * which specifically handles just the request part of the 
 */
import axios from 'axios';
const log = require('simple-console-logger').getLogger('breq');
const config = require('../config')

function baseUrl() {
  return config.service.mode + '://' +
    config.service.host + ':' +
    config.service.port;
}

export function get(path, setter) {
  var url = baseUrl() + path;
  log.debug('calling: ' + url);
  axios.get(baseUrl() + path)
    .then(res => {
      setter(res.data);
    })
    .catch(function(err) {
      log.error(err);
    });
}
