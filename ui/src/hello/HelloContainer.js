import React from 'react';
import { connect } from 'react-redux';

import HelloComponent from './HelloComponent';
import NavBar from '../components/nav/NavBar';
import { sayHello, sayHelloAsync } from './hello';

class HelloContainer extends React.Component {
  render() {
    return (
      <div>
        <NavBar />
        <HelloComponent 
          message={this.props.message} 
          sayHello={this.props.sayHello}
          sayHelloAsync={this.props.sayHelloAsync}
          pending={this.props.pending}
        />
      </ div>
    );
  }
}

export default connect(
  state => (state.hello),
  { sayHello, sayHelloAsync }
)(HelloContainer);
