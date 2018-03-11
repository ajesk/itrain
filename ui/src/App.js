import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { Provider } from 'react-redux';
import { BrowserRouter } from 'react-router-dom';
import { Route, Switch } from 'react-router-dom';
import Logger from 'simple-console-logger';
import NavBar from './components/nav/NavBar';

import HelloContainer from './hello/HelloContainer';
import Home from './components/Home'
import TaskContainer from './components/task/TaskContainer'
import UserContainer from './components/user/UserContainer'

Logger.configure({level: 'debug'});

class App extends Component {
  static propTypes = {
    store: PropTypes.object.isRequired,
    history: PropTypes.object.isRequired
  };

  render() {
    return (
      <div>
        <NavBar />
        <Provider store={this.props.store}>
          <BrowserRouter>
            <Switch>
              <Route exact path="/hello" render={(props) => (
                <div><HelloContainer /></div>
              )}/>
              <Route exact path="/task" render={(props) => (
                <div><TaskContainer /></div>
              )}/>
              <Route exact path="/user" render={(props) => (
                <div><UserContainer /></div>
              )}/>
              <Route path="/home" component={Home} />
              <Route path="/" component={Home} />
            </Switch>
          </BrowserRouter>  
        </Provider>
      </div>
      
    );
  }
}

export default App;
