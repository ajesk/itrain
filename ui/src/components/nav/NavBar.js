import React from 'react';
import PropTypes from 'prop-types';
import { Field, reduxForm } from 'redux-form';
import NavItem from './NavItem'
import NavBrand from './NavBrand'
const log = require('simple-console-logger').getLogger('NavBar');

/**
 * Display a simple form with buttons to say hello. The
 * message field uses redux-form as an example of validation.
 */
var items = [{
    'name': 'Home',
    'path': '/'
},{
    'name': 'Tasks',
    'path': '/task'
},{
    'name': 'Users',
    'path': '/user'
},{    
    'name': 'Hello',
    'path': '/hello'
}].map(item => {
    return <NavItem name={item.name} path={item.path} />
});

class NavBar extends React.Component {
    render() {
        return (
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <NavBrand name='iTrain' />
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        {items}
                    </ul>
                </div>
            </nav>
        )
    }
}

export default NavBar;