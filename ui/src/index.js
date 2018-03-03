import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import configureStore, { history } from './store';
require('bootstrap/dist/css/bootstrap.min.css')
//require('../bootstrap/dist/css/bootstrap.min.css')



const store = configureStore();

ReactDOM.render(<App store={store} history={history} />, document.getElementById('root'));
registerServiceWorker();
